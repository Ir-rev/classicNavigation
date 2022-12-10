package ir.rev.classicnavigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// ОБЯЗАТЕЛЬНО Parcelize
@Parcelize
data class Cat(
    val name: String,
    val age: Int
) : Parcelable

