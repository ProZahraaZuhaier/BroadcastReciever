package com.example.recieverapp.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.util.Log
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import java.time.Duration

class MyBroadcastReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == "com.occ.ow.REQUEST_STATE"){

            Log.i("got broadcast ","${intent.action}")
            val responseIntent = Intent("com.occ.ow.RESPONSE_STATE")
            responseIntent.putExtra("deeplink","test://com.example.recieverapp/MainActivity")
            responseIntent.putExtra("packageName","com.example.recieverapp")

            context?.sendOrderedBroadcast(responseIntent,"com.occ.ow.manager.receive")

//            responseIntent.putExtra("deeplink","https://www.youtube.com/watch?v=NpEanZhCGUg&t=90")
//            responseIntent.putExtra("packageName","com.google.android.youtube")




        }

    }

    private fun isSystemApp(packageName: String, packageManager: PackageManager): Boolean {
        try {
            val packageInfo = packageManager.getPackageInfo(packageName, 0)
            return packageInfo.applicationInfo.flags and android.content.pm.ApplicationInfo.FLAG_SYSTEM != 0
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return false
    }
}