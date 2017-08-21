package br.com.cng.dextrasistemasprova.HttpService

import android.util.Base64
import br.com.cng.dextrasistemasprova.domain.Constant.Constant
import br.com.cng.dextrasistemasprova.utils.IOUtils
import br.com.cng.dextrasistemasprova.utils.MySSLSocketFactory
import br.com.livetouch.base.util.AndroidUtils
import org.apache.http.HttpVersion
import org.apache.http.client.ClientProtocolException
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpPost
import org.apache.http.conn.scheme.PlainSocketFactory
import org.apache.http.conn.scheme.Scheme
import org.apache.http.conn.scheme.SchemeRegistry
import org.apache.http.conn.ssl.SSLSocketFactory
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager
import org.apache.http.params.BasicHttpParams
import org.apache.http.params.HttpConnectionParams
import org.apache.http.params.HttpProtocolParams
import java.io.IOException
import java.io.InputStream
import java.security.KeyStore
import java.util.*

/**
 * Created by nicolaugalves on 20/08/17.
 */


class HttpHelperConnector {

    private var response: String? = null
    private val context = AndroidUtils.getContext()
    private var basicAuth: String? = null
    var string: String? = null
        private set
    private var headers: MutableMap<String, String>? = null

    fun setBasicAuth(basicAuth: String) {
        this.basicAuth = basicAuth
    }


    @Throws(ClientProtocolException::class, IOException::class)
    fun doGet(url: String) {
        var inputStream: InputStream? = null
        var result = ""
        val client = DefaultHttpClient()
        HttpConnectionParams.setConnectionTimeout((client as HttpClient).params, '\uea60'.toInt())
        val get = HttpGet(url)
        if (this.basicAuth != null) {
            val authorizationString = "Basic " + this.basicAuth
            get.setHeader("Authorization", authorizationString)
        }

        if (this.headers != null) {
            val keySet = this.headers!!.keys
            val var8 = keySet.iterator()

            while (var8.hasNext()) {
                val key = var8.next()
                val value = this.headers!![key] as String
                get.setHeader(key, value)
            }
        }

        val response = (client as HttpClient).execute(get)
        if (response != null) {
            inputStream = response.entity.content
            result = IOUtils.toString(inputStream)
            println("PSA - REST RESPONSE :" + result)
            this.response = result
        }

    }

    fun setBasicAuth(login: String, senha: String) {
        this.basicAuth = Base64.encodeToString((login + ":" + senha).toByteArray(), 2)
    }

    fun addHeader(key: String, value: String) {
        if (this.headers == null) {
            this.headers = HashMap()
        }

        this.headers!!.put(key, value)
    }

    private val httpClient: HttpClient
        get() {
            try {
                val trustStore = KeyStore.getInstance(KeyStore.getDefaultType())
                trustStore.load(null as InputStream?, null as CharArray?)
                val sf = MySSLSocketFactory(trustStore)
                sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER)
                val params = BasicHttpParams()
                HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1)
                HttpProtocolParams.setContentCharset(params, "UTF-8")
                val registry = SchemeRegistry()
                registry.register(Scheme("http", PlainSocketFactory.getSocketFactory(), 80))
                registry.register(Scheme("https", sf, 443))
                val ccm = ThreadSafeClientConnManager(params, registry)
                return DefaultHttpClient(ccm, params)
            } catch (var6: Exception) {
                return DefaultHttpClient()
            }

        }

    @Throws(ClientProtocolException::class, IOException::class)
    fun doPost(url: String, request: String, charset: String?) {
        var inputStream: InputStream? = null
        var result = ""
        val client = if (Constant.IS_PROD) DefaultHttpClient() else this.httpClient
        HttpConnectionParams.setConnectionTimeout(client.params, '\uea60'.toInt())
        val post = HttpPost(url)
        val se = StringEntity(request)
        post.entity = se
        post.setHeader("Accept", "application/json")
        post.setHeader("Content-type", "application/json")
        if (this.basicAuth != null) {
            val authorizationString = "Basic " + this.basicAuth!!
            post.setHeader("Authorization", authorizationString)
        }

        if (this.headers != null) {
            val keySet = this.headers!!.keys
            val var11 = keySet.iterator()

            while (var11.hasNext()) {
                val key = var11.next()
                val value = this.headers!![key] as String
                post.setHeader(key, value)
            }
        }

        val response = client.execute(post)
        if (response != null) {
            if (response.statusLine.statusCode != 200) {
                throw IOException("[" + response.statusLine.statusCode + "]")
            }

            inputStream = response.entity.content
            result = if (charset != null) IOUtils.toString(inputStream, charset) else IOUtils.toString(inputStream)
            println("PSA - REST RESPONSE :" + result)
            this.string = result
        }

    }
}

