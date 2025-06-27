package com.artemissoftware.game.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemissoftware.game.domain.repository.GameRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class DetailsViewModel(
    private val gameRepository: GameRepository
) : ViewModel() {

    private val _state = MutableStateFlow(DetailsState())
    val state = _state.asStateFlow()


    fun getGameDetails(id: Int) {
        _state.update {
            it.copy(isLoading = true)
        }
        viewModelScope.launch {
            val result = gameRepository.getDetails(id)

            result
                .onSuccess { detail ->
                    _state.update {
                        it.copy(isLoading = false, data = detail)
                    }
                }
                .onFailure { error ->
                    _state.update {
                        it.copy(isLoading = false, error = error.message.toString())
                    }
                }
        }
    }

    fun save(id: Int, image: String, name: String) = viewModelScope.launch {
        gameRepository.save(id, image, name)
    }

    fun delete(id: Int) = viewModelScope.launch {
        gameRepository.delete(id)
    }

}
