package br.com.cng.dextrasistemasprova.HttpService.parser

import br.com.cng.dextrasistemasprova.domain.Lanche
import com.google.gson.Gson

/**
 * Created by nicolaugalves on 20/08/17.
 */


class DexParser {
    fun parseCardapio(jsonResponse: String?): Array<Lanche>? {
        val lanches = Gson().fromJson(jsonResponse, Array<Lanche>::class.java)
        return lanches
    }
}