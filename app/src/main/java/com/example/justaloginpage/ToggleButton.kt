package com.example.justaloginpage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.justaloginpage.ui.theme.LoginForm

@Composable
fun ToggleButton(isRegisterSelected: Boolean,
                 onToggle: (Boolean) -> Unit) {
    val lightGrey = Color(0xFFdedfe0)
    val black = Color.Black
    val white = Color.White
    println("I am in toggleButton")
//    val isRegisterSelected = remember {
//        mutableStateOf(true)
//    }
    val loginTextColor = remember {
        mutableStateOf(Color.Black)
    }
    val registerTextColor = remember {
        mutableStateOf(Color.White)
    }

    val unToggleColor = remember {
        mutableStateOf(lightGrey)
    }

    val ToggleColor = remember {
        mutableStateOf(black)
    }
    Row(
        modifier = Modifier
            .width(350.dp)
            .background(shape = RoundedCornerShape(50.dp), color = lightGrey)
            .padding(5.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = {
                if (isRegisterSelected == true) {
                    unToggleColor.value = black
                    ToggleColor.value = lightGrey
                    loginTextColor.value = white
                    registerTextColor.value = black

                }
                if (isRegisterSelected) onToggle(false)
            },
            modifier = Modifier
                .height(50.dp)
                .width(150.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = unToggleColor.value,
                contentColor = loginTextColor.value
            )

        ) {
            Text(
                text = "Login",
                fontSize = 23.sp,
                fontWeight = FontWeight.W400
            )
        }

        Button(
            onClick = {
                if (isRegisterSelected == false) {
                    ToggleColor.value = black
                    unToggleColor.value = lightGrey
                    loginTextColor.value = black
                    registerTextColor.value = white
                }
                if (!isRegisterSelected) onToggle(true)
            },
            modifier = Modifier
                .height(50.dp)
                .width(150.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = ToggleColor.value,
                contentColor = registerTextColor.value
            )
        ) {
            Text(
                text = "Register",
                fontSize = 23.sp,
                fontWeight = FontWeight.W400
            )
        }
    }
    Spacer(modifier = Modifier.height(50.dp))


}
