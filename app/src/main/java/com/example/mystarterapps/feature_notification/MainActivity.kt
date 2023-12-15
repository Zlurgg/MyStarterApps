package com.example.mystarterapps.feature_notification

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.mystarterapps.R
import com.example.mystarterapps.ui.theme.MyStarterAppsTheme
import dagger.hilt.android.AndroidEntryPoint

val CHANNEL_ID = "channel_id"
val CHANNEL_NAME = "channel_name"
val NOTIFICATION_ID = 0

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createNotificationChannel()
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Awesome Notification")
            .setContentText("This is the content text")
            .setSmallIcon(R.drawable.notification_icon)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        val notificationManager = NotificationManagerCompat.from(this)
        setContent {
            MyStarterAppsTheme {
                NotificationScreen(
                    notificationManager,
                    notification
                )
            }
        }
    }

    @SuppressLint("MissingPermission")
    @Composable
    private fun NotificationScreen(
        notificationManager: NotificationManagerCompat,
        notification: Notification
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Box {
                Button(
                    modifier = Modifier.align(Alignment.Center),
                    onClick = {
                        notificationManager.notify(
                            NOTIFICATION_ID,
                            notification
                        )
                    }
                ) {
                    Text(
                        "Create notification"
                    )
                }
            }
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val notificationChannel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                lightColor = android.graphics.Color.GREEN
                enableLights(true)
            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(notificationChannel)
        }
    }

}