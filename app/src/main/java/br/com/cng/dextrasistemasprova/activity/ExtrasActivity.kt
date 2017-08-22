package br.com.cng.dextrasistemasprova.activity

import android.os.Bundle
import br.com.cng.dextrasistemasprova.HttpService.DexService
import br.com.cng.dextrasistemasprova.R
import br.com.cng.dextrasistemasprova.adapter.ExtrasAdapter
import br.com.cng.dextrasistemasprova.domain.Lanche
import br.com.livetouch.base.extension.startTask
import kotlinx.android.synthetic.main.activity_extras.*

/**
 * Created by nicolaugalves on 21/08/17.
 */


class ExtrasActivity : BaseActivity() {

    var lanches : Array<Lanche>? = null
    var extras = mutableListOf<Lanche>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extras)

        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setHomeButtonEnabled(true)
        }
    }

    override fun onResume() {
        super.onResume()
        if (lanches == null) {
            taskGetTodosOsIngredientes()
        } else {
            recycler.adapter = ExtrasAdapter(lanches!!) {
                extras!!.add(it)
            }
        }
    }

    private fun taskGetTodosOsIngredientes() {
        startTask(execute = {
            lanches = DexService().getTodosOsIngredientes()
        },updateView = {
            if (lanches != null) {
                recycler.adapter = ExtrasAdapter(lanches!!) {
                    extras!!.add(it)
                }
            }
        })
    }

    override fun onActionBarHomePressed() {
        finish()
    }
}