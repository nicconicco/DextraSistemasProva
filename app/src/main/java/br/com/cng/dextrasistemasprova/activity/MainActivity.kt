package br.com.cng.dextrasistemasprova.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import br.com.cng.dextrasistemasprova.R
import br.com.cng.dextrasistemasprova.adapter.PageAdapterDex



class MainActivity : BaseActivity() {

    private var mSectionsPagerAdapter: PageAdapterDex? = null
    private var mViewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = PageAdapterDex(this, supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container) as ViewPager?
        mViewPager!!.adapter = mSectionsPagerAdapter

        val tabLayout = findViewById(R.id.tabs) as TabLayout
        tabLayout.setupWithViewPager(mViewPager)

        // set icons
        tabLayout.getTabAt(0)!!.setIcon(R.mipmap.rest)
        tabLayout.getTabAt(1)!!.setIcon(R.mipmap.casa)
    }


}
