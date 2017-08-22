package br.com.cng.dextrasistemasprova.activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import br.com.cng.dextrasistemasprova.HttpService.DexService
import br.com.cng.dextrasistemasprova.R
import br.com.cng.dextrasistemasprova.domain.Constant.Constant
import br.com.cng.dextrasistemasprova.domain.Lanche
import br.com.livetouch.base.extension.startTask
import br.com.livetouch.base.extension.toast
import br.com.livetouch.base.util.LogUtil
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalhe_cardapio.*


/**
 * Created by nicolaugalves on 19/08/17.
 */

class DetalheCardapioActivity : BaseActivity() {

    var lancheDetalhe : Array<Lanche>? = null
    var lanche : Lanche? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_cardapio)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()

            fazerPedidos(lanche)
        }

        var jsonMyObject: String = ""
        val extras = intent.extras
        if (extras != null) {
            jsonMyObject = extras.getString(Constant.LANCHE)

            val gson = Gson()
            lanche = gson.fromJson(jsonMyObject, Lanche::class.java)

            lanche?.let {
                LogUtil.log("DetalheCardapioActivity = ", lanche!!.name)
            }
        }
    }

    private fun fazerPedidos(lanche: Lanche?) {
        taskFazerPedido(lanche!!.id!!)
    }

    private fun taskFazerPedido(id: Int) {
        startTask(execute = {
            
        }, updateView = {
            toast("Pedido realizado com sucesso")
        })
    }

    override fun onResume() {
        super.onResume()

        if (lanche != null) {
            taskGetDetalhePedido()
        }
    }

    private fun taskGetDetalhePedido() {
        startTask(execute = {
            lancheDetalhe = DexService().getDetalheCardapio(lanche!!.id!!)
        }, updateView = {
            lancheDetalhe?.let {
                Picasso.with(getContext()).load(lanche!!.image).fit().centerCrop()
                        .placeholder(R.mipmap.casa)
                        .error(R.mipmap.casa)
                        .into(imgLanche)

                tNome.text = "Nome: "+lanche!!.name

                tPreco.text = "Preco: "+setPreco(lancheDetalhe!!)

                tIngredientes.text = "Ingredientes: "+setIngredientes(lancheDetalhe!!)
            }
        })
    }

    private fun  setIngredientes(lancheDetalhe: Array<Lanche>): String {

        var total : String = ""
//        for((index, element) in lancheDetalhe.withIndex()) {
//            print("$element at index $index")
//
//            element?.let {
//                total += element.name + ", "
//            }
//        }

        for (i in 0..lancheDetalhe.size - 1) {
            val b = lancheDetalhe[i]
            if (b != null) {
                total += b.name + ", "
            }
        }

        return total
    }

    private fun  setPreco(lancheDetalhe: Array<Lanche>): String {

        var total : Double = 0.0
        for((index, element) in lancheDetalhe.withIndex()) {
            print("$element at index $index")

            element?.let {
                total += element.price!!
            }
        }

        return total.toString()
    }
}