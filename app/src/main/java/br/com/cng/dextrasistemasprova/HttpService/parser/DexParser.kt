package br.com.cng.dextrasistemasprova.HttpService.parser

import br.com.cng.dextrasistemasprova.domain.Lanche
import br.com.cng.dextrasistemasprova.domain.ResponseRestaurante
import com.google.gson.Gson

/**
 * Created by nicolaugalves on 20/08/17.
 */


class DexParser {
    fun parseCardapio(jsonResponse: String?): Array<Lanche>? {
        val lanches = Gson().fromJson(jsonResponse, Array<Lanche>::class.java)
        return lanches
    }

    fun  parseResponse(jsonResponse: String): ResponseRestaurante {
        val rr = Gson().fromJson(jsonResponse, ResponseRestaurante::class.java)
        return rr
    }

    fun  parseResponseList(jsonResponse: String): Array<ResponseRestaurante>? {
        val rrList = Gson().fromJson(jsonResponse, Array<ResponseRestaurante>::class.java)
        return rrList
    }

}