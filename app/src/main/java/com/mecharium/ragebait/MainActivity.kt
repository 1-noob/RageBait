package com.mecharium.ragebait

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.hapticfeedback.HapticFeedback
import androidx.compose.ui.platform.LocalHapticFeedback
import android.media.MediaPlayer
import androidx.compose.material3.Surface
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import com.mecharium.ragebait.ui.theme.RageBaitTheme


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
                },
                modifier = Modifier.size(120.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                )
            ) {
                Text("FAAH")
            }
        }
    }
}
