package com.example.sportssample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.sportssample.models.Entry
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)


    }

    override fun onStart() {
        super.onStart()

        mainViewModel.getMatchDetails().observe(this, { match ->
            val teamKeys = match.Teams.keys.toList()

            viewPager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle, match.Teams)

            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = match.Teams[teamKeys[position]]?.Name_Full
            }.attach()
        })
    }

    private inner class ViewPagerAdapter(
        fragmentManager: FragmentManager,
        lifeCycle: Lifecycle,
        private val teams: HashMap<String, Entry>
    ) :
        FragmentStateAdapter(fragmentManager, lifeCycle) {
        val teamKeys = teams.keys.toList()

        override fun getItemCount() = teams.size

        override fun createFragment(position: Int) = Team(teams[teamKeys[position]]!!)
    }
}