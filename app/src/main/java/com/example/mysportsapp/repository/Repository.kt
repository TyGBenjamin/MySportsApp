package com.example.mysportsapp.repository

import com.example.mysportsapp.model.data.entity.FavPlayer
import com.example.mysportsapp.utils.Resource

interface Repository {
    suspend fun getFavoritePlayer(player: String = "Allen%20Iverson"): Resource<List<FavPlayer>>
}
