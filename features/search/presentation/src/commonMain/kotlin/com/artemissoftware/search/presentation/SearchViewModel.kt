package com.artemissoftware.search.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemissoftware.search.domain.repository.SearchRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class SearchViewModel(private val searchRepository: SearchRepository) : ViewModel() {

    private val _state = MutableStateFlow(SearchState())
    val state = _state.asStateFlow()

    private var searchJob: Job? = null

    fun updateQuery(query: String){

        searchJob?.cancel()

        if(query.isBlank()) {
            return
        }

        _state.update { it.copy(query = query) }
        search(query = query)
    }

    private fun search(query: String) = with(_state) {
        searchJob = viewModelScope.launch {

            delay(2.seconds)

            update {
                it.copy(isLoading = true)
            }

            val result = searchRepository.search(query = query)

            result
                .onSuccess { games ->
                    update {
                        it.copy(games = games, isLoading = true)
                    }
                }
                .onFailure { error ->
                    update {
                        it.copy(error = error.message.toString(), isLoading = true)
                    }
                }
        }
    }

}
