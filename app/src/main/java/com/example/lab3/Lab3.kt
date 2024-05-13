package com.example.lab3

fun main(){
    // Khai báo và sử dụng lambda funtion

    val soA : Int? = 5
    val soB : Int? = 10
    val tong = tinhTong(soA!!, soB!!)
    println("Tổng 2 số $soA và $soB = $tong")
    val hieu = tinhHieu(soA!!, soB!!)
    println("Hiệu 2 số $soA và $soB = $hieu")

    println("Bình phương $soA = ${binhPhuong(soA)}")

    println("Thương 2 số $soA và $soB = ${tinhThuong(soA.toFloat(), soB.toFloat()) ()}")

    println("In hoa chuỗi")
    val tenSV = "nguyễn văn long"
    println("In hoa chuỗi $tenSV = ${inHoa(tenSV)}")


    val length = tenSV.let { val l  = it.length
    l
    }
    println("Độ dài chuỗi $tenSV = $length")

    val a2 = soA.run{val ketqua = this * 2
    ketqua
    }
    println("Số $soA * 2 = $a2")
}

val tinhTong : (Int, Int) -> Int = {soA: Int , soB: Int -> (soA + soB)}
val tinhHieu = {soA: Int , soB: Int -> (soA - soB)}
val binhPhuong : (Int) -> Int = {it * it}

val tinhThuong = {soA: Float, soB: Float -> {
    if (soB == 0f){
        "Số bị chia phải khác 0!"
    }else{
        val c = soA / soB
        c
    }
}}

val inHoa : (String) -> String = String::uppercase