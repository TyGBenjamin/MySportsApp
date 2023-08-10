package com.example.mysportsapp.model.data.repositoryImpl

import android.util.Log
import com.example.mysportsapp.model.data.entity.FavPlayer
import com.example.mysportsapp.remote.api.ApiService
import com.example.mysportsapp.repository.Repository
import com.example.mysportsapp.utils.Constants
import com.example.mysportsapp.utils.Resource
import com.example.mysportsapp.view.ErrorIndicator
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepositoryImpl @Inject constructor(private val apiService: ApiService) : Repository {
    override suspend fun getFavoritePlayer(player: String): Resource<List<FavPlayer>> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                apiResponse(player)
            } catch (e: IllegalArgumentException) {
                Resource.Error(e.message.toString())
            }
        }

    suspend fun apiResponse(player: String) = withContext(Dispatchers.IO) {
        val response = apiService.getFavoritePlayer(player)
        if (response.isSuccessful && response.body() != null) {
            val playerList = response.body()!!.player.map { it.toPlayer() }
            Resource.Success(playerList)
        } else {
            Resource.Error("error retrieving post")
        }
    }
}
