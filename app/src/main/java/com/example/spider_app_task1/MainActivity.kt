package com.example.spider_app_task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var opt : Spinner
    lateinit var opt1 : Spinner
    lateinit var res2 : TextView
    lateinit var res1 : TextView
    lateinit var inp1 : EditText
    lateinit var out : TextView
    lateinit var conbut : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        opt = findViewById<Spinner>(R.id.spinner)
        res2 = findViewById<TextView>(R.id.idRes2)
        res1 = findViewById<TextView>(R.id.idRes1)
        opt1 = findViewById<Spinner>(R.id.spinner1)
        inp1 = findViewById<EditText>(R.id.idInp)
        out = findViewById<TextView>(R.id.idOut)
        conbut = findViewById<Button>(R.id.idConbtn)
        var options= arrayOf("Choose the unit","Celsius(℃)","Fahrenheit(℉)","Kelvin(K)","millimeter(mm)","Centimeter(cm)","Meter(m)","Kilometer(Km)","milligram(mg)","gram(g)","Kilogram(Kg)","Km/sec","Km/hr","miles/hr")
        opt.adapter= ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)
        opt.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                res1.text = options[p2]

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                res1.text = "Please choose an option"
            }
        }
        opt1.adapter= ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)
        opt1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                res2.text = options[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                res2.text = "Please choose an option"
            }
        }
        var temp_arr= arrayOf("Celsius(℃)","Fahrenheit(℉)","Kelvin(K)")
        var sp_arr= arrayOf("Km/sec","Km/hr","miles/hr")
        var wt_arr = arrayOf("milligram(mg)","gram(g)","Kilogram(Kg)")
        var dist_arr = arrayOf("millimeter(mm)","Centimeter(cm)","Meter(m)","Kilometer(Km)")
        conbut.setOnClickListener {
            if (inp1.text.toString()!=""){
                out.text=""
                var val1=inp1.text.toString().toDouble()
                if ((res1.text.toString() in temp_arr && res2.text.toString() in  temp_arr)||(res1.text.toString() in wt_arr && res2.text.toString() in  wt_arr)||(res1.text.toString() in dist_arr && res2.text.toString() in  dist_arr)|| (res1.text.toString() in sp_arr && res2.text.toString() in  sp_arr)) {
                    if (res1.text.toString() == "Celsius(℃)"){
                        if (res2.text.toString() == "Fahrenheit(℉)"){
                            val res = (1.8*val1)+32
                            out.text = res.toString()
                        }
                        if (res2.text.toString() == "Kelvin(K)"){
                            val res = val1 + 273
                            out.text = res.toString()
                        }
                    }
                    if (res1.text.toString() == "Fahrenheit(℉)"){
                        if (res2.text.toString() == "Celsius(℃)"){
                            val res = (val1 - 32)*0.55
                            out.text = res.toString()
                        }
                        if (res2.text.toString() == "Kelvin(K)"){
                            val res = (val1 - 32)*0.55 +273
                            out.text = res.toString()
                        }
                    }
                    if (res1.text == "Kelvin(K)"){
                        if (res2.text == "Celsius(℃)"){
                            val res = val1 -273
                            out.text = res.toString()
                        }
                        if (res2.text == "Fahrenheit(℉)"){
                            val res = (val1 - 32)*0.55 + 273
                            out.text = res.toString()
                        }
                    }
                    if (res1.text.toString() == "milligram(mg)"){
                        if (res2.text.toString() == "gram(g)"){
                            val res = (val1/1000)
                            out.text = res.toString()
                        }
                        if (res2.text.toString() == "Kilogram(Kg)"){
                            val res = val1/1000000
                            out.text = res.toString()
                        }
                    }
                    if (res1.text.toString()== "gram(g)"){
                        if (res2.text.toString() == "milligram(g)"){
                            val res = val1 * 1000
                            out.text = res.toString()
                        }
                        if (res2.text.toString() == "Kilogram(Kg)"){
                            val res = val1/1000
                            out.text = res.toString()
                        }
                    }
                    if (res1.text == "Kilogram(Kg)"){
                        if (res2.text == "gram(g)"){
                            val res = val1 *1000
                            out.text = res.toString()
                        }
                        if (res2.text == "milligram(mg)"){
                            val res = val1*1000000
                            out.text = res.toString()
                        }
                    }
                    if (res1.text.toString() == "millimeter(mm)"){
                        if (res2.text.toString() == "Centimeter(cm)"){
                            val res = val1/10
                            out.text = res.toString()
                        }
                        if (res2.text.toString() == "Meter(m)"){
                            val res = val1/1000
                            out.text = res.toString()
                        }
                        if (res2.text.toString() == "Kilometer(Km)"){
                            val res =val1 / 1000000
                            out.text=res.toString()
                        }
                    }
                    if (res1.text.toString()== "Centimeter(cm)"){
                        if (res2.text.toString() == "Meter(m)"){
                            val res = val1 /100
                            out.text = res.toString()
                        }
                        if (res2.text.toString() == "millimeter(mm)"){
                            val res = val1 *10
                            out.text = res.toString()
                        }
                        if (res2.text.toString() == "Kilometer"){
                            val res = val1 / 100000
                        }
                    }
                    if (res1.text == "Meter(m)"){
                        if (res2.text == "millimeter(mm)"){
                            val res = val1 *1000
                            out.text = res.toString()
                        }
                        if (res2.text == "Centimeter(cm)"){
                            val res = val1 *100
                            out.text = res.toString()
                        }
                        if (res2.text == "Kilometer(Km)"){
                            val res= val1 /1000
                            out.text= res.toString()
                        }
                    }
                    if (res1.text == "Kilometer(Km)"){
                        if (res2.text == "millimeter(mm)"){
                            val res = val1 *1000000
                            out.text = res.toString()
                        }
                        if (res2.text == "Centimeter(cm)"){
                            val res = val1 *100000
                            out.text = res.toString()
                        }
                        if (res2.text == "Meter(m)"){
                            val res= val1 *1000
                            out.text= res.toString()
                        }
                    }
                    if (res1.text.toString() == "Km/sec"){
                        if (res2.text.toString() == "Km/hr"){
                            val res = val1 * 3600
                            out.text = res.toString()
                        }
                        if (res2.text.toString() == "miles/hr"){
                            val res = (val1 *3600)*0.62
                            out.text = res.toString()
                        }
                    }
                    if (res1.text.toString()== "Km/hr"){
                        if (res2.text.toString() == "Km/sec"){
                            val res = val1 /3600
                            out.text = res.toString()
                        }
                        if (res2.text.toString() == "miles/hr"){
                            val res = val1 *0.62
                            out.text = res.toString()
                        }
                    }
                    if (res1.text == "miles/hr"){
                        if (res2.text == "Km/hr"){
                            val res = val1 *1.61
                            out.text = res.toString()
                        }
                        if (res2.text == "Km/sec"){
                            val res = (val1*1.61) / 3600
                            out.text = res.toString()
                        }
                    }
                    Toast.makeText(this,"Successfully Converted", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this,"Choose proper units for Conversion", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                out.text=""
                Toast.makeText(this,"Enter an input", Toast.LENGTH_SHORT).show()
            }



        }

    }
}