package br.com.cng.dextrasistemasprova.domain

import java.io.Serializable

/**
 * Created by nicolaugalves on 20/08/17.
 */


class Lanche : Serializable {
    var id : Int? = null
    var name: String? = null
    var ingredients : MutableCollection<Int>? = null
    var image : String? = null
}