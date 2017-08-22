package br.com.cng.dextrasistemasprova.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.cng.dextrasistemasprova.HttpService.DexService
import br.com.cng.dextrasistemasprova.R
import br.com.cng.dextrasistemasprova.adapter.CardapioAdapter
import br.com.cng.dextrasistemasprova.domain.Lanche
import br.com.livetouch.base.extension.startTask
import kotlinx.android.synthetic.main.fragment_cardapio.*


/**
 * Created by nicolaugalves on 19/08/17.
 */


open class TabCardaprioFragment : BaseFragment() {

    var cardapio : Array<Lanche>? = null

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

        if (cardapio == null) {
            taskGetCardapio()
        } else {
            recycler.adapter = CardapioAdapter(cardapio!!) {
                detalheCardapio(it)
            }
        }
    }

    private fun taskGetCardapio() {

        startTask(execute = {
            cardapio = DexService().getCarpadio()
        }, updateView = {
            if (cardapio != null) {
                recycler.adapter = CardapioAdapter(cardapio!!) {
                    detalheCardapio(it)
                }
            }
        })
    }
}


