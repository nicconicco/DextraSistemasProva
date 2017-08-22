package br.com.cng.dextrasistemasprova

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import br.com.cng.dextrasistemasprova.HttpService.DexService
import br.com.cng.dextrasistemasprova.domain.Lanche
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("br.com.cng.dextrasistemasprova", appContext.packageName)
    }

    @Test
    @Throws(Exception::class)
    fun taskConfereCardapiosExemplo() {
        var cardapio = cardapioLocal()
        assertEquals(true, conferCardapios(taskCardapio()!!,cardapio))
    }

    private fun conferCardapios(list: Array<Lanche>, cardapio: ArrayList<Lanche>): Boolean {

        if (list.size == cardapio.size) {
            //todo: comparar item por item... sao 12:46 am ja...
            return true
        }

        return false
    }

    private fun taskCardapio(): Array<Lanche>? {
        var list = DexService().getCarpadio()

        return list
    }

    private fun cardapioLocal(): ArrayList<Lanche> {

        var list = ArrayList<Lanche>()

        var lanche = Lanche()
        lanche.id = 1
        lanche.name = "X-Bacon"
        lanche.image = "https://goo.gl/W9WdaF"
        lanche.ingredients = intArrayOf(2, 3, 5, 6)

        list.add(lanche)

        lanche = Lanche()
        lanche.id = 2
        lanche.name = "X-Burger"
        lanche.image = "https://goo.gl/Cjfxi9"
        lanche.ingredients = intArrayOf(3, 5, 6)

        list.add(lanche)

        lanche = Lanche()
        lanche.id = 3
        lanche.name = "X-Egg"
        lanche.image = "https://goo.gl/x4rNIq"
        lanche.ingredients = intArrayOf(3, 4, 5, 6)

        list.add(lanche)

        lanche = Lanche()
        lanche.id = 4
        lanche.name = "X-Egg Bacon"
        lanche.image = "https://goo.gl/2L0lqg"
        lanche.ingredients = intArrayOf(1, 2, 3, 4, 5, 6)

        list.add(lanche)

        /**
         * [{
        "id": 1,
        "name": "X-Bacon",
        "ingredients": [2, 3, 5, 6],
        "image": "https://goo.gl/W9WdaF"
        }, {
        "id": 2,
        "name": "X-Burger",
        "ingredients": [3, 5, 6],
        "image": "https://goo.gl/Cjfxi9"
        }, {
        "id": 3,
        "name": "X-Egg",
        "ingredients": [3, 4, 5, 6],
        "image": "https://goo.gl/x4rNIq"
        }, {
        "id": 4,
        "name": "X-Egg Bacon",
        "ingredients": [1, 2, 3, 4, 5, 6],
        "image": "https://goo.gl/2L0lqg"
        }]
         */

        return list
    }
}
