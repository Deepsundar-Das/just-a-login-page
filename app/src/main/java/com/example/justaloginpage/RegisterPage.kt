package com.example.justaloginpage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.justaloginpage.ui.theme.LoginForm

@Composable
fun RegisterPage() {
    var isRegisterSelected by remember {
        mutableStateOf(true)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Header(isRegisterSelected)

        Spacer(Modifier.height(25.dp))

        ToggleButton(isRegisterSelected = isRegisterSelected, onToggle = { isRegisterSelected = it }
        )

        if (isRegisterSelected){
            RegisterForm()
            Spacer(modifier = Modifier.height(50.dp))
            SubmitButton("Register")

        }

        else{
            LoginForm()
            Spacer(modifier = Modifier.height(50.dp))
            SubmitButton("Login")
        }

    }
}
