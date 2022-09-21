package com.example.project2wishlist
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var userItem: EditText
    lateinit var userURL: EditText
    lateinit var userPrice: EditText
    lateinit var wishlistRv: RecyclerView
    lateinit var adapter: WishlistAdapter
    lateinit var wishlist: MutableList<Wishlist>
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.addData)
        userItem = findViewById(R.id.userItem)
        userURL = findViewById(R.id.urlTxt)
        userPrice = findViewById(R.id.price)
        wishlistRv = findViewById(R.id.rvWishlist)
        wishlist = WishlistFetcher.giveInfo("nothing", "to see here", 0.0)
        adapter = WishlistAdapter(wishlist)
        wishlistRv.adapter = adapter
        wishlistRv.layoutManager = LinearLayoutManager(this)
        wishlistRv.visibility = View.GONE

        var tap = 0
        btn.setOnClickListener {
            if(tap > 0) {
                val newWishlist = WishlistFetcher.giveInfo(
                    userItem.text.toString(), userURL.text.toString(),
                    userPrice.text.toString().toDouble()
                )

                wishlist.addAll(newWishlist)
                adapter.notifyItemChanged(wishlist.size - newWishlist.size)
                wishlistRv.smoothScrollToPosition(wishlist.size - newWishlist.size)
                userItem.text.clear()
                userURL.text.clear()
                userPrice.text.clear()
            }
            else{
                wishlist[0] = WishlistFetcher.placeHolder(userItem.text.toString(), userURL.text.toString(),
                    userPrice.text.toString().toDouble())
                adapter.notifyItemChanged(0)
                userItem.text.clear()
                userURL.text.clear()
                userPrice.text.clear()
                wishlistRv.visibility = View.VISIBLE
                tap++
            }


        }
    }
}
