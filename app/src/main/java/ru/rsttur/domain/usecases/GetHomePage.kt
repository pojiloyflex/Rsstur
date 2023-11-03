package ru.rsttur.domain.usecases

import ru.rsttur.domain.repository.HomePageRepository
import javax.inject.Inject

class GetHomePage @Inject constructor(private val homePageRepository: HomePageRepository) {
    suspend operator fun invoke() = homePageRepository.getHomePage()
}