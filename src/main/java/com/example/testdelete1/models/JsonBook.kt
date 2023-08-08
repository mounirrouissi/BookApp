package com.example.testdelete1.models

import android.os.Parcel
import android.os.Parcelable
import java.util.*

data class JsonBook(
    var id:Long,
    var name: String?,
    var ratings:Double,
    var authors:Array<Author>,
    var price:Double,
    var description: String?,
    var imageUrl: String?,
    var unitsInStock:Int,
    var datePublished: Date,
    var dateUpdated: Date
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString(),
        parcel.readDouble(),
        TODO("authors"),
        parcel.readDouble(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        TODO("datePublished"),
        TODO("dateUpdated")
    ) {
    }


    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<JsonBook> {
        override fun createFromParcel(parcel: Parcel): JsonBook {
            return JsonBook(parcel)
        }

        override fun newArray(size: Int): Array<JsonBook?> {
            return arrayOfNulls(size)
        }
    }
}
