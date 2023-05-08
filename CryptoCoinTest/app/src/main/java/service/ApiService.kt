package edu.fullerton.fz.cryptocointest

// ApiService.kt
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @Headers("Accept: application/json")
    @GET("v1/cryptocurrency/listings/latest")
    suspend fun getCryptoData(
        @Query("start") start: Int = 1,
        @Query("limit") limit: Int = 30,
        @Query("convert") convert: String = "USD"
    ): Response<CryptoResponse>
}

data class CryptoResponse(
    val status: Status,
    val data: List<Crypto>
)

data class Status(
    val timestamp: String,
    val error_code: Int,
    val error_message: String?,
    val elapsed: Int,
    val credit_count: Int
)
