package com.example.loginvalidation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginvalidation.models.RecyclerList
import com.example.loginvalidation.network.RetroInstance
import com.example.loginvalidation.network.RetroService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeActivityViewModel : ViewModel() {
    var recyclerListLiveData: MutableLiveData<RecyclerList>
    init {
        recyclerListLiveData = MutableLiveData()
    }

    fun getRecyclerListObserver() : MutableLiveData<RecyclerList>{
        return recyclerListLiveData
    }

    //This Function will return the instance of retrofit
    fun makeApiCall(){
        viewModelScope.launch(Dispatchers.IO){
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response = retroInstance.getDataFromApi("ny")
            recyclerListLiveData.postValue(response)
        }
    }
}