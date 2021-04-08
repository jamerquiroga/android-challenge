package com.jquiroga.domain.usecase

import com.jquiroga.domain.repository.SearchRepository

class GetSearchHistoryUseCase(private val searchRepository: SearchRepository) {

    suspend operator fun invoke(): List<String> {
        return searchRepository.getAllSearchTerms()
    }
}