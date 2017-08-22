package br.com.cng.dextrasistemasprova.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import br.com.cng.dextrasistemasprova.R
import br.com.cng.dextrasistemasprova.fragment.TabCardaprioFragment
import br.com.cng.dextrasistemasprova.fragment.TabMeusPedidosFragment
import br.com.cng.dextrasistemasprova.fragment.TabPromosFragment

/**
 * Created by nicolaugalves on 19/08/17.
 */


open class PageAdapterDex(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> return TabCardaprioFragment()
            1 -> return TabMeusPedidosFragment()
            1 -> return TabPromosFragment()
        }

        return TabCardaprioFragment()
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        super.getPageTitle(position)

        when(position) {
            0 -> return context.getString(R.string.cardapio)
            1 -> return context.getString(R.string.meus_pedidos)
            2 -> return context.getString(R.string.promocoes)
        }

        return context.getString(R.string.cardapio)
    }
}