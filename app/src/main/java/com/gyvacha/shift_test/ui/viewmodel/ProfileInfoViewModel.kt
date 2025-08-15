package com.gyvacha.shift_test.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gyvacha.shift_test.domain.repository.RandomUserRepository
import com.gyvacha.shift_test.ui.state.ProfileInfoUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileInfoViewModel @Inject constructor(
    private val repositoryImpl: RandomUserRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileInfoUiState())
    val uiState = _uiState.asStateFlow()

    fun getProfileInfo(id: String) {
        viewModelScope.launch {
            val profile = repositoryImpl.getUser(id)
            _uiState.update {
                it.copy(profile)
            }
        }
    }
}