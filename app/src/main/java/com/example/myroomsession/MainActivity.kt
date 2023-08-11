package com.example.myroomsession

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.myroomsession.data.EntryApplication
import com.example.myroomsession.ui.theme.MyRoomSessionTheme

class MainActivity : ComponentActivity() {
    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    override fun onCreate(savedInstanceState: Bundle?) {

        /** old way of initailising in main outside of compose **/
        /*        val entryViewModel by viewModels<EntryViewModel> {
            EntryViewModelFactory((this.applicationContext as EntryApplication).repository)
        }*/
        super.onCreate(savedInstanceState)
        setContent {
            MyRoomSessionTheme {
                EntryScreen(/*entryViewModel*/)
            }
        }
    }
}


