package br.com.cng.dextrasistemasprova.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.cng.dextrasistemasprova.R
import br.com.cng.dextrasistemasprova.domain.Lanche
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_extras.view.*

/**
 * Created by nicolaugalves on 21/08/17.
 */


class ExtrasAdapter(val cardapio: Array<Lanche>, val onClick: (Lanche) -> Unit) : RecyclerView.Adapter<ExtrasAdapter.ExtrasViewHolder>() {

    override fun onBindViewHolder(holder: ExtrasViewHolder, position: Int) {
        val promo = cardapio[position]
        val itemView = holder!!.itemView

        with(itemView) {
            tNome.text = promo.name
            tPreco.text = promo.price.toString()
            Picasso.with(context).load(promo.image).into(img)
            setOnClickListener {
                onClick(promo)
                llCartao.setBackgroundColor(resources.getColor(R.color.verde))
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ExtrasViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.adapter_extras, parent, false)
        val holder = ExtrasViewHolder(view)
        return holder
    }


    override fun getItemCount(): Int {
        return cardapio.size
    }

    class ExtrasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}