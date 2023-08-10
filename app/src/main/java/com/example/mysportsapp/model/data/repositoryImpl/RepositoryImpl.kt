package com.example.mysportsapp.model.data.repositoryImpl


import com.example.mysportsapp.model.data.entity.FavPlayer
import com.example.mysportsapp.remote.api.ApiService
import com.example.mysportsapp.repository.Repository
import com.example.mysportsapp.utils.Resource
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepositoryImpl @Inject constructor(private val apiService: ApiService) : Repository {
    override suspend fun getFavoritePlayer(): Resource<List<FavPlayer>> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                apiResponse()
            } catch (e: IllegalArgumentException) {
                Resource.Error(e.message.toString())
            }
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
