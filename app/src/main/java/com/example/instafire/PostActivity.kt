package com.example.instafire

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.instafire.model.Postadapter
import com.example.instafire.model.Posts
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_post.*

private const val TAG="PostsActivity"
open class PostActivity : AppCompatActivity() {
    private lateinit var firebasedb:FirebaseFirestore
    private lateinit var db:MutableList<Posts>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
         firebasedb=FirebaseFirestore.getInstance()
        db= mutableListOf()
        val adapter=Postadapter(this,db)
        review.adapter=adapter
        review.layoutManager=LinearLayoutManager(this)

         val data=firebasedb.collection("Posts").orderBy("curent_time")

        data.addSnapshotListener{snapshot,exception->
            if(snapshot==null || exception!=null){
                Log.e(TAG,"EXCEPTION WHEN QUERYING",exception)
                return@addSnapshotListener
            }
           val post= snapshot.toObjects(Posts::class.java)
            db.clear()

            db.addAll(post)

            adapter.notifyDataSetChanged()

            for(documents in post){
             Log.i(TAG,"Documents ${documents}")
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_posts,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.menu_profile){
            val intent= Intent(this,ProfileActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}