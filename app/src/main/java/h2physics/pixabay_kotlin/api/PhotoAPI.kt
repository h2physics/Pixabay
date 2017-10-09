package h2physics.pixabay_kotlin.api

import h2physics.pixabay_kotlin.models.PhotoList
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by YukiNoHara on 7/26/2017.
 */
interface PhotoAPI {
    @GET("?key=5991388-2ecc2b48e1e264faf9cda8706&q=nature&image_type=photo")
    fun getPhotos() : Call<PhotoList>
}