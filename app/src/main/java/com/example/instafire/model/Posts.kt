package com.example.instafire.model

import com.google.firebase.firestore.PropertyName

data class Posts(
    @get:PropertyName("Descriptions") @set:PropertyName("Descriptions") var description:String="",
    @get:PropertyName("Image") @set:PropertyName("Image") var image:String="",
    @get:PropertyName("curent_time") @set:PropertyName("curent_time") var crt:Long=0,
    @get:PropertyName("users") @set:PropertyName("users") var users:users?=null


)
