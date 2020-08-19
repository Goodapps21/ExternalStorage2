package com.example.externalstorage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var fileNamePuC = " public_note.txt"
    var fileNamePrV = " private_note.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        writePuc.setOnClickListener {
            writePublicFile()
        }
        writePrV.setOnClickListener {
            writePrivateFile()
        }

        readPuc.setOnClickListener {
            var path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            var myFile = File(path,fileNamePuC)
            var sB = StringBuilder()
            FileInputStream(myFile).bufferedReader().forEachLine {
                sB.append(it)
            }
            showTxt.text = sB.toString()
        }
        readPrV.setOnClickListener {

            var path = getExternalFilesDir("any Folder")
            var myFile = File(path,fileNamePrV)
            var sB = StringBuilder()
            FileInputStream(myFile).bufferedReader().forEachLine {
                sB.append(it)
            }
            showTxt.text = sB.toString()
        }


    }
    private fun writePublicFile(){
        try {
            var dataTxt = enterTxt.text.toString()
            var path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            var myFile = File(path,fileNamePuC)
          var fileout =  FileOutputStream(myFile)
            fileout.write(dataTxt.toByteArray())
            fileout.close()
        }catch (e:Exception){}
    }
    private fun writePrivateFile(){
        try {
            var dataTxt = enterTxt.text.toString()
            var path = getExternalFilesDir("any Folder")
            var myFile = File(path,fileNamePrV)
            var fileout =  FileOutputStream(myFile)
            fileout.write(dataTxt.toByteArray())
            fileout.close()
        }catch (e:Exception){}
    }
}