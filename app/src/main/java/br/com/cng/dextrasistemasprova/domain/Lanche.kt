package br.com.cng.dextrasistemasprova.domain

import java.io.Serializable

/**
 * Created by nicolaugalves on 20/08/17.
 */


class Lanche : Serializable {
    var id : Int? = 0
    var name: String? = ""
    var price: Double? = 0.0
    var description: String? = ""
    var ingredients : MutableCollection<Int>? = null
    var image : String? = ""
}