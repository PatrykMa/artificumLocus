package com.example.artificumlocus.services

class ValueParser {

    companion object{
        fun parseIntValueToString(value:Int):String{
            val str = value.toString()
            return StringBuilder(str).insert(str.length-2, ".").toString();

        }
    }
}