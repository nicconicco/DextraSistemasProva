package br.com.cng.dextrasistemasprova.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.cng.dextrasistemasprova.HttpService.DexService
import br.com.cng.dextrasistemasprova.R
import br.com.cng.dextrasistemasprova.adapter.PromosAdapter
import br.com.cng.dextrasistemasprova.domain.Lanche
import br.com.livetouch.base.extension.startTask
import kotlinx.android.synthetic.main.fragment_promos.*

/**
 * Created by nicolaugalves on 21/08/17.
 */


class TabPromosFragment : BaseFragment() {

    var promos : Array<Lanche>? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_promos, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler.layoutManager = LinearLayoutManager(activity) as RecyclerView.LayoutManager?
        recycler.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()

        if (promos == null) {
            taskGetPromos()
        } else {
            recycler.adapter = PromosAdapter(promos!!) {
                //detalheCardapio(it)
            }
        }
    }

    private fun taskGetPromos() {

        startTask(execute = {
            promos = DexService().getPromocoes()
        }, updateView = {
            if (promos != null) {
                recycler.adapter = PromosAdapter(promos!!) {
                    //detalheCardapio(it)
                }
            }
        })
    }
}