package br.com.cng.dextrasistemasprova.utils

import org.apache.http.conn.ssl.SSLSocketFactory
import java.io.IOException
import java.net.Socket
import java.net.UnknownHostException
import java.security.*
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.KeyManager
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

/**
 * Created by nicolaugalves on 20/08/17.
 */


class MySSLSocketFactory @Throws(NoSuchAlgorithmException::class, KeyManagementException::class, KeyStoreException::class, UnrecoverableKeyException::class)
constructor(truststore: KeyStore) : SSLSocketFactory(truststore) {
    internal var sslContext = SSLContext.getInstance("TLS")

    init {
        val tm = object : X509TrustManager {
            @Throws(CertificateException::class)
            override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
            }

            @Throws(CertificateException::class)
            override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
            }

            override fun getAcceptedIssuers(): Array<X509Certificate>? {
                return null
            }
        }
        this.sslContext.init(null as Array<KeyManager>?, arrayOf<TrustManager>(tm), null as SecureRandom?)
    }

    @Throws(IOException::class, UnknownHostException::class)
    override fun createSocket(socket: Socket, host: String, port: Int, autoClose: Boolean): Socket {
        return this.sslContext.socketFactory.createSocket(socket, host, port, autoClose)
    }

    @Throws(IOException::class)
    override fun createSocket(): Socket {
        return this.sslContext.socketFactory.createSocket()
    }
}
