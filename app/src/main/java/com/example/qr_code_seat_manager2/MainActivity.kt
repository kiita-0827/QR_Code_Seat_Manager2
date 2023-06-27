package com.example.qr_code_seat_manager2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.qr_code_seat_manager2.ui.theme.QR_Code_Seat_Manager2Theme
//exitProcess
import kotlin.system.exitProcess
//Context
import android.content.Context
//PackageManager
import android.content.pm.PackageManager


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QR_Code_Seat_Manager2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")

                    //val hasCamera = false // カメラの有無を表すフラグ（true: カメラあり, false: カメラなし）

                    val hasCamera = checkCameraHardware(this) // カメラの有無を表すフラグ（true: カメラあり, false: カメラなし）

                    startCamera(hasCamera)

                }
            }
        }
    }
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
    QR_Code_Seat_Manager2Theme {
        Greeting("Android")

    }
}

/** このデバイスにカメラが搭載されているかどうかを確認する */


private fun checkCameraHardware(context: Context): Boolean {
    if (context.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
        // このデバイスにはカメラが付いています
        return true
    } else {
        // このデバイスにはカメラがありません
        return false
    }
}


fun startCamera(hasCamera: Boolean) {
    if (hasCamera) {
        // カメラを起動する処理
        println("カメラを起動しました")
    } else {
        println("カメラがありません、アプリを終了します")
        // アプリを終了する処理
        // ここではシステムを終了する代わりに、プログラムを終了させるために exitProcess(0) を呼び出しています
        exitProcess(0)
    }
}