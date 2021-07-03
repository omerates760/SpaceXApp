package com.monofire.spacexapp.ui.home

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.monofire.spacexapp.R
import com.monofire.spacexapp.data.model.LauncherResponse
import com.monofire.spacexapp.databinding.HomeFragmentBinding
import com.monofire.spacexapp.ui.base.BaseFragment
import com.monofire.spacexapp.ui.home.adapter.LauncherAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<HomeFragmentBinding>() {


    private val viewModel: HomeViewModel by viewModel()
    private lateinit var adapter: LauncherAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        setHasOptionsMenu(true)
        setUpAdapter()
        initSearchObserver()

    }


    private fun setUpAdapter() {
        adapter = LauncherAdapter { launcher ->
        }
        binding.rcViewLauncher.adapter = adapter


    }

    private fun initSearchObserver() {
        viewModel.launchers.observe(viewLifecycleOwner) {
            it.onSuccess { result ->
                hideProgress()
                adapter.updateList(result)

            }.onApiError { error ->
                hideProgress()
                showServiceError(error)
            }.onLoading {
                showProgress()
            }


        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.search_menu, menu)

        val searchItem = menu.findItem(R.id.menu_search)
        val search = searchItem.actionView as SearchView
        val searchManager =
            requireActivity().getSystemService(Context.SEARCH_SERVICE) as SearchManager

        search.setSearchableInfo(searchManager.getSearchableInfo(requireActivity().componentName))
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    search.clearFocus()
                    searchItem.collapseActionView()
                    viewModel.checkQueryToSearch(query ?: "")
                        .observe(viewLifecycleOwner, launcherObserver)

                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })

    }

    private val launcherObserver = androidx.lifecycle.Observer<List<LauncherResponse>> { result ->
        adapter.updateList(result)

    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ViewDataBinding {
        return DataBindingUtil.inflate(layoutInflater, R.layout.home_fragment, container, false)
    }
}