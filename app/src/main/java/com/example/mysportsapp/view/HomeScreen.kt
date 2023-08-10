package com.example.mysportsapp.view

import android.annotation.SuppressLint
import android.util.Log
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import com.example.mysportsapp.utils.Constants
import com.example.mysportsapp.utils.Resource
import com.example.mysportsapp.viewmodel.PlayerViewModel


@SuppressLint("NotConstructor")
@Composable
fun HomeScreen(
    viewModel: PlayerViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
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
            var firstName by remember {
                mutableStateOf("")
            }
            var lastName by remember {
                mutableStateOf("")
            }


            IconGroup()
            Text(text = "Search your favorite popular athlete such as Kobe Bryant or Derek Jeter (please note the api used to build this does not have every athlete available")
            TextField(value = firstName, onValueChange = { firstName = it },
                label = { Label("enter first Name") })
            TextField(value = lastName, onValueChange = { lastName = it },
                label = { Label("enter last Name") })

            val (snackbarVisibleState, setSnackBarState) = remember {
                mutableStateOf(
                    false
                )
            }
            MyButton(
                text = "Search"
            ) {
                println("hitting viewmodel method")
                Log.d(
                    Constants
                        .VIEWMODEL_TAG, "HomeScreen testing: $firstName%20$lastName "
                )
                viewModel.getFavPlayer("$firstName " + lastName)
            }

            ListScreen(players = viewModel.state.playerList)

            DividerOne()
            Row(verticalAlignment = Alignment.CenterVertically) {
            }
        }
        Column {
            QuickText(text = "")
            Row(modifier = Modifier.padding(start = 145.dp)) {
                val (snackbarVisibleState, setSnackBarState) = remember {
                    mutableStateOf(
                        false
                    )
                }

                IconLabels(
                    resource = R.drawable.cloud_download,
                  )
                IconLabels(
                    resource = R.drawable.share_icon,

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
    Box(
        modifier = Modifier.padding(horizontal = 80.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth()) {
                IconOne(R.drawable.snowboarding_24)
                IconOne(R.drawable.sports_kabaddi_24)
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                IconOne(R.drawable.sports_basketball)
                IconOne(R.drawable.sports_baseball)
            }
        }
    }
}

@Suppress("FunctionNaming")
@Composable
fun IconOne(vectorAsset: Int) {
    Box(
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

@Composable
fun ErrorIndicator() {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(text = "ERROR IS RETRIEVING DATA", fontSize = 40.sp)
    }
}

@Suppress("FunctionNaming")
@Composable
fun IconLabels(resource: Int) {
    Box(
        modifier = Modifier.padding(5.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = resource),
            null,
            Modifier
                .size(50.dp)
                .padding(horizontal = 10.dp)
                .clickable {  },
            tint = Color.White
        )
    }
}

