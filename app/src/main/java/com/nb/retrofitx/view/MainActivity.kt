package com.nb.retrofitx.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nb.retrofitx.R
import com.nb.retrofitx.extensions.GlobalScopeExt
import com.nb.retrofitx.models.UserResponse
import com.nb.retrofitx.network.getUser
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScopeExt(this) {
            getUser(onApiSuccess = {
                showUser(it)
            })
        }
    }

    private fun showUser(user: UserResponse) {
        txtName.text = user.name
    }

}