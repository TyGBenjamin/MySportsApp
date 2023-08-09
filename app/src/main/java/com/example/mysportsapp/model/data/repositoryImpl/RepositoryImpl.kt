package com.example.mysportsapp.model.data.repositoryImpl

import com.example.mysportsapp.model.data.dto.PlayerDTO
import com.example.mysportsapp.remote.api.ApiService
import com.example.mysportsapp.repository.Repository
import com.example.mysportsapp.utils.Resource
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: ApiService) : Repository {
    override suspend fun getFavoritePlayer(): Resource<List<PlayerDTO>> {
        TODO("Not yet implemented")
    }
}
