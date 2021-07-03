package com.monofire.spacexapp.ui.home

import androidx.lifecycle.*
import com.monofire.spacexapp.data.model.LauncherResponse
import com.monofire.spacexapp.data.repository.LauncherRepository
import com.monofire.spacexapp.util.Resource
import com.monofire.spacexapp.util.ext.searchQueryText
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: LauncherRepository) : ViewModel() {
    private val _launchers = MutableLiveData<Resource<List<LauncherResponse>>>()
    val launchers: LiveData<Resource<List<LauncherResponse>>> get() = _launchers

    init {
        fetchAllCoins()
    }

    private fun fetchAllCoins() {
        viewModelScope.launch {
            repository.fetchLaunchers().onStart {
                _launchers.postValue(Resource.Loading)
            }.collect { result ->
                result.onSuccess { response ->
                    if (!response.isNullOrEmpty()) {
                        _launchers.postValue(Resource.Success(response))
                    } else {
                        _launchers.postValue(Resource.EmptySuccess)
                    }
                }
            }
        }
    }

    fun checkQueryToSearch(query: String) =
        repository.filterLauncher(query.searchQueryText()).asLiveData()

}