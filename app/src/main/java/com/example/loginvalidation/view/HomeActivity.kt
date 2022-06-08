package com.example.loginvalidation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.loginvalidation.databinding.ActivityHomeBinding
import androidx.databinding.DataBindingUtil
import com.example.loginvalidation.R

class HomeActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityHomeBinding
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
//        mBinding = ActivityHomeBinding.inflate(layoutInflater)
//        setContentView(mBinding.root)
        this.title = "Home Page"
        setUpView()
        mBinding.navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> Toast.makeText(applicationContext,"Clicked home",Toast.LENGTH_SHORT).show()
                R.id.message -> Toast.makeText(applicationContext,"Clicked message",Toast.LENGTH_SHORT).show()
                R.id.rateUs -> Toast.makeText(applicationContext,"Clicked rateUs",Toast.LENGTH_SHORT).show()
                R.id.nav_share -> Toast.makeText(applicationContext,"Clicked share button",Toast.LENGTH_SHORT).show()
                R.id.contact -> Toast.makeText(applicationContext,"Clicked contact",Toast.LENGTH_SHORT).show()
            }
            true
        }
    }
    fun setUpView(){
        setUpDrawerLayout()
    }

    fun setUpDrawerLayout(){
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
}