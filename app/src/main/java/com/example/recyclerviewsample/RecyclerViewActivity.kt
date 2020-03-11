package com.example.recyclerviewsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val BASE_URL: String = "http://10.0.2.2:8000/";

class RecyclerViewActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        getItemDarListView()
    }


    fun getItemDarListView(){
        val retrofit:Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ShareXelaService::class.java)
        service.getItemDarListSerializerView().enqueue(object :Callback<ItemDarListSerializerViewModel>{

            override fun onResponse(
                call: Call<ItemDarListSerializerViewModel>,
                response: Response<ItemDarListSerializerViewModel>
            ) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.


                //List<RowModel>を生成する
                var dataArrayList: ArrayList<RowModel> = arrayListOf()

                //responseを解析する
                //println("RESPONSEの結果　：　")
                println(response.body())
                //var item_objects_count = response.body()?.item_objects_count!!.toInt()
                //println("COUNT : " + item_objects_count)
                var itemSerializerList:List<ItemSerializerModel>? = response.body()?.itemSerializer


                for (numero in 0..itemSerializerList!!.size-1){
                //for (numero in 0..item_objects_count){

                    //println("番号 : "+ numero)
                    //println(itemSerializerList[numero])
                    var title = itemSerializerList[numero].title
                    var description = itemSerializerList[numero].description
                    var category = itemSerializerList[numero].category.name
                    var created_at = itemSerializerList[numero].created_at
                    var image = itemSerializerList[numero].image1

                    dataArrayList.add(
                        RowModel(
                            title = title,
                            description = description,
                            category = category,
                            created_at = created_at,
                            image = image
                            ))

                }


                // recyclerviewオブジェクトのapplyの要素の一つを生成する
                    var viewManager = LinearLayoutManager(this@RecyclerViewActivity)

                    // recyclerviewオブジェクトのapplyの要素の一つを生成する
                    var viewAdapter = RecyclerViewAdapter(dataArrayList)


                    recyclerSample.apply {

                        // use this setting to improve performance if you know that changes
                        // in content do not change the layout size of the RecyclerView
                        setHasFixedSize(true)

                        // use a linear layout manager
                        layoutManager = viewManager

                        //// specify an viewAdapter (see also next example)
                        adapter = viewAdapter

                    }

            }

            override fun onFailure(call: Call<ItemDarListSerializerViewModel>, t: Throwable) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                println(t)
            }
        })
    }


}
