package h2physics.pixabay_kotlin.models

import java.io.Serializable

/**
 * Created by YukiNoHara on 7/26/2017.
 */
data class Photo (val id : String,
                  val likes : Int,
                  val favorites : Int,
                  val tags : String,
                  val previewURL : String,
                  val webformatURL : String,
                  val user : String) : Serializable{

}