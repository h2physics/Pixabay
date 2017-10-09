package h2physics.pixabay_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import com.bumptech.glide.Glide
import h2physics.pixabay_kotlin.models.Photo

class DetailActivity : AppCompatActivity() {
    var imvPhoto : ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initView()
    }

    private fun initView(){
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        imvPhoto = findViewById(R.id.imv_photo) as ImageView

        val photo = intent.getSerializableExtra("photo") as Photo?
        photo?.webformatURL.let {
            Glide.with(this)
                    .load(photo?.webformatURL)
                    .into(imvPhoto)
        }
        imvPhoto?.setOnClickListener { _ ->
            finish()
        }
    }



}
