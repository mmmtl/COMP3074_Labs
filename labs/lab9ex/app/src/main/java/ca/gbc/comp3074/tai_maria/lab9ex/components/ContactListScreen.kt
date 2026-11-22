package ca.gbc.comp3074.tai_maria.lab9ex.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ca.gbc.comp3074.tai_maria.lab9ex.api.RetrofitInstance
import ca.gbc.comp3074.tai_maria.lab9ex.model.User
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.clickable


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactListScreen(
    onContactClick: (Int) -> Unit
){
    var uiState by remember {
        mutableStateOf<UserUiState>(UserUiState.Loading)
    }

    LaunchedEffect(Unit) {
        uiState = try {
            val users = RetrofitInstance.api.getUsers()
            UserUiState.Success(users)
        } catch (e: Exception){
            UserUiState.Error(e.message?: "Unknown Error")
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Contact List") }
            )
        }
    ) { paddingValues ->
        when(val state = uiState){
            UserUiState.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center

                ){
                    CircularProgressIndicator()
                }
            }

            is UserUiState.Success -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    items(
                        items = state.users,
                        key = { it.id }
                    ){
                        user ->
                        ContactRow(
                            user = user,
                            onClick = {onContactClick(user.id)}
                        )
                    }
                }
            }

            is UserUiState.Error -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(24.dp),
                    contentAlignment = Alignment.Center

                ){
                    Text("Error: ${state.message}")
                }
            }
        }
    }
}

@Composable
fun ContactRow(
    user: User,
    onClick: () -> Unit
) {
    ListItem(
        headlineContent = {
            Text(
                text = user.name,
                fontWeight = FontWeight.SemiBold
            )
        },
        supportingContent = {
            Text(user.email)
        },
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    )

    HorizontalDivider()
}
