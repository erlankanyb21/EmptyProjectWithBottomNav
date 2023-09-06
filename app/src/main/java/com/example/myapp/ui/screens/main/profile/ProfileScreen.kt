package com.example.myapp.ui.screens.main.profile

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import androidx.constraintlayout.compose.layoutId
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.myapp.R
import com.example.myapp.ui.Screen

@Composable
fun ProfileScreen(
    navController: NavController
) {

}

@OptIn(ExperimentalMotionApi::class)
@Composable
fun VariantTwo(progress: Float) {
    val context = LocalContext.current
    val motionScene = remember {
        context.resources.openRawResource(R.raw.motion_scene)
            .readBytes()
            .decodeToString()
    }

    MotionLayout(
        motionScene = MotionScene(content = motionScene),
        progress = progress,
        modifier = Modifier
            .padding(vertical = 50.dp)
            .background(Color.DarkGray.copy(alpha = 0.4f))
            .fillMaxWidth()
    ) {
        val props = motionProperties("profile_pic")

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.DarkGray)
                .layoutId("box")
        )
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            modifier = Modifier
                .clip(CircleShape)
                .border(
                    width = 2.dp,
                    color = props.value.color("background"),
                    shape = CircleShape
                )
                .layoutId("profile_pic")
        )
        Text(
            text = "Noname",
            fontSize = 24.sp,
            modifier = Modifier.layoutId("username"),
            color = props.value.color("background")
        )
    }
}

@Composable
private fun VariantOne(navController: NavController) {
    var isEditing by remember { mutableStateOf(false) }
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    val userName by remember { mutableStateOf("John Doe") }
    val userDescription by remember { mutableStateOf("Lover of life, coding, and coffee ☕") }

    val singlePhotoLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent(),
            onResult = { uri ->
                selectedImageUri = uri
                // Здесь вы можете добавить логику сохранения изображения в вашем приложении
                // Например, загрузку на сервер или сохранение в базу данных
            })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = if (selectedImageUri != null) rememberAsyncImagePainter(model = selectedImageUri) else painterResource(
                id = R.drawable.ic_launcher_foreground
            ),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .padding(vertical = 40.dp)
                .size(160.dp)
                .clip(CircleShape)
                .background(Color.Gray)
                .clickable {
                    if (isEditing) {
                        singlePhotoLauncher.launch("image/*")
                    }
                },
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = userName, fontWeight = FontWeight.Bold, fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = userDescription, color = Color.Gray, fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (isEditing) {
            Button(
                onClick = { isEditing = false }, modifier = Modifier.align(Alignment.End)
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Save")
            }
        } else {
            Button(
                onClick = {
                    isEditing = true
                }, modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = "Edit Profile")
            }
        }

        Button(onClick = {
            navController.navigate(Screen.Stats.route)
        }) {
            Text(text = "ToGallery")
        }
    }
}
