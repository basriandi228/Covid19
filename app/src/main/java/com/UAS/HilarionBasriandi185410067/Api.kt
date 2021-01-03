package com.UAS.HilarionBasriandi185410067
import com.UAS.HilarionBasriandi185410067.model.IndonesiaResponse
import com.UAS.HilarionBasriandi185410067.model.ProvinceResponse
import retrofit2.http.GET
import retrofit2.Call

interface Api {
    @GET("indonesia")
    fun getIndonesia(): Call<ArrayList<IndonesiaResponse>>

    @GET("indonesia/provinsi")
    fun getPropvince(): Call<ArrayList<ProvinceResponse>>
}