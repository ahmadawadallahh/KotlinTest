package com.example.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.kotlintest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),OnSendClickListener {
    private lateinit var binding: ActivityMainBinding
    private val data = ArrayList<Model>()
    private val adapter = MyAdapter(data)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.myRecyclerView.layoutManager=LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)
        binding.myRecyclerView.adapter=adapter

        binding.addBtn.setOnClickListener {
            val dialog = MyDialog.getInstance(this)
            dialog.show(supportFragmentManager, "My dialog")
        }
        val swipeToDeleteCallback = object :SwipeToDeleteCallback(){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                data.removeAt(position)
                binding.myRecyclerView.adapter?.notifyItemRemoved(position)
            }

        }
        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(binding.myRecyclerView)

    }

    override fun click(firstName: String, lastName: String) {
        val model = Model(firstName,lastName)
        data.add(model)
        adapter.notifyDataSetChanged()
    }


}