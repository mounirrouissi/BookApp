package com.example.testdelete1.models

import android.os.Parcel
import android.os.Parcelable

data class Book(
    var id:Long,
    var name: String?,
    var ratings:Double,
    var imageUrl: String?,
    var price: Double,

):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readString(),
                parcel.readDouble(),

        ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(name)
        parcel.writeDouble(ratings)
        parcel.writeString(imageUrl)
        parcel.writeDouble(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Book> {
        override fun createFromParcel(parcel: Parcel): Book {
            return Book(parcel)
        }

        override fun newArray(size: Int): Array<Book?> {
            return arrayOfNulls(size)
        }
    }


}