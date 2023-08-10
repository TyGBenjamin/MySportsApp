package com.example.mysportsapp.di


import com.example.mysportsapp.model.data.repositoryImpl.RepositoryImpl
import com.example.mysportsapp.remote.api.ApiService
import com.example.mysportsapp.repository.Repository
import com.example.mysportsapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRepoScope(): CoroutineScope {
        return CoroutineScope(SupervisorJob() + Dispatchers.IO)
    }

    @Provides
    fun providesRepostioryImpl(apiService: ApiService):
        Repository = RepositoryImpl(apiService )

    @Provides
    @Singleton
    fun providesApiService(): ApiService {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
