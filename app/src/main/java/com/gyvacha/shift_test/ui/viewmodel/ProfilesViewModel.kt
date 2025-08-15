package com.gyvacha.shift_test.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.gyvacha.shift_test.domain.repository.RandomUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfilesViewModel @Inject constructor(
    repository: RandomUserRepository
) : ViewModel() {

    val users = repository.getUsers(pageSize = 20)
        .cachedIn(viewModelScope)
}