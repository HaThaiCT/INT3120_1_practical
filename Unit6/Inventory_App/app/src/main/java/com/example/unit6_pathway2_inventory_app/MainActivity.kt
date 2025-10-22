package com.example.unit6_pathway2_inventory_app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.inventory.InventoryApp
import com.example.unit6_pathway2_inventory_app.ui.theme.Unit6_Pathway2_Inventory_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        Log.d(TAG, "MainActivity onCreate called")
        super.onCreate(savedInstanceState)
        setContent {
            Unit6_Pathway2_Inventory_AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    InventoryApp()
                }
            }
        }
        Log.d(TAG, "MainActivity setup completed")
    }

    companion object {
        private const val TAG = "InventoryMainActivity"
    }
}