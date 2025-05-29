package com.example.justaloginpage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SecureTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentType
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegisterForm() {
    var password = remember {
        mutableStateOf("")
    }
    var isPasswordVisible = remember {
        mutableStateOf(false)
    }
    val lightGreen = Color(0xFFeeff3f)
    val lightGrey = Color(0xFFdedfe0)
    Column() {
        Column {
            Text(
                text = "Full Name",
                fontSize = 18.sp,
                fontWeight = FontWeight.W400,
                modifier = Modifier.padding(start = 15.dp)
            )

            Spacer(modifier = Modifier.height(5.dp))
            TextField(
                state = rememberTextFieldState(""),
                inputTransformation = {},
                placeholder = { Text("Enter Your Name", fontSize = 16.sp) },
                shape = RoundedCornerShape(50.dp),
                lineLimits = TextFieldLineLimits.SingleLine,
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics {
                        contentType = ContentType.PersonFullName
                    },
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = lightGrey,
                    unfocusedContainerColor = lightGrey
                ),
                textStyle = TextStyle(fontSize = 20.sp, color = Color.Black),
                contentPadding = PaddingValues(start = 20.dp, end = 20.dp, top = 0.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

        }

        Spacer(modifier = Modifier.height(20.dp))
        Column {
            Text(
                text = "Email Address",
                fontSize = 18.sp,
                fontWeight = FontWeight.W400,
                modifier = Modifier.padding(start = 15.dp)
            )

            Spacer(modifier = Modifier.height(5.dp))
            TextField(
                state = rememberTextFieldState(""),
                inputTransformation = {},
                placeholder = { Text("Enter Your Email", fontSize = 16.sp) },
                shape = RoundedCornerShape(50.dp),
                lineLimits = TextFieldLineLimits.SingleLine,
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics {
                        contentType = ContentType.EmailAddress
                    },
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = lightGrey,
                    unfocusedContainerColor = lightGrey
                ),
                textStyle = TextStyle(fontSize = 20.sp, color = Color.Black),
                contentPadding = PaddingValues(start = 20.dp, end = 20.dp, top = 0.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

        }
        Spacer(modifier = Modifier.height(20.dp))
        Column {
            Text(
                text = "Password",
                fontSize = 18.sp,
                fontWeight = FontWeight.W400,
                modifier = Modifier.padding(start = 15.dp)
            )

            Spacer(modifier = Modifier.height(5.dp))

            println(password.value)
            TextField(
                value = password.value,
                onValueChange = { password.value = it },
                placeholder = { Text(text = "Password", fontSize = 16.sp) },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = lightGrey,
                    unfocusedContainerColor = lightGrey
                ),
                textStyle = TextStyle(fontSize = 20.sp, color = Color.Black),
//                contentPadding = PaddingValues(start = 20.dp, end = 20.dp, top = 0.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val visibleIconImage = if (isPasswordVisible.value)
                        Icons.Filled.Visibility
                    else
                        Icons.Filled.VisibilityOff

                    var description = if (isPasswordVisible.value)
                        "password is visible"
                    else
                        "password is hidden"

                    IconButton(onClick = { isPasswordVisible.value = !isPasswordVisible.value })
                    {
                        Icon(
                            imageVector = visibleIconImage,
                            contentDescription = description
                        )
                    }
                },
                visualTransformation = if (isPasswordVisible.value) VisualTransformation.None
                else
                    PasswordVisualTransformation(),

                )
        }
    }
}
