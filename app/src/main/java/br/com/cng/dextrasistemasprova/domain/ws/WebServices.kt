package br.com.cng.dextrasistemasprova.domain.ws

import br.com.cng.dextrasistemasprova.domain.Constant.Constant

/**
 * Created by nicolaugalves on 20/08/17.
 */

class WebServices {
    private val URL_REST = "http://10.0.64.22:8080"
    private val URL_LANCHES_PROD = "/api/lanche"
    private val URL_LANCHES_HOMOLOG = "/api/lanche"

    private val URL_DETALHE_PROD = "/api/ingrediente/de/"
    private val URL_DETALHE_HOMOLOG = "/api/ingrediente/de/"

    private val URL_PROMOCAO_PROD = "/api/promocao"
    private val URL_PROMOCAO_HOMOLOG = "/api/promocao"

    private val URL_PEDIDOS_PROD = "/api/pedido"
    private val URL_PEDIDOS_HOMOLOG = "/api/pedido"

    private val URL_PUTPEDIDO_PROD = "/api/pedido/"
    private val URL_PUTPEDIDO_HOMOLOG = "/api/pedido/"

    private val URL_INGREDIENSTE_PROD = "/api/ingrediente"
    private val URL_INGREDIENSTE_HOMOLOG = "/api/ingrediente"

    fun  getLanches(): String {
        return if (Constant.IS_PROD) URL_LANCHES_PROD else URL_LANCHES_HOMOLOG
    }
    fun getUrlRest(): String {
        return URL_REST
    }

    fun getDetalhePedido(): String? {
        return if (Constant.IS_PROD) URL_DETALHE_PROD else URL_DETALHE_HOMOLOG
    }

    fun getPromos(): String? {
        return if (Constant.IS_PROD) URL_PROMOCAO_PROD else URL_PROMOCAO_HOMOLOG
    }

    fun getMeusPedidos(): String? {
        return if (Constant.IS_PROD) URL_PEDIDOS_PROD else URL_PEDIDOS_HOMOLOG
    }

    fun putPedido(): String? {
        return if (Constant.IS_PROD) URL_PUTPEDIDO_PROD else URL_PUTPEDIDO_HOMOLOG
    }

    fun getIngredientes(): String? {
        return if (Constant.IS_PROD) URL_INGREDIENSTE_PROD else URL_INGREDIENSTE_HOMOLOG
    }
}