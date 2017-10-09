package h2physics.pixabay_kotlin.ui.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager

/**
 * Created by YukiNoHara on 7/26/2017.
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    abstract public fun getContentLayout() : Int
    abstract public fun initView()
    abstract public fun initData()
    public fun showKeyboard(target : View?){
        if (target == null){
            return
        }
        (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).showSoftInput(target, InputMethodManager.SHOW_IMPLICIT)
    }

    public fun hideKeyboard(){
        val imm : InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        var view : View = currentFocus
        if (view == null){
            view = View(this)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}