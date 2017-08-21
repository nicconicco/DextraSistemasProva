package br.com.cng.dextrasistemasprova.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.cng.dextrasistemasprova.R
import br.com.cng.dextrasistemasprova.domain.Lanche
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_cardapio.view.*


/**
 * Created by nicolaugalves on 19/08/17.
 */


class CardapioAdapter(val cardapio: Array<Lanche>, val onClick: (Lanche) -> Unit) : RecyclerView.Adapter<CardapioAdapter.CardapioViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CardapioViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.adapter_cardapio, parent, false)
        val holder = CardapioViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: CardapioViewHolder?, position: Int) {
        val cardapio = cardapio[position]
        val itemView = holder!!.itemView

        with(itemView) {
            tNome.text = cardapio.name
            Picasso.with(context).load(cardapio.image).fit().centerCrop()
                    .placeholder(R.mipmap.casa)
                    .error(R.mipmap.casa)
                    .into(imgLanche)
            setOnClickListener { onClick(cardapio) }
        }
    }

    override fun getItemCount(): Int {
        return cardapio.size
    }

    class CardapioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}