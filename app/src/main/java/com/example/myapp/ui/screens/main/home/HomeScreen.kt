package com.example.myapp.ui.screens.main.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import com.example.domain.models.Test
import com.example.myapp.MainViewModel
import org.koin.androidx.compose.getViewModel


@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: MainViewModel = getViewModel()
) {
    DataList(viewModel)
}

@Composable
private fun DataList(viewModel: MainViewModel) {

    var showSheet by remember { mutableStateOf(false) }
    val model = remember { mutableStateOf(Test()) }

    if (showSheet) {
        BottomSheet(test = model.value, onDismiss = {
            showSheet = false
        })
    }

    LazyColumn(
        modifier = Modifier
            .padding(
                horizontal = 40.dp,
                vertical = 60.dp
            )
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        items(items = viewModel.state.value) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .clickable {
                            model.value = it
                            showSheet = true
                        }
                        .size(150.dp),
                    contentAlignment = Alignment.Center
                ) {
                    SubcomposeAsyncImage(
                        alignment = Alignment.Center,
                        model = it.image,
                        contentDescription = "",
                        loading = { CircularProgressIndicator(modifier = Modifier.fillMaxSize()) }
                    )
                }

                Text(text = it.title.toString())
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(onDismiss: () -> Unit, test: Test) {
    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = rememberModalBottomSheetState()
    ) {

        Text(
            text = test.title.toString(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(),
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = test.price.toString() + " USD",
            modifier = Modifier
                .fillMaxWidth()
                .padding(),
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            style = MaterialTheme.typography.headlineMedium
        )

        Column(
            modifier = Modifier
                .padding(
                    horizontal = 40.dp,
                )
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {

            Row(
            ) {
                Box(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .size(150.dp),
                    contentAlignment = Alignment.TopCenter
                ) {

                    Column {
                        SubcomposeAsyncImage(
                            alignment = Alignment.TopCenter,
                            model = test.image,
                            contentDescription = "",
                            loading = { CircularProgressIndicator() }
                        )
                    }
                }

                Text(text = test.description.toString(), modifier = Modifier.padding(vertical = 20.dp))
            }
        }
    }
}