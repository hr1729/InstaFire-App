package com.example.instafire.model

import com.google.firebase.firestore.PropertyName

data class users(
    @get:PropertyName("age") @set:PropertyName("age") var age:Int=0,
    @get:PropertyName("username") @set:PropertyName("username") var name:String=""
)
