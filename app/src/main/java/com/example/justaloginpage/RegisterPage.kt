package com.example.justaloginpage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import com.example.justaloginpage.ui.theme.LoginForm

@Composable
fun RegisterPage() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
            .verticalScroll(scrollState) // make it scrollable
            .imePadding().padding(20.dp), // padding when keyboard appears
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var isRegisterSelected by remember { mutableStateOf(true) }

        // Header
        Header(isRegisterSelected)

        Spacer(Modifier.height(25.dp))

        // Toggle Button
        ToggleButton(
            isRegisterSelected = isRegisterSelected,
            onToggle = { isRegisterSelected = it }
        )

        Spacer(modifier = Modifier.height(25.dp))

        // Form and Submit
        if (isRegisterSelected) {
            RegisterForm()
            Spacer(modifier = Modifier.height(30.dp))
            SubmitButton("Register")
        } else {
            LoginForm()
            Spacer(modifier = Modifier.height(30.dp))
            SubmitButton("Login")
        }
    }
}
