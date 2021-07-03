package com.monofire.spacexapp.data.repository

import com.monofire.spacexapp.data.local.dao.LauncherDao
import com.monofire.spacexapp.data.model.LauncherResponse
import com.monofire.spacexapp.data.remote.service.LauncherApi
import com.monofire.spacexapp.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

// Code with ❤
//┌─────────────────────────────┐
//│ Created by Ömer ATEŞ        │
//│ ─────────────────────────── │
//│ omerates760@gmail.com       │
//│ ─────────────────────────── │
//│ 3.07.2021 - 14:09          │
//└─────────────────────────────┘
class LauncherRepository(private val service: LauncherApi, private val dao: LauncherDao) :
    BaseRepository() {
    suspend fun fetchLaunchers(): Flow<Resource<List<LauncherResponse>>> {
        return flow {
            emit(performApiCall(call = { service.fetchLaunches() }))
        }.map { launchers ->
            launchers.onSuccess {launcherList->
                if (!launcherList.isNullOrEmpty()) {
                    dao.insertAllLaunchers(launcherList)
                }
            }
            launchers
        }
            .flowOn(Dispatchers.IO)
    }

    fun filterLauncher(query: String): Flow<List<LauncherResponse>> {
        return flow {
            emit(dao.filterLauncher(query))
        }.flowOn(Dispatchers.IO)
    }
}