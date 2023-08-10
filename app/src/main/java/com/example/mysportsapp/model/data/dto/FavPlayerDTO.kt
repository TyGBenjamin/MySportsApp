package com.example.mysportsapp.model.data.dto

import com.example.mysportsapp.model.data.entity.FavPlayer

data class FavPlayerDTO(
    val idPlayer: String? = "",
    val idTeam: String? = "",
    val strDescriptionEN: String? = "",
//    val strDescriptionES: String,
    val strPlayer: String? = "",
    val strThumb: String? = "",

){
    /**
     * function to map PhotoDTO To Photo.
     *
     * @return
     */
    fun toFavPlayer(): FavPlayer {
        return FavPlayer(
            idPlayer = this.idPlayer ?: "",
            idTeam = this.idTeam ?: "",
            strDescriptionEN = this.strDescriptionEN ?: "",
            strPlayer = this.strPlayer ?: "",
            strThumb = this.strThumb ?: ""
        )
    }
}

