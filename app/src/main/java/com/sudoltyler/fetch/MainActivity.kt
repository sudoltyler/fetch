package com.sudoltyler.fetch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sudoltyler.fetch.ui.theme.FetchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FetchTheme {
                FetchApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FetchAppPreview() {
    FetchTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            FetchApp()
        }
    }
}