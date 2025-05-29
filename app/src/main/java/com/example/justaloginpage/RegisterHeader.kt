package com.example.justaloginpage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header(isRegisterToggle : Boolean){
    if(isRegisterToggle) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Create an account",
                fontSize = 26.sp, fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(7.dp))
            Text(text = "Already have an account? Log in", fontSize = 14.sp)
        }
    }

    else{
        Text(
            text = "Just Login into the Account",
            fontSize = 26.sp, fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )
    }
}