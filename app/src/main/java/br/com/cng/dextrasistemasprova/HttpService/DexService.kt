package br.com.cng.dextrasistemasprova.HttpService

import br.com.cng.dextrasistemasprova.HttpService.parser.DexParser
import br.com.cng.dextrasistemasprova.domain.Lanche
import br.com.cng.dextrasistemasprova.domain.ws.WebServices
import br.com.livetouch.http.HttpHelper



/**
 * Created by nicolaugalves on 19/08/17.
 */

class DexService {

    private fun getHttpHelper(): HttpHelper {
        return getHttpHelper(15000)
    }

    private fun getHttpHelper(timeout: Int): HttpHelper {
        val http = HttpHelper()
        http.setConnectTimeout(timeout.toLong())
        http.setReadTimeout(timeout.toLong())
        return http
    }


    fun getCarpadio(): Array<Lanche>? {

        var url = WebServices().getUrlRest() + WebServices().getLanches()

        try {
            var http = getHttpHelper()

            http.doGet(url)
            val jsonResponse = http.getString()
            val response = DexParser().parseCardapio(jsonResponse)

            return response
        } catch (var11: Exception) {

            var11.printStackTrace()
            return null
        }

        return null
    }

    fun getDetalheCardapio(id: Int?): Array<Lanche>? {
        var url = WebServices().getUrlRest() + WebServices().getDetalhePedido() + id

        try {
            var http = getHttpHelper()

            http.doGet(url)
            val jsonResponse = http.getString()
            val response = DexParser().parseCardapio(jsonResponse)

            return response
        } catch (var11: Exception) {

            var11.printStackTrace()
            return null
        }

        return null
    }

    fun getPromocoes(): Array<Lanche>? {
        var url = WebServices().getUrlRest() + WebServices().getPromos()

        try {
            var http = getHttpHelper()

            http.doGet(url)
            val jsonResponse = http.getString()
            val response = DexParser().parseCardapio(jsonResponse)

            return response
        } catch (var11: Exception) {

            var11.printStackTrace()
            return null
        }

        return null
    }

    fun getPedidos(): Array<Lanche>? {
        var url = WebServices().getUrlRest() + WebServices().getMeusPedidos()

        try {
            var http = getHttpHelper()

            http.doGet(url)
            val jsonResponse = http.getString()
            val response = DexParser().parseCardapio(jsonResponse)

            return response
        } catch (var11: Exception) {

            var11.printStackTrace()
            return null
        }

        return null
    }

    fun putPedido(id: Int): Boolean {
        var url = WebServices().getUrlRest() + WebServices().putPedido() + id

        try {
            var http = getHttpHelper()

            http.doPut(url,null,"","UTF-8")
            val jsonResponse = http.getString()
            val response = DexParser().parseResponse(jsonResponse)

            if (id == response.idSandwich)
                return true
        } catch (var11: Exception) {

            var11.printStackTrace()
            return false
        }

        return false
    }

    fun putPedidoWithExtras(id: Int, extras: String): Boolean {
        var url = WebServices().getUrlRest() + WebServices().putPedido() + id

        try {
            var http = getHttpHelper()

            val map: MutableMap<String, String> = hashMapOf("extras" to extras)
            http.doPut(url,map,"","UTF-8")

            val jsonResponse = http.getString()
            val response = DexParser().parseResponse(jsonResponse)

            if (id == response.idSandwich)
                return true
        } catch (var11: Exception) {

            var11.printStackTrace()
            return false
        }

        return false
    }

    fun getTodosOsIngredientes(): Array<Lanche>? {
        var url = WebServices().getUrlRest() + WebServices().getIngredientes()

        try {
            var http = getHttpHelper()
            http.doGet(url)
            val jsonResponse = http.getString()
            val response = DexParser().parseCardapio(jsonResponse)

            return response
        } catch (var11: Exception) {

            var11.printStackTrace()
            return null
        }

        return null
    }

}