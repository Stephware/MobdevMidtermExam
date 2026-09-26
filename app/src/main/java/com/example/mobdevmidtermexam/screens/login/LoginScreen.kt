package com.example.mobdevmidtermexam.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobdevmidtermexam.ui.theme.MobdevMidtermExamTheme
import com.example.mobdevmidtermexam.R

private val LoginBackground = Color(0xFF181817)
private val LoginBlue = Color(0xFF4C82D9)
private val LoginIconBackground = Color(0xFF082B5F)
private val LoginMuted = Color(0xFF9E9E9E)
private val LoginBorder = Color(0xFF3A3A3A)

@Composable
fun LoginScreen() {
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var errorMessage by remember {
        mutableStateOf("")
    }

    var showLoginDialog by remember {
        mutableStateOf(false)
    }

    var showForgotPasswordDialog by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LoginBackground)
            .padding(horizontal = 28.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(82.dp)
                .background(
                    color = LoginIconBackground,
                    shape = RoundedCornerShape(18.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.truck),
                contentDescription = "Truck Icon",
                tint = Color.White,
                modifier = Modifier.size(50.dp)
            )
        }


        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Welcome back",
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Sign in to continue",
            style = MaterialTheme.typography.bodyLarge,
            color = LoginMuted
        )

        Spacer(modifier = Modifier.height(34.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                errorMessage = ""
            },
            label = {
                Text(text = "Email")
            },
            placeholder = {
                Text(text = "yourname@gmail.com")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = LoginMuted,
                focusedBorderColor = LoginBlue,
                unfocusedBorderColor = LoginBorder,
                focusedPlaceholderColor = LoginMuted,
                unfocusedPlaceholderColor = LoginMuted,
                cursorColor = LoginBlue
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(14.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                errorMessage = ""
            },
            label = {
                Text(text = "Password")
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = LoginMuted,
                focusedBorderColor = LoginBlue,
                unfocusedBorderColor = LoginBorder,
                cursorColor = LoginBlue
            ),
            modifier = Modifier.fillMaxWidth()
        )

        if (errorMessage.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(22.dp))

        Button(
            onClick = {
                errorMessage = when {
                    email.isBlank() -> "Email is required."
                    password.isBlank() -> "Password is required."
                    else -> ""
                }

                if (errorMessage.isEmpty()) {
                    showLoginDialog = true
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = LoginBlue,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp)
        ) {
            Text(
                text = "Sign in",
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(
            onClick = {
                showForgotPasswordDialog = true
            }
        ) {
            Text(
                text = "Forgot password?",
                color = LoginBlue,
                fontWeight = FontWeight.SemiBold
            )
        }
    }

    if (showLoginDialog) {
        AlertDialog(
            onDismissRequest = {
                showLoginDialog = false
            },
            text = {
                Text(
                    text = "Logging in as ${email.trim()}",
                    textAlign = TextAlign.Center
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showLoginDialog = false
                    }
                ) {
                    Text(text = "OK")
                }
            }
        )
    }

    if (showForgotPasswordDialog) {
        AlertDialog(
            onDismissRequest = {
                showForgotPasswordDialog = false
            },
            text = {
                Text(
                    text = "Work in progress",
                    textAlign = TextAlign.Center
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showForgotPasswordDialog = false
                    }
                ) {
                    Text(text = "OK")
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    MobdevMidtermExamTheme(
        darkTheme = true,
        dynamicColor = false
    ) {
        LoginScreen()
    }
}
