package com.example.loginvalidation.network

import android.os.Bundle
import android.os.TokenWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loginvalidation.R
import com.example.loginvalidation.adapter.RecyclerViewAdapter
import com.example.loginvalidation.models.RecyclerList
import com.example.loginvalidation.viewmodel.HomeActivityViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [RecyclerListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecyclerListFragment : Fragment() {

    private lateinit var recyclerAdapter : RecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recycler_list, container, false)

        initViewModel(view)
        initViewModel()
        return view
    }

    private fun initViewModel(view: View){
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        //add linear layout manager to recyclerview

        recyclerView.layoutManager = LinearLayoutManager(activity)

            //item decoration
        val decoration = DividerItemDecoration(activity,DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(decoration)

        recyclerAdapter = RecyclerViewAdapter()
        recyclerView.adapter = recyclerAdapter
    }
    private fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(HomeActivityViewModel::class.java)
        viewModel.getRecyclerListObserver().observe(viewLifecycleOwner, Observer<RecyclerList>{
            if(it != null){
                recyclerAdapter.setUpdateData(it.items)
            }
            else{
                Toast.makeText(activity,"Error in getting data ",Toast.LENGTH_SHORT).show()
            }
        })
            viewModel.makeApiCall()
    }
    companion object {
        @JvmStatic
        fun newInstance() =
            RecyclerListFragment()

    }
}