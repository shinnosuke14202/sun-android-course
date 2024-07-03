package com.example.suncourse.internet_connection

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

object FetchApi {

    private const val URL = "https://www.googleapis.com/books/v1/"

    fun getData(endpoint: String) : String {
        val newUrl = URL + endpoint
        val connection = URL(newUrl).openConnection() as HttpURLConnection
        addHeader(connection)
        connection.apply {
            requestMethod = "GET"
            doInput = true
            connect()
            return readResponse(this)
        }
    }

    private fun readResponse(connection: HttpURLConnection): String {
        val response = StringBuilder()
        val inputStreamReader = InputStreamReader(connection.inputStream)
        val bufferedReader = BufferedReader(inputStreamReader)
        var line: String?
        while (bufferedReader.readLine().also { line = it } != null) {
            response.append(line)
        }
        return response.toString()
    }

    private fun addHeader(connection: HttpURLConnection) {
        connection.setRequestProperty("content-type", "application/json")
    }

}