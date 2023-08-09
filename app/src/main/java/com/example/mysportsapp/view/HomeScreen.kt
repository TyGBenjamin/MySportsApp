package com.example.mysportsapp.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mysportsapp.R


@SuppressLint("NotConstructor")
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            Modifier
                .padding(24.dp)
                .wrapContentSize()
                .background(Color.Black),
            verticalArrangement = Arrangement.spacedBy(
                13.dp,
                alignment = Alignment.Bottom
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var value by remember {
                mutableStateOf("")
            }


            IconOne(R.drawable.snowboarding_24)
            TextField(value = value, onValueChange = { value = it },
                label = { Label("search Name of Favorite Player") })

            val (snackbarVisibleState, setSnackBarState) = remember {
                mutableStateOf(
                    false
                )
            }
            MyButton(
                text = "Search Favorite Player",
                action = {
                    setSnackBarState(!snackbarVisibleState)
//                        dashboardViewModel.addContactNew(addedContact)
                })
            if (snackbarVisibleState) {
                Snackbar(
                    action = {
                        Button(onClick = {
                            setSnackBarState(!snackbarVisibleState)
                        }) {
                            Text(text = "hide the snackbar")
                        }
                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Column() {
                        Text(text = "The snackbar is showing")
                    }
                }
            }
            DividerOne()
            Row(verticalAlignment = Alignment.CenterVertically) {
            }
        }
        Column {
            QuickText(text = "")
            Row(modifier = Modifier.padding(start = 145.dp)) {
//                                IconLabels(resource = R.drawable.ic_baseline_perm_phone_msg_24,
//                                    navigate = { findNavController().navigate(R.id.addPhoneFragment) })
                IconLabels(
                    resource = R.drawable.cloud_download,
                    navigate = {
//                            findNavController().navigate(R.id.addEmailFragment)
                    })
                IconLabels(
                    resource = R.drawable.share_icon,
                    navigate = {
//                            findNavController().navigate(R.id.addAddressFragment)
                    }
                )
            }
            DividerOne()
            MyButton(
                text = "Clear List",
                action = {
//                        findNavController().navigate(R.id.dashboardFragment)
                }
            )
        }
    }
}

@Suppress("FunctionNaming")
@Composable
fun MyButton(text: String, action: () -> Unit) {
    Button(
        onClick = {
            action()
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
    ) {
        Text(
            text = text,
            fontSize = 20.sp,
            color = Color.Black
        )
    }
}

@Suppress("FunctionNaming")
@Composable
fun DividerOne() {
    Divider(
        color = Color.White.copy(alpha = 0.3f),
        thickness = 1.dp,
        modifier = Modifier.padding(top = 48.dp)
    )
}

@Suppress("FunctionNaming")
@Composable
fun IconGroup() {
    Column(modifier = Modifier.fillMaxWidth()) {

    }

}

@Suppress("FunctionNaming")
@Composable
fun IconOne(vectorAsset: Int) {
    Box(
        modifier = Modifier.padding(5.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = vectorAsset),
            null,
            Modifier.size(100.dp),
            tint = Color.White
        )
    }
}

@Suppress("FunctionNaming")
@Composable
fun Label(typeInput: String = "Show Result") {
    Text(
        text = typeInput,
        fontSize = 9.sp
    )
}

@Suppress("FunctionNaming")
@Composable
fun QuickText(text: String) {
    Text(
        text = text,
        fontFamily = MaterialTheme.typography.titleLarge.fontFamily,
        color = Color.White,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(start = 70.dp, bottom = 10.dp)
    )
}

@Suppress("FunctionNaming")
@Composable
fun IconLabels(resource: Int, navigate: () -> Unit) {
    Box(
        modifier = Modifier.padding(5.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = resource),
            null,
            Modifier
                .size(50.dp)
                .clickable { navigate() },
            tint = Color.White
        )
    }
}

