package br.com.cng.dextrasistemasprova.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.cng.dextrasistemasprova.R
import br.com.cng.dextrasistemasprova.domain.Lanche
import kotlinx.android.synthetic.main.adapter_promos.view.*


/**
 * Created by nicolaugalves on 19/08/17.
 */


class PromosAdapter(val cardapio: Array<Lanche>, val onClick: (Lanche) -> Unit) : RecyclerView.Adapter<PromosAdapter.PromosViewHolder>() {

    override fun onBindViewHolder(holder: PromosViewHolder, position: Int) {
        val promo = cardapio[position]
        val itemView = holder!!.itemView

        with(itemView) {
            tNome.text = promo.name
            tDescription.text = promo.description
            setOnClickListener { onClick(promo) }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PromosViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.adapter_promos, parent, false)
        val holder = PromosViewHolder(view)
        return holder
    }


    override fun getItemCount(): Int {
        return cardapio.size
    }

    class PromosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}