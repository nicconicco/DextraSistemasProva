package br.com.cng.dextrasistemasprova.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.cng.dextrasistemasprova.R
import br.com.cng.dextrasistemasprova.domain.Lanche
import br.com.cng.dextrasistemasprova.domain.ResponseRestaurante
import kotlinx.android.synthetic.main.adapter_meus_pedidos.view.*


/**
 * Created by nicolaugalves on 19/08/17.
 */


class MeusPedidosAdapter(val response: Array<ResponseRestaurante>, val onClick: (Lanche) -> Unit) : RecyclerView.Adapter<MeusPedidosAdapter.MeusPedidosViewHolder>() {

    override fun onBindViewHolder(holder: MeusPedidosViewHolder, position: Int) {
        val response = response[position]
        val itemView = holder!!.itemView

        with(itemView) {
            tId.text = response.id.toString()
            tIdSanduiche.text = response.idSandwich.toString()
            tExtras.text = response.extras.toString()
            tDate.text = response.date.toString()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MeusPedidosViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.adapter_meus_pedidos, parent, false)
        val holder = MeusPedidosViewHolder(view)
        return holder
    }


    override fun getItemCount(): Int {
        return response.size
    }

    class MeusPedidosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}