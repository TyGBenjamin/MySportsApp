package com.example.mysportsapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mysportsapp.model.data.repositoryImpl.RepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor(val repo:RepositoryImpl): ViewModel() {
}
