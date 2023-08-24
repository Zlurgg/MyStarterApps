package com.example.mystarterapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mystarterapps.feature_room.RoomApp
import com.example.mystarterapps.ui.theme.MyRoomSessionTheme
import com.ramcosta.composedestinations.DestinationsNavHost

class MainActivity : ComponentActivity() {
    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    override fun onCreate(savedInstanceState: Bundle?) {

        /** old way of initialising in main outside of compose **/
        /*        val entryViewModel by viewModels<EntryViewModel> {
            EntryViewModelFactory((this.applicationContext as EntryApplication).repository)
        }*/
        super.onCreate(savedInstanceState)
        setContent {
            MyRoomSessionTheme {
                RoomApp(/*entryViewModel*/)
//                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}


