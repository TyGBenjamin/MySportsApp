package com.example.mysportsapp.model.data.repositoryImpl

import com.example.mysportsapp.model.data.dto.PlayerDTO
import com.example.mysportsapp.remote.api.ApiService
import com.example.mysportsapp.repository.Repository
import com.example.mysportsapp.utils.Resource
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepositoryImpl @Inject constructor(private val apiService: ApiService) : Repository {
    override suspend fun getFavoritePlayer(): Resource<List<PlayerDTO>> {
        TODO("Not yet implemented")
    }

    suspend fun apiResponse() = withContext(Dispatchers.IO) {
        val response = apiService.getFavoritePlayer()
        if (response.isSuccessful && response.body() != null) {
            val playerList = response.body()!!.player.map { it.toFavPlayer() }
            Resource.Success(playerList)
        } else {
            Resource.Error("error retrieving post")
        }
    }
}
