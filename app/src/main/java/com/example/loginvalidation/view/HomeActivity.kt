package com.example.loginvalidation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.loginvalidation.databinding.ActivityHomeBinding
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.loginvalidation.R
import com.example.loginvalidation.network.RecyclerListFragment
import com.example.loginvalidation.view.fragments.HomeFragment
import com.example.loginvalidation.view.fragments.MessageFragment
import com.example.loginvalidation.view.fragments.RateFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityHomeBinding
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        this.title = "Home Page"
        setUpView()
        setUpFragment()
        mBinding.navView.setNavigationItemSelectedListener {

            it.isChecked = true

            when(it.itemId){
                R.id.nav_home -> replaceFragment(HomeFragment(), it.title.toString())
                R.id.message -> replaceFragment(MessageFragment(), it.title.toString())
                R.id.rateUs -> replaceFragment(RateFragment(), it.title.toString())
                R.id.nav_share -> Toast.makeText(applicationContext,"Clicked share button",Toast.LENGTH_SHORT).show()
                R.id.contact -> Toast.makeText(applicationContext,"Clicked contact",Toast.LENGTH_SHORT).show()
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment,title: String){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
        mBinding.drawerLayout.closeDrawers()
        setTitle(title)

    }

    private fun setUpView(){
        setUpDrawerLayout()
    }

    private fun setUpDrawerLayout(){
        setSupportActionBar(mBinding.appBar)
        actionBarDrawerToggle = ActionBarDrawerToggle(this,mBinding.drawerLayout,R.string.open,R.string.close)
        actionBarDrawerToggle.syncState()
/*
actionBarDrawerToggle.isDrawerIndicatorEnabled = true
mBinding.drawerLayout.addDrawerListener(actionBarDrawerToggle)
*/

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setUpFragment(){
        val fragment = RecyclerListFragment.newInstance()
        val fragmentManager : FragmentManager = supportFragmentManager
        val fragmentTransaction :FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(com.google.android.material.R.id.container,fragment)
        fragmentTransaction.commit()
    }
}