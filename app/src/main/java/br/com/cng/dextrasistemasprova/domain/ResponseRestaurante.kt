package br.com.cng.dextrasistemasprova.domain

import com.google.gson.annotations.SerializedName

/**
 * Created by nicolaugalves on 21/08/17.
 */


class ResponseRestaurante {

    var id: Int = 0

    @SerializedName("id_sandwich")
    var idSandwich: Int = 0

    var extras : ArrayList<Int>? = null
    var date: Float? = null
}