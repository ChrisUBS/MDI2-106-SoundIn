package com.example.mdi2_106_soundin.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mdi2_106_soundin.ui.UserSessionViewModel
import com.example.mdi2_106_soundin.ui.theme.MDI2105SoundInTheme

@Composable
fun ProfileScreen(
    sessionViewModel: UserSessionViewModel,
    onLogout: () -> Unit
) {
    val userName by sessionViewModel.userName.collectAsStateWithLifecycle()
    val userEmail by sessionViewModel.userEmail.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // display user information Avatar with initials
        Box() {
            Text(
                text = userName.firstOrNull()?.uppercaseChar()?.toString() ?: "?",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

private val previewSessionViewModel: UserSessionViewModel = UserSessionViewModel()
@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    MDI2105SoundInTheme {
        ProfileScreen(
         sessionViewModel = previewSessionViewModel,
         onLogout = {}
        )
    }
}
