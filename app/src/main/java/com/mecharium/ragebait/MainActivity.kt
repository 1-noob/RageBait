package com.mecharium.ragebait

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.draw.scale
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalHapticFeedback
import android.media.MediaPlayer
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import com.mecharium.ragebait.ui.theme.RageBaitTheme
import androidx.compose.runtime.*
import kotlinx.coroutines.delay
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RageBaitTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                     PlayFahhh()
                }
            }
        }
    }

    @Composable
    fun PlayFahhh(modifier: Modifier = Modifier) {
        val context = LocalContext.current
        val haptic = LocalHapticFeedback.current
        val interactionSource = remember { MutableInteractionSource() }
        val isPressed by interactionSource.collectIsPressedAsState()

        val scale by animateFloatAsState(
            targetValue = if (isPressed) 0.92f else 1f,
            label = ""
        )

        var flashWhite by remember { mutableStateOf(false) }

        LaunchedEffect(flashWhite) {
            delay(120)
            flashWhite = false
        }


        val buttonColor by animateColorAsState(
            targetValue = if (flashWhite) Color.White else Color.Red,
            label = ""
        )

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {
                    // Haptic feedback
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)

                    val mediaPlayer = MediaPlayer.create(context, R.raw.fahhhhh)
                    mediaPlayer.start()

                    flashWhite = true
                },
                interactionSource = interactionSource,
                modifier = Modifier
                    .size(180.dp)
                    .scale(scale)
                    .shadow(
                        elevation = 16.dp,
                        shape = CircleShape,
                        clip = false
                    ),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonColor,
                    contentColor = if(flashWhite) Color.Red else Color.White
                ),
                elevation = ButtonDefaults.buttonElevation (
                    defaultElevation = 12.dp,
                    pressedElevation = 2.dp
                )
            ){
                Text(
                    text = "FAAH",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
