package br.com.cng.dextrasistemasprova.HttpService

import android.content.Context
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

    private fun getHttpParams(context: Context): Map<String, String> {
        val params = HashMap<String, String>()
        params.put("form_name", "form")
        params.put("mode", "json")
        return params
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

}