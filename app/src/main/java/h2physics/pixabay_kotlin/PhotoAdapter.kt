package h2physics.pixabay_kotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import h2physics.pixabay_kotlin.models.Photo
import java.util.zip.Inflater

/**
 * Created by YukiNoHara on 7/26/2017.
 */
class PhotoAdapter(val photos : List<Photo>,
                   val onClickListener: PhotoAdapter.OnClickListener,
                   val context : Context) : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: PhotoViewHolder?, position: Int) {
        val photo = photos[position]
        holder?.likes?.text = photo.likes.toString()
        holder?.favorites?.text = photo.favorites.toString()
        holder?.author?.text = photo.user
        holder?.tags?.text = photo.tags
        if (photo.webformatURL.isNotEmpty()){
            Glide.with(context)
                    .load(photo.webformatURL)
                    .into(holder?.photo)
        }
    }
    fun getPhoto(position: Int) : Photo{
        return photos[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PhotoViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.photo_item, parent, false)
        return PhotoViewHolder(view)
    }

    interface OnClickListener{
        public fun OnClick(position: Int)
    }

    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        override fun onClick(view: View?) {
            Log.e("ADAPTER", "OnClick")
            val position : Int = this.adapterPosition
            onClickListener.OnClick(position)
        }

        var likes : TextView
        var favorites : TextView
        var author : TextView
        var tags : TextView
        var photo : ImageView

        init {
            itemView.tag = this
            likes = itemView.findViewById(R.id.tv_like)
            favorites = itemView.findViewById(R.id.tv_favorite)
            author = itemView.findViewById(R.id.tv_author)
            tags = itemView.findViewById(R.id.tv_tags)
            photo = itemView.findViewById(R.id.imv_photo)

            itemView.setOnClickListener(this)
        }
    }

}