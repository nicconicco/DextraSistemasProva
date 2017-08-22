package br.com.cng.dextrasistemasprova.domain

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by nicolaugalves on 21/08/17.
 */


class ResponseRestaurante {

    var id: Int = 0

    @SerializedName("id_sandwich")
    var idSandwich: Int = 0

    var extras : Array<Int>? = null
    var date: Date? = null
}