package ca.gbc.comp3074.tai_maria.lab9ex.components

import ca.gbc.comp3074.tai_maria.lab9ex.model.User

sealed interface UserUiState {
    data object Loading : UserUiState
    data class Success(val users: List<User>): UserUiState
    data class Error(val message: String) : UserUiState
}