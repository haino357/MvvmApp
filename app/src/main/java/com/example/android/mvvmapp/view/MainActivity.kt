package com.example.android.mvvmapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.android.mvvmapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.main_nav_host)

        /**
         * `setupActionBarWithNavController`を設定により下記を使用できる
         * ・自動でUpボタン(「←」のアイコン)を表示
         * ・xmlで指定したlabelをタイトルとして表示
         */
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    /**
     * onSupportNavigateUp()をオーバーライドすることでUpボタンが機能する
     */
    override fun onSupportNavigateUp() = findNavController(R.id.main_nav_host).navigateUp()
}