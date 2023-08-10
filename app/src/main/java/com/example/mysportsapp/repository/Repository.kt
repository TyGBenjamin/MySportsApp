package com.example.mysportsapp.repository

import com.example.mysportsapp.model.data.dto.FavPlayerDTO
import com.example.mysportsapp.model.data.dto.PlayerDTO
import com.example.mysportsapp.model.data.entity.FavPlayer
import com.example.mysportsapp.utils.Resource

interface Repository {
    suspend fun getFavoritePlayer(): Resource<List<FavPlayer>>
}
