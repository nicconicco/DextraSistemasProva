package br.com.cng.dextrasistemasprova.fragment

import android.content.Intent
import android.os.Bundle
import br.com.cng.dextrasistemasprova.activity.DetalheCardapioActivity
import br.com.cng.dextrasistemasprova.domain.Constant.Constant
import br.com.cng.dextrasistemasprova.domain.Lanche
import br.com.livetouch.base.fragment.BaseFragment
import com.google.gson.Gson

/**
 * Created by nicolaugalves on 19/08/17.
 */


open class BaseFragment : BaseFragment() {
    public fun detalheCardapio(it: Lanche) {
        val bundle = Bundle()
        bundle.putString(Constant.LANCHE, Gson().toJson(it))
        val it = Intent(activity, DetalheCardapioActivity::class.java)
        it.putExtras(bundle)
        activity.startActivity(it, bundle)
    }
}