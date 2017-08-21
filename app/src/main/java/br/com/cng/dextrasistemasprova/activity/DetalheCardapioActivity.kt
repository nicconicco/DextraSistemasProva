package br.com.cng.dextrasistemasprova.activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import br.com.cng.dextrasistemasprova.R
import br.com.cng.dextrasistemasprova.domain.Constant.Constant
import br.com.cng.dextrasistemasprova.domain.Lanche
import br.com.livetouch.base.util.LogUtil
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_detalhe_cardapio.*




/**
 * Created by nicolaugalves on 19/08/17.
 */

class DetalheCardapioActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_cardapio)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }


        var jsonMyObject: String = ""
        val extras = intent.extras
        if (extras != null) {
            jsonMyObject = extras.getString(Constant.LANCHE)

            val gson = Gson()
            val obj = gson.fromJson(jsonMyObject, Lanche::class.java)
            LogUtil.log("TAG",obj.name)
        }


    }
}