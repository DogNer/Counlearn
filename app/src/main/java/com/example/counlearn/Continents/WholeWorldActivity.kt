package com.example.counlearn.Continents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.compose.ui.graphics.Color
import androidx.viewpager.widget.ViewPager
import com.example.counlearn.Adapters.ViewPagerAdapter
import com.example.counlearn.MainActivity
import com.example.counlearn.R
import com.google.android.material.tabs.TabLayout

class WholeWorldActivity : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var btn_back: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_whole_world)

        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        viewPager.adapter = ViewPagerAdapter(supportFragmentManager)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayoult)
        tabLayout.setupWithViewPager(viewPager)

        btn_back = findViewById(R.id.text_back_home)
        btn_back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}