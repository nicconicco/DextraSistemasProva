package br.com.cng.dextrasistemasprova.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.cng.dextrasistemasprova.R

/**
 * Created by nicolaugalves on 19/08/17.
 */


open class TabSeuPedidoFragment : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_seu_pedido, container, false)
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Picasso.with(context).load("http://4.bp.blogspot.com/-04M3ljOud1Q/UO9owTBtSYI/AAAAAAAAAsc/gq0c1-knR-o/s1600/double_cheeseburger_bacon_0.png").into(img)
    }
}