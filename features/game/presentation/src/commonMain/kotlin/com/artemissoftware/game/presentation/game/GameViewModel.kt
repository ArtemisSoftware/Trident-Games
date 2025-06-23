package com.artemissoftware.game.presentation.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemissoftware.game.domain.repository.GameRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GameViewModel(
    private val gameRepository: GameRepository
) : ViewModel() {

    private val _state = MutableStateFlow(GameState())
    val state = _state.asStateFlow()

    init {
        getGames()
    }

    private fun getGames() = with(_state) {

        viewModelScope.launch {

            update {
                it.copy(isLoading = true)
            }

            val result = gameRepository.getGames()

            result
                .onSuccess { data ->
                    update {
                        it.copy(isLoading = false, data = data)
                    }
                }
                .onFailure { error ->
                    update {
                        it.copy(isLoading = false, error = error.message.toString())
                    }
                }
        }
    }

}