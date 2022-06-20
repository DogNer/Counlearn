package com.example.counlearn.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.counlearn.CotinentChapter.CapitelWW
import com.example.counlearn.CotinentChapter.CountryWholeWorld
import com.example.counlearn.CotinentChapter.FlagWW

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {
                return CapitelWW()
            }
            1 -> {
                return CountryWholeWorld()
            }
            else -> {
                return FlagWW()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "Country"
            }
            1 -> {
                return "Capital"
            }
            2 -> {
                return "Flag"
            }
        }
        return super.getPageTitle(position)
    }

}