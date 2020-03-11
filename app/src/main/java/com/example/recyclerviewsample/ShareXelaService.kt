package com.example.recyclerviewsample


import retrofit2.Call
import retrofit2.http.*

interface ShareXelaService {

    //データ一覧を取得する
    @GET("api/items/list/")
    fun getItemDarListSerializerView():Call<ItemDarListSerializerViewModel>


}