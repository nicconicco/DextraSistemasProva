package br.com.cng.dextrasistemasprova.utils

import java.io.*
import java.util.ArrayList

/**
 * Created by nicolaugalves on 20/08/17.
 */


class IOUtils {
    companion object {
        val DIR_SEPARATOR_UNIX = '/'
        val DIR_SEPARATOR_WINDOWS = '\\'
        val DIR_SEPARATOR: Char
        val LINE_SEPARATOR_UNIX = "\n"
        val LINE_SEPARATOR_WINDOWS = "\r\n"
        val LINE_SEPARATOR: String
        private val DEFAULT_BUFFER_SIZE = 4096

        fun closeQuietly(input: Reader?) {
            try {
                input?.close()
            } catch (var2: IOException) {
            }

        }

        fun closeQuietly(output: Writer?) {
            try {
                output?.close()
            } catch (var2: IOException) {
            }

        }

        fun closeQuietly(input: InputStream?) {
            try {
                input?.close()
            } catch (var2: IOException) {
            }

        }

        fun closeQuietly(output: OutputStream?) {
            try {
                output?.close()
            } catch (var2: IOException) {
            }

        }

        @Throws(IOException::class)
        fun toByteArray(input: Reader): ByteArray {
            val output = ByteArrayOutputStream()
            copy(input, output as OutputStream)
            return output.toByteArray()
        }

        @Throws(IOException::class)
        fun toByteArray(input: Reader, encoding: String): ByteArray {
            val output = ByteArrayOutputStream()
            copy(input, output as OutputStream, encoding)
            return output.toByteArray()
        }


        @Deprecated("")
        @Throws(IOException::class)
        fun toByteArray(input: String): ByteArray {
            return input.toByteArray()
        }

        @Throws(IOException::class)
        fun toCharArray(`is`: InputStream): CharArray {
            val output = CharArrayWriter()
            copy(`is`, output as Writer)
            return output.toCharArray()
        }

        @Throws(IOException::class)
        fun toCharArray(`is`: InputStream, encoding: String): CharArray {
            val output = CharArrayWriter()
            copy(`is`, output as Writer, encoding)
            return output.toCharArray()
        }

        @Throws(IOException::class)
        fun toCharArray(input: Reader): CharArray {
            val sw = CharArrayWriter()
            copy(input, sw as Writer)
            return sw.toCharArray()
        }

        @Throws(IOException::class)
        fun toString(input: InputStream): String {
            val sw = StringWriter()
            copy(input, sw as Writer)
            return sw.toString()
        }

        @Throws(IOException::class)
        fun toString(input: InputStream, encoding: String): String {
            val sw = StringWriter()
            copy(input, sw as Writer, encoding)
            return sw.toString()
        }

        @Throws(IOException::class)
        fun toString(input: Reader): String {
            val sw = StringWriter()
            copy(input, sw as Writer)
            return sw.toString()
        }


        @Deprecated("")
        @Throws(IOException::class)
        fun toString(input: ByteArray): String {
            return String(input)
        }


        @Deprecated("")
        @Throws(IOException::class)
        fun toString(input: ByteArray, encoding: String?): String {
            return if (encoding == null) String(input) else String(input, encoding)
        }

        private fun String(input: ByteArray, encoding: String): String {
            return ""
        }

        @Throws(IOException::class)
        fun readLines(input: InputStream): List<String> {
            val reader = InputStreamReader(input)
            return readLines(reader as Reader)
        }

        @Throws(IOException::class)
        fun readLines(input: InputStream, encoding: String?): List<String> {
            if (encoding == null) {
                return readLines(input)
            } else {
                val reader = InputStreamReader(input, encoding)
                return readLines(reader as Reader)
            }
        }

        @Throws(IOException::class)
        fun readLines(input: Reader): List<String> {
            val reader = BufferedReader(input)
            val list = ArrayList<String>()

            var line: String? = reader.readLine()
            while (line != null) {
                list.add(line)
                line = reader.readLine()
            }

            return list
        }

        fun toInputStream(input: String): InputStream {
            val bytes = input.toByteArray()
            return ByteArrayInputStream(bytes)
        }

        @Throws(IOException::class)
        fun toInputStream(input: String, encoding: String?): InputStream {
            val bytes = if (encoding != null) input.toByteArray(charset(encoding)) else input.toByteArray()
            return ByteArrayInputStream(bytes)
        }

        @Throws(IOException::class)
        fun write(data: ByteArray?, output: OutputStream) {
            if (data != null) {
                output.write(data)
            }

        }

        @Throws(IOException::class)
        fun write(data: ByteArray?, output: Writer) {
            if (data != null) {
                output.write(String(data))
            }

        }

        @Throws(IOException::class)
        fun write(data: ByteArray?, output: Writer, encoding: String?) {
            if (data != null) {
                if (encoding == null) {
                    write(data, output)
                } else {
                    output.write(String(data, encoding))
                }
            }

        }

        @Throws(IOException::class)
        fun write(data: CharArray?, output: Writer) {
            if (data != null) {
                output.write(data)
            }

        }

        @Throws(IOException::class)
        fun write(data: CharArray?, output: OutputStream) {
            if (data != null) {
                output.write(String(data).toByteArray())
            }

        }

        @Throws(IOException::class)
        fun write(data: CharArray?, output: OutputStream, encoding: String?) {
            if (data != null) {
                if (encoding == null) {
                    write(data, output)
                } else {
                    output.write(String(data).toByteArray(charset(encoding)))
                }
            }

        }

        @Throws(IOException::class)
        fun write(data: String?, output: Writer) {
            if (data != null) {
                output.write(data)
            }

        }

        @Throws(IOException::class)
        fun write(data: String?, output: OutputStream) {
            if (data != null) {
                output.write(data.toByteArray())
            }

        }

        @Throws(IOException::class)
        fun write(data: String?, output: OutputStream, encoding: String?) {
            if (data != null) {
                if (encoding == null) {
                    write(data, output)
                } else {
                    output.write(data.toByteArray(charset(encoding)))
                }
            }

        }

        @Throws(IOException::class)
        fun write(data: StringBuffer?, output: Writer) {
            if (data != null) {
                output.write(data.toString())
            }

        }

        @Throws(IOException::class)
        fun write(data: StringBuffer?, output: OutputStream) {
            if (data != null) {
                output.write(data.toString().toByteArray())
            }

        }

        @Throws(IOException::class)
        fun write(data: StringBuffer?, output: OutputStream, encoding: String?) {
            if (data != null) {
                if (encoding == null) {
                    write(data, output)
                } else {
                    output.write(data.toString().toByteArray(charset(encoding)))
                }
            }

        }


        @Throws(IOException::class)
        fun copy(input: InputStream, output: Writer) {
            val `in` = InputStreamReader(input)
            copy(`in` as Reader, output)
        }

        @Throws(IOException::class)
        fun copy(input: InputStream, output: Writer, encoding: String?) {
            if (encoding == null) {
                copy(input, output)
            } else {
                val `in` = InputStreamReader(input, encoding)
                copy(`in` as Reader, output)
            }

        }

        @Throws(IOException::class)
        fun copy(input: Reader, output: Writer): Int {
            val count = copyLarge(input, output)
            return if (count > 2147483647L) -1 else count.toInt()
        }

        @Throws(IOException::class)
        fun copyLarge(input: Reader, output: Writer): Long {
            val buffer = CharArray(4096)
            var count = 0L

            var n: Int
            val var5 = false
//            while (-1 != (n = input.read(buffer))) {
//                output.write(buffer, 0, n)
//                count += n.toLong()
//            }

            return count
        }

        @Throws(IOException::class)
        fun copy(input: Reader, output: OutputStream) {
            val out = OutputStreamWriter(output)
            copy(input, out as Writer)
            out.flush()
        }

        @Throws(IOException::class)
        fun copy(input: Reader, output: OutputStream, encoding: String?) {
            if (encoding == null) {
                copy(input, output)
            } else {
                val out = OutputStreamWriter(output, encoding)
                copy(input, out as Writer)
                out.flush()
            }

        }

        @Throws(IOException::class)
        fun contentEquals(input1: InputStream, input2: InputStream): Boolean {
            var input1 = input1
            var input2 = input2
            if (input1 !is BufferedInputStream) {
                input1 = BufferedInputStream(input1)
            }

            if (input2 !is BufferedInputStream) {
                input2 = BufferedInputStream(input2)
            }

            var ch2: Int
            var ch = input1.read()
            while (-1 != ch) {
                ch2 = input2.read()
                if (ch != ch2) {
                    return false
                }
                ch = input1.read()
            }

            ch2 = input2.read()
            return ch2 == -1
        }

        @Throws(IOException::class)
        fun contentEquals(input1: Reader, input2: Reader): Boolean {
            var input1 = input1
            var input2 = input2
            if (input1 !is BufferedReader) {
                input1 = BufferedReader(input1)
            }

            if (input2 !is BufferedReader) {
                input2 = BufferedReader(input2)
            }

            var ch2: Int
            var ch = input1.read()
            while (-1 != ch) {
                ch2 = input2.read()
                if (ch != ch2) {
                    return false
                }
                ch = input1.read()
            }

            ch2 = input2.read()
            return ch2 == -1
        }

        init {
            DIR_SEPARATOR = File.separatorChar
            val buf = StringWriter(4)
            val out = PrintWriter(buf)
            out.println()
            LINE_SEPARATOR = buf.toString()
        }
    }
}
