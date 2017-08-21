package br.com.cng.dextrasistemasprova.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.cng.dextrasistemasprova.HttpService.DexService
import br.com.cng.dextrasistemasprova.R
import br.com.cng.dextrasistemasprova.activity.DetalheCardapioActivity
import br.com.cng.dextrasistemasprova.adapter.CardapioAdapter
import br.com.cng.dextrasistemasprova.domain.Constant.Constant
import br.com.cng.dextrasistemasprova.domain.Lanche
import br.com.livetouch.base.extension.startTask
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_cardapio.*


/**
 * Created by nicolaugalves on 19/08/17.
 */


open class TabCardaprioFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_cardapio, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler.layoutManager = LinearLayoutManager(activity) as RecyclerView.LayoutManager?
        recycler.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()
        taskGetCardapio()
    }

    private fun taskGetCardapio() {
        var cardapio : Array<Lanche>? = null
        startTask(execute = {
            cardapio = DexService().getCarpadio()
        }, updateView = {
            if (R.string.cardapio != null) {
                recycler.adapter = CardapioAdapter(cardapio!!) {
                    val bundle = Bundle()
                    bundle.putString(Constant.LANCHE, Gson().toJson(it))
                    val it = Intent(activity, DetalheCardapioActivity::class.java)
                    it.putExtras(bundle)
                    activity.startActivity(it, bundle)
                }
            }
        })
    }
}


