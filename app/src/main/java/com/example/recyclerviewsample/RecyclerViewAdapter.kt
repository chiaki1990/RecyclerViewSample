package com.example.recyclerviewsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(val dataArrayList: ArrayList<RowModel>): RecyclerView.Adapter<RecyclerViewAdapter.ArticloViewHolder>(){

    class ArticloViewHolder(view: View): RecyclerView.ViewHolder(view){
        val rowTitle  = view.findViewById<TextView>(R.id.row_title)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):RecyclerViewAdapter.ArticloViewHolder {

        val rowView = LayoutInflater.from(parent.context)
            .inflate(R.layout.articulo_row, parent, false)
        return ArticloViewHolder(rowView)
    }

    override fun getItemCount() = dataArrayList.size

    // onBindViewHolderの引数は生成したMyViewHolderインスタンスである。
    // 第２引数はリスト型データの番号である。
    override fun onBindViewHolder(holder: ArticloViewHolder, position: Int) {

        // row_titeはMyViewHolderの属性値である。
        // myDataset[position].titleは、myDatabaseの要素がRowModelであり、そのRowModelの属性値にtitleである。
        holder.rowTitle.text = dataArrayList[position].title
        // row_detailはMyViewHolderの属性値である。
        //holder.row_detail.text = myDataset[position].detail


    }


}
