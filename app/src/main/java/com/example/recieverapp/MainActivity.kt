package com.example.recieverapp

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recieverapp.broadcast.MyBroadcastReceiver
import com.example.recieverapp.ui.theme.RecieverAppTheme

class MainActivity : ComponentActivity() {
// deeplink for this app is ->   "test://com.example.recieverapp/MainActivity"
    private val broadcastReceiver = MyBroadcastReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        registerReceiver(broadcastReceiver,
//            IntentFilter("com.occ.ow.REQUEST_STATE")
//        )
        setContent {
            RecieverAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier.fillMaxSize(),Arrangement.Center, Alignment.CenterHorizontally) {
                        Text(text = "Hello dear!! this is just a test app :) " , Modifier.background(Color.Yellow), color = Color.Black)
                    }

                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(broadcastReceiver,
            IntentFilter("com.occ.ow.REQUEST_STATE")
        )
    }


    override fun onPause() {
        super.onPause()
        unregisterReceiver(broadcastReceiver)
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        unregisterReceiver(broadcastReceiver)
//    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RecieverAppTheme {
        Greeting("Android")
    }
}