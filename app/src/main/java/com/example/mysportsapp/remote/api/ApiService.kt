package com.example.mysportsapp.remote.api

import com.example.mysportsapp.model.data.dto.FavoritePlayerResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(PLAYER_ENDPOINT)
    suspend fun getFavoritePlayer(@Query("p") player: String): Response<FavoritePlayerResponse>
    companion object{
        const val PLAYER_ENDPOINT = "searchplayers.php"
    }
}
