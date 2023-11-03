package ru.rsttur.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.rsttur.data.repository.BlogRepositoryImpl
import ru.rsttur.data.repository.HomePageRepositoryImpl
import ru.rsttur.data.source.remote.ApiService
import ru.rsttur.domain.repository.BlogRepository
import ru.rsttur.domain.repository.HomePageRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideHomePageRepository(apiService: ApiService): HomePageRepository = HomePageRepositoryImpl(apiService)

    @Provides
    @Singleton
    fun provideBlogRepository(apiService: ApiService): BlogRepository = BlogRepositoryImpl(apiService)
}