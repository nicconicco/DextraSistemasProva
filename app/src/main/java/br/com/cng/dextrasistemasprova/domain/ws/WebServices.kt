package br.com.cng.dextrasistemasprova.domain.ws

import br.com.cng.dextrasistemasprova.domain.Constant.Constant

/**
 * Created by nicolaugalves on 20/08/17.
 */

class WebServices {
    private val URL_REST = "http://192.168.0.11:8081"
    private val URL_LANCHES_PROD = "/api/lanche"
    private val URL_LANCHES_HOMOLOG = "/api/lanche"

    fun  getLanches(): String {
        return if (Constant.IS_PROD) URL_LANCHES_PROD else URL_LANCHES_HOMOLOG
    }
    fun getUrlRest(): String {
        return URL_REST
    }
}