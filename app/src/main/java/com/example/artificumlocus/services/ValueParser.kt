package com.example.artificumlocus.services

class ValueParser {

    companion object{

        @JvmStatic
        fun parseIntValueToString(value:Int):String{
            var str = value.toString()
            if(str.isEmpty()) str = "000"
            else if (str.length<2) str = "0"+ str
            else if (str.length<3) str = "00"+ str
            return StringBuilder(str).insert(str.length-2, ".").toString();

        }
    }
}