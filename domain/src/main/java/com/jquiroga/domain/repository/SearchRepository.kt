package com.jquiroga.domain.repository

interface SearchRepository {

    suspend fun saveSearchTerm(searchTerm: String)

    suspend fun getAllSearchTerms(): List<String>
}