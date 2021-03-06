package com.elegion.test.reddit.weather

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import com.elegion.test.reddit.R
import kotlinx.android.synthetic.main.ac_main.*

class WeatherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ac_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            collapsing_toolbar_layout.title = resources.getString(R.string.flavored_app_name)
            collapsing_toolbar_layout.setExpandedTitleColor(resources.getColor(android.R.color.transparent, theme))
        }

        if (savedInstanceState == null) {
            changeFragment(WeatherFragment())
        }
    }

    private fun changeFragment(f: Fragment) {
        val addToBackStack = supportFragmentManager.findFragmentById(R.id.container) != null
        val ft = supportFragmentManager.beginTransaction()
                .replace(R.id.container, f)
        if (addToBackStack) {
            ft.addToBackStack(f::class.java.simpleName)
        }
        ft.commit()
    }
}
