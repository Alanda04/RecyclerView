package com.alanda.recycleview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.alanda.recycleview.adapter.AdapterTeamBola
import com.alanda.recycleview.databinding.ActivityMainBinding
import com.alanda.recycleview.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPemain = ArrayList<Pemain>()
        listPemain.add(
            Pemain(
                "Karim Benzema",
                R.drawable.benzema,
                "Penyerang",
                "2.00m",
                " Lyon, Prancis",
                "19 Desember 1987"
            )
        )
        listPemain.add(
            Pemain(
                "Vinicius Junior",
                R.drawable.vinicius,
                "Penyerang",
                "2.00m",
                "Brazil",
                "12 Juli 2000"
            )
        )
        listPemain.add(
            Pemain(
                "Luka Modric",
                R.drawable.luka,
                "Gelandang",
                "2.00m",
                "Zadar",
                "19 September 1985"
            )
        )
        listPemain.add(
            Pemain(
                "Rodrygo",
                R.drawable.rodrygo,
                "Gelandang",
                "2.00m",
                "Brazil",
                "9 Januari 2001"
            )
        )
        listPemain.add(
            Pemain(
                "Eder Militao",
                R.drawable.eder,
                "Gelandang",
                "2.00m",
                "Brazil",
                "18 Jan 1998"
            )
        )

        binding.list.adapter =
            AdapterTeamBola(this, listPemain, object : AdapterTeamBola.OnClickListener {
                override fun detailData(item: Pemain?) {
                    Dialog(this@MainActivity).apply {
                        requestWindowFeature(Window.FEATURE_NO_TITLE)
                        setCancelable(true)
                        setContentView(R.layout.detail_data_pemain)

                        val image = this.findViewById<ImageView>(R.id.image_pemain)
                        val nama = this.findViewById<TextView>(R.id.txtNamaPemain)

                        val posisi = this.findViewById<TextView>(R.id.txtPosisi)
                        val tinggi = this.findViewById<TextView>(R.id.txtTinggi)
                        val tempatlahir = this.findViewById<TextView>(R.id.txtTempatLahir)
                        val tgllahir = this.findViewById<TextView>(R.id.txtTanggalLahir)
                        val btn = this.findViewById<Button>(R.id.btnClose)

                        image.setImageResource(item?.foto ?:0)
                        nama.text = "${item?.nama}"
                        posisi.text = "${item?.posisi}"
                        tinggi.text = "${item?.tinggi}"
                        tempatlahir.text = "${item?.tempatlahir}"
                        tgllahir.text = "${item?.tgllahir}"

                        btn.setOnClickListener{
                            this.dismiss()
                        }

                    }.show()
                }

            })
    }
}