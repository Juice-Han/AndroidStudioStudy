package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.databinding.ActivityMainBinding
import com.example.recyclerviewexample.databinding.ItemBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val fruitViewModel: FruitViewModel by lazy{
        ViewModelProvider(this).get(FruitViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.RecyclerView.layoutManager = LinearLayoutManager(this)

        val fruits = fruitViewModel.fruitList
        var adapter = MyAdapter(fruits)
        binding.RecyclerView.adapter = adapter
    }

    class MyViewHolder(binding: ItemBinding): RecyclerView.ViewHolder(binding.root){
        var textView = binding.textView
        private lateinit var fruit : Fruit

        fun bind(_fruit: Fruit){
            this.fruit = _fruit
            textView.text = this.fruit.name
        }
    }

    class MyAdapter(var list: List<Fruit>):RecyclerView.Adapter<MyViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.item,parent,false)
            return MyViewHolder(ItemBinding.bind(view))
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val fruit = list[position]
            holder.bind(fruit)
        }

        override fun getItemCount(): Int = list.size
    }
}