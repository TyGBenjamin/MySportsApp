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
                Log.d(Constants.REPO_TAG, "getFavoritePlayer: REPO SHOWING PLAYER AS$player")
                apiResponse(player)
            } catch (e: IllegalArgumentException) {
                Resource.Error(e.message.toString())
            }
        }

    suspend fun apiResponse(player: String) = withContext(Dispatchers.IO) {
        Log.d(Constants.REPO_TAG, "API RESPONSE SHOWING $player as ")
        val response = apiService.getFavoritePlayer(player)
        Log.d(Constants.REPO_TAG, "apiResponse IS AS FOLLOWS: $response ")
        if (response.isSuccessful && response.body() != null) {
            val playerList = response.body()!!.player.map { it.toPlayer() }
            Resource.Success(playerList)
        } else {
            Resource.Error("error retrieving post")
        }
    }
}
