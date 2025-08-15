package com.gyvacha.shift_test.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.gyvacha.shift_test.R
import com.gyvacha.shift_test.domain.model.navigation.AppNavigation
import com.gyvacha.shift_test.ui.components.ProfileCard
import com.gyvacha.shift_test.ui.components.RandomUserPlaceholder
import com.gyvacha.shift_test.ui.components.TopAppBarWithBackButton
import com.gyvacha.shift_test.ui.utils.LocalMessageNotifier
import com.gyvacha.shift_test.ui.viewmodel.ProfilesViewModel
import com.gyvacha.shift_test.utils.pagingItems
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilesScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: ProfilesViewModel = hiltViewModel()
) {
    var isPtrLoading by rememberSaveable { mutableStateOf(false) }

    val pagingUsers = viewModel.users.collectAsLazyPagingItems()
    val snackBarNotifier = LocalMessageNotifier.current
    val isRefreshing = isPtrLoading && pagingUsers.loadState.refresh is LoadState.Loading
    val pullRefreshState = rememberPullToRefreshState()

    val unknownHostExceptionText = stringResource(R.string.no_internet_connection)
    val socketTimeoutExceptionText = stringResource(R.string.query_timeout)
    val httpExceptionText = stringResource(R.string.http_error)
    val unknownErrorText = stringResource(R.string.unknown_error)

    LaunchedEffect(pagingUsers.loadState) {
        val errorState = when {
            pagingUsers.loadState.refresh is LoadState.Error -> pagingUsers.loadState.refresh as LoadState.Error
            pagingUsers.loadState.append is LoadState.Error -> pagingUsers.loadState.append as LoadState.Error
            pagingUsers.loadState.prepend is LoadState.Error -> pagingUsers.loadState.prepend as LoadState.Error
            else -> null
        }

        errorState?.let { error ->
            when (error.error) {
                is UnknownHostException -> snackBarNotifier?.showSnackBar(unknownHostExceptionText)
                is SocketTimeoutException -> snackBarNotifier?.showSnackBar(
                    socketTimeoutExceptionText
                )

                is HttpException -> snackBarNotifier?.showSnackBar(httpExceptionText)
                else -> snackBarNotifier?.showSnackBar(unknownErrorText)
            }
            Log.e("ProfilesScreen", "Ошибка загрузки", error.error)
        }
    }

    LaunchedEffect(pagingUsers.loadState.refresh) {
        if (pagingUsers.loadState.refresh !is LoadState.Loading) {
            isPtrLoading = false
        }
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBarWithBackButton(
                screenTitle = stringResource(R.string.profiles),
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = navController::navigateUp,
            )
        }
    ) { padding ->
        PullToRefreshBox(
            modifier = Modifier.padding(padding),
            isRefreshing = isRefreshing,
            state = pullRefreshState,
            onRefresh = {
                isPtrLoading = true
                pagingUsers.refresh()
            }
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                pagingItems(pagingUsers, key = { it.login.uuid }) { user ->
                    if (user == null) {
                        RandomUserPlaceholder()
                    } else {
                        ProfileCard(user) {
                            navController.navigate(AppNavigation.ProfileInfo(user.login.uuid)) {
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }

                    item {
                        if (!isRefreshing && pagingUsers.loadState.append is LoadState.Loading) {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(dimensionResource(R.dimen.large_padding))
                                    .wrapContentWidth(Alignment.CenterHorizontally)
                            )
                        }
                    }
                }
            }
        }
    }
}