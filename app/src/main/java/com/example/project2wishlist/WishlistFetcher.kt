package com.example.project2wishlist

class WishlistFetcher {

    companion object{

        // i = item input // u = URL // p = Price
        fun giveInfo(i: String, u: String, p: Double): MutableList<Wishlist>{
            var temp: MutableList<Wishlist> = ArrayList()
            val oneWish = Wishlist(i, u, p) // saves an object of a class
            temp.add(oneWish)
            return temp // returns the set of inputs
        }

        fun placeHolder(i: String, u: String, p: Double):Wishlist{
            return Wishlist(i,u,p)
        }

    }

}