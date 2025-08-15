package com.gyvacha.shift_test.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.gyvacha.shift_test.R
import com.gyvacha.shift_test.ui.components.ProfileInfoCard
import com.gyvacha.shift_test.ui.components.ProfileInfoText
import com.gyvacha.shift_test.ui.components.ProfilePhoto
import com.gyvacha.shift_test.ui.components.TopAppBarWithBackButton
import com.gyvacha.shift_test.ui.viewmodel.ProfileInfoViewModel
import com.gyvacha.shift_test.utils.formatDate
import com.gyvacha.shift_test.utils.openDialer
import com.gyvacha.shift_test.utils.openMail
import com.gyvacha.shift_test.utils.openMap

@Composable
fun ProfileInfoScreen(
    navController: NavController,
    profileId: String,
    modifier: Modifier = Modifier,
    viewModel: ProfileInfoViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val scrollState = rememberScrollState()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.getProfileInfo(profileId)
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBarWithBackButton(
                screenTitle = stringResource(R.string.profile),
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = navController::navigateUp
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
                .verticalScroll(scrollState)
        ) {
            ProfilePhoto(
                uiState.randomUser?.picture?.large.orEmpty(),
                modifier = Modifier.fillMaxWidth()
                    .height(dimensionResource(R.dimen.large_photo_height))
            )
            ProfileInfoCard(
                title = stringResource(R.string.main_info),
                initialExpanded = true
            ) {
                ProfileInfoText(
                    title = stringResource(R.string.name),
                    info = uiState.randomUser?.name?.getFullName().orEmpty()
                )
                ProfileInfoText(
                    title = stringResource(R.string.gender),
                    info = uiState.randomUser?.gender.orEmpty()
                )
                ProfileInfoText(
                    title = stringResource(R.string.birth_day),
                    info = formatDate(uiState.randomUser?.dob?.date)
                )
                ProfileInfoText(
                    title = stringResource(R.string.age),
                    info = uiState.randomUser?.dob?.age?.toString().orEmpty()
                )
                ProfileInfoText(
                    title = stringResource(R.string.nationality),
                    info = uiState.randomUser?.nat.orEmpty()
                )
                ProfileInfoText(
                    title = stringResource(R.string.document),
                    info = uiState.randomUser?.id?.getDocument().orEmpty()
                )
            }

            ProfileInfoCard(
                title = stringResource(R.string.contacts),
                initialExpanded = false
            ) {
                ProfileInfoText(
                    title = stringResource(R.string.email),
                    info = uiState.randomUser?.email.orEmpty()
                ) {
                    IconButton(
                        onClick = {
                            openMail(uiState.randomUser?.email.orEmpty(), context)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = stringResource(R.string.open_email)
                        )
                    }
                }
                ProfileInfoText(
                    title = stringResource(R.string.cell_phone),
                    info = uiState.randomUser?.phone.orEmpty()
                ) {
                    IconButton(
                        onClick = {
                            openDialer(uiState.randomUser?.phone.orEmpty(), context)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Phone,
                            contentDescription = stringResource(R.string.open_call)
                        )
                    }
                }
                ProfileInfoText(
                    title = stringResource(R.string.phone),
                    info = uiState.randomUser?.cell.orEmpty()
                ) {
                    IconButton(
                        onClick = {
                            openDialer(uiState.randomUser?.cell.orEmpty(), context)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Phone,
                            contentDescription = stringResource(R.string.open_call)
                        )
                    }
                }
            }
            ProfileInfoCard(
                title = stringResource(R.string.location),
                initialExpanded = false
            ) {
                ProfileInfoText(
                    title = stringResource(R.string.address),
                    info = uiState.randomUser?.location?.getAddress().orEmpty()
                )
                ProfileInfoText(
                    title = stringResource(R.string.coordinates),
                    info = uiState.randomUser?.location?.coordinates?.getCoordinates().orEmpty()
                ) {
                    IconButton(
                        onClick = {
                            openMap(
                                latitude = uiState.randomUser?.location?.coordinates?.latitude?.toDouble() ?: 0.0,
                                longitude = uiState.randomUser?.location?.coordinates?.longitude?.toDouble() ?: 0.0,
                                context = context
                            )
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = stringResource(R.string.open_map)
                        )
                    }
                }
                ProfileInfoText(
                    title = stringResource(R.string.time_zone),
                    info = uiState.randomUser?.location?.timezone?.getTimezone().orEmpty()
                )
            }
            ProfileInfoCard(
                title = stringResource(R.string.profile_info),
                initialExpanded = false
            ) {
                ProfileInfoText(
                    title = stringResource(R.string.uuid),
                    info = uiState.randomUser?.login?.uuid.orEmpty()
                )
                ProfileInfoText(
                    title = stringResource(R.string.username),
                    info = uiState.randomUser?.login?.username.orEmpty()
                )
                ProfileInfoText(
                    title = stringResource(R.string.password),
                    info = uiState.randomUser?.login?.password.orEmpty()
                )
                ProfileInfoText(
                    title = stringResource(R.string.salt),
                    info = uiState.randomUser?.login?.salt.orEmpty()
                )
                ProfileInfoText(
                    title = stringResource(R.string.md5),
                    info = uiState.randomUser?.login?.md5.orEmpty()
                )
                ProfileInfoText(
                    title = stringResource(R.string.sha1),
                    info = uiState.randomUser?.login?.sha1.orEmpty()
                )
                ProfileInfoText(
                    title = stringResource(R.string.sha256),
                    info = uiState.randomUser?.login?.sha256.orEmpty()
                )
                ProfileInfoText(
                    title = stringResource(R.string.register_date),
                    info = formatDate(uiState.randomUser?.registered?.date)
                )
                ProfileInfoText(
                    title = stringResource(R.string.register_age),
                    info = uiState.randomUser?.registered?.age.toString()
                )
            }
        }
    }
}