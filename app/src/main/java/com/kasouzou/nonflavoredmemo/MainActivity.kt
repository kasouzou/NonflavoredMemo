package com.kasouzou.nonflavoredmemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // エッジツーエッジ（全画面表示）を有効化
        enableEdgeToEdge()
        
        setContent {
            var text by remember { mutableStateOf("") }
            
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White) // 背景を完全な白に
                    .statusBarsPadding()     // ステータスバー（時計など）との被りを防ぐ
                    .imePadding()            // キーボードが表示された時に画面を自動で押し上げる
            ) {
                BasicTextField(
                    value = text,
                    onValueChange = { text = it },
                    textStyle = TextStyle(
                        fontSize = 20.sp,
                        color = Color.Black
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp) // 文字が画面の端に張り付かないように少しだけ余白を持たせる
                )
            }
        }
    }
}

