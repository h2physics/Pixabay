package h2physics.pixabay_kotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import h2physics.pixabay_kotlin.api.PhotoRetriever
import h2physics.pixabay_kotlin.models.Photo
import h2physics.pixabay_kotlin.models.PhotoList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), PhotoAdapter.OnClickListener{
    private final val LOG_TAG : String = "MainActivity"

    var photos : List<Photo>? = null
    var adapter : PhotoAdapter? = null
    lateinit var rvPhotos : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    override fun OnClick(position: Int) {
        Log.e(LOG_TAG, "OnClick")
        val intent : Intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("photo", adapter?.getPhoto(position))
        startActivity(intent)
    }

    private fun initView(){
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        rvPhotos = findViewById(R.id.rv_photos) as RecyclerView
        rvPhotos.layoutManager = LinearLayoutManager(this)

        var retrieve = PhotoRetriever()

        var callback = object : Callback<PhotoList>{
            override fun onFailure(call: Call<PhotoList>?, t: Throwable?) {
                Log.e(LOG_TAG, "Get data failed")
            }

            override fun onResponse(call: Call<PhotoList>?, response: Response<PhotoList>?) {
                response?.isSuccessful.let {
                    this@MainActivity.photos = response?.body()?.hits
                    adapter = PhotoAdapter(this@MainActivity.photos!!, this@MainActivity, this@MainActivity)
                    rvPhotos.adapter = adapter
                }
            }
        }
        retrieve.getPhotos(callback)

    }

    private fun initData(){

    }
}
