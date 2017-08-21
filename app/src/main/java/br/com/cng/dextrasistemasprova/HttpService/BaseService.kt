package br.com.cng.dextrasistemasprova.HttpService

import br.com.cng.dextrasistemasprova.domain.Constant.Constant

/**
 * Created by nicolaugalves on 20/08/17.
 */



open class BaseService  {
    companion object {
        val isProducao = Constant.IS_PROD

        fun getHttpHelperHomolog(): HttpHelperConnector {
            return HttpHelperConnector()
        }

        fun getHttpHelperHomolog(cpf: String): HttpHelperConnector {
            return getHttpHelper(isProducao)
        }

        fun getHttpHelper(isProd: Boolean): HttpHelperConnector {
            val http = HttpHelperConnector()
            return http
        }
    }

}