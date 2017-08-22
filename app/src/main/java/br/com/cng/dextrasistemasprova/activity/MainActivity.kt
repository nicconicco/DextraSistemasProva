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

        mSectionsPagerAdapter = PageAdapterDex(this, supportFragmentManager)
        mViewPager = findViewById(R.id.container) as ViewPager?
        mViewPager!!.adapter = mSectionsPagerAdapter

        val tabLayout = findViewById(R.id.tabs) as TabLayout
        tabLayout.setupWithViewPager(mViewPager)

        tabLayout.getTabAt(0)!!.setIcon(R.mipmap.rest)
        tabLayout.getTabAt(1)!!.setIcon(R.mipmap.casa)
        tabLayout.getTabAt(2)!!.setIcon(R.mipmap.casa)
    }
}
