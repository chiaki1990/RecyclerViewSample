package com.example.recyclerviewsample



// django: api/views.py ItemDarListSerializerViewより
data class ItemDarListSerializerViewModel(
    var item_objects_count: Int?,
    var itemSerializer: List<ItemSerializerModel>?
)


// django: api/seralizers.py ItemSerializerより
data class ItemSerializerModel(
    var id:Int,
    var title:String,
    var description: String,
    var category:CategorySerializerModel,
    var adm0: String,
    var adm1: String,
    var adm2: String,
    var created_at: String,
    var active: Boolean,
    var deadline: Boolean,
    var image1: String,
    var image2: String,
    var image3: String

)


data class CategorySerializerModel(
    var name: String
)

