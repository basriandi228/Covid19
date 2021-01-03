package com.UAS.HilarionBasriandi185410067.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.UAS.HilarionBasriandi185410067.R
import com.UAS.HilarionBasriandi185410067.adapter.ProvinceAdapter
import com.UAS.HilarionBasriandi185410067.model.ProvinceResponse
import com.UAS.HilarionBasriandi185410067.model.RetrofitClient
import kotlinx.android.synthetic.main.activity_province.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProvinceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_province)
        showProvince()
    }

    private fun showProvince() {
        rvProvince.setHasFixedSize(true)
        rvProvince.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getPropvince() .enqueue(object :
            Callback<ArrayList<ProvinceResponse>> {
            override fun onResponse(
                call: Call<ArrayList<ProvinceResponse>>,
                response: Response<ArrayList<ProvinceResponse>>
            ) {
               val list : ArrayList<ProvinceResponse>? = response.body()
                val adapter = list?.let { ProvinceAdapter(it) }
                rvProvince.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<ProvinceResponse>>, t: Throwable) {
                Toast.makeText(this@ProvinceActivity,"${t.message}" , Toast.LENGTH_SHORT).show()
            }

        })
    }
}