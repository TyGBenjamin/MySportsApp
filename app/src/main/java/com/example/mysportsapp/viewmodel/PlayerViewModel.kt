package com.example.mysportsapp.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mysportsapp.model.data.entity.FavPlayer
import com.example.mysportsapp.model.data.repositoryImpl.RepositoryImpl
import com.example.mysportsapp.utils.Constants
import com.example.mysportsapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class PlayerViewModel @Inject constructor(val repo:RepositoryImpl): ViewModel() {
    var state by mutableStateOf(PlayerState())
        private set

    fun getFavPlayer() = viewModelScope.launch {
        val playerList = repo.getFavoritePlayer()
        when (playerList){
            is Resource.Error -> TODO()
            Resource.Idle -> TODO()
            Resource.Loading -> TODO()
            is Resource.Success ->      state = state.copy(
                isLoading = false,
                playerList = playerList.data
            )
        }

    }

    data class PlayerState(
        var playerList: List<FavPlayer> = emptyList(),
        var isLoading: Boolean = false,
        var error: String = ""
    )
}
