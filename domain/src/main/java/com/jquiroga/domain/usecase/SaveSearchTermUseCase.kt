package com.jquiroga.domain.usecase

import com.jquiroga.domain.repository.SearchRepository

class SaveSearchTermUseCase(private val searchRepository: SearchRepository) {

    suspend operator fun invoke(searchTerm: String) {
        searchRepository.saveSearchTerm(searchTerm)
    }
}