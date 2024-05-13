package com.example.lab3

open class Nguoi(var hoTen: String,
                 var tuoi: Int,
                 var queQuan: String,
                 var msgv: String) {

    override fun toString(): String {
        return "TT Cá Nhân --> Họ tên : $hoTen, tuổi : $tuoi, quê quán : $queQuan, msgv : $msgv "
    }
}

class CBGV(hoTen: String, tuoi: Int, queQuan: String, msgv: String,
           var luongCung: Float,
           var luongThuong: Float,
           var tienPhat: Float)
    : Nguoi(hoTen, tuoi, queQuan, msgv) {

    companion object {
        val danhSachCBGV = mutableListOf<CBGV>()

        fun themCBGV(cbgv: CBGV) {
            danhSachCBGV.add(cbgv)
            println("Đã thêm cán bộ giáo viên: $cbgv")
        }

        fun xoaCBGV(maGV: String) {
            val CheckCbgv = danhSachCBGV.find { it.msgv == maGV }
            if (CheckCbgv != null){
                danhSachCBGV.remove(CheckCbgv)
                println("Đã xóa thành công giáo viên có mã $maGV")
                println("Sau khi xóa")
                getDanhSachGV()
            }else{
                println("Không tìm thấy giáo viên có mã $maGV")
            }
        }

        fun getDanhSachGV(){
            if (danhSachCBGV.size == 0){
                println("Danh sách rỗng!")
            }else{
                println("Danh sách CBGV")
                for (gv in danhSachCBGV){
                    println(gv)
                }
            }
        }
    }
    fun luongThucLinh(luongCung: Float, luongThuong: Float, tienPhat: Float): Float {
        val tong = luongCung + luongThuong - tienPhat
        return tong
    }

    override fun toString(): String {
        return super.toString() + " --> Có lương cứng = $luongCung đ, Lương thưởng = $luongThuong đ , Tiền phạt = $tienPhat đ\n" +
                "--> Tổng thực lĩnh = ${luongThucLinh(luongCung,luongThuong,tienPhat)} đ"
    }
}

fun main(){
    do {
        println("Bài 7 buổi 3")
        println("1. Hiển thị danh sách cán bộ giáo viên")
        println("2. Thêm giáo viên mới")
        println("3. Xóa giáo viên theo mã")
        println("Bấm bất kỳ để thoát")
        println("Mời bạn chọn : ")
        var choose = readLine()?.toIntOrNull() ?: -1
        when(choose){
            1 -> CBGV.getDanhSachGV()
            2 -> addCBGV()
            3 -> deleteCBGV()
            else -> break
        }

        println("Bạn có muốn tiếp tục hay không ( Bấm c để tiếp tục) ?")
        var s = readLine()
        if (s != "c") break
    }while (true)
}

fun addCBGV(){
    println("Nhập tên CBGV: ")
    var hoTen = readLine().toString()
    var tuoi = 0
    do {
        println("Nhập tuổi : ")
        tuoi = readLine()?.toIntOrNull() ?: -1
        if (tuoi > 0) break
    }while (true)

    println("Nhập quê quán : ")
    val queQuan = readLine().toString()
    println("Nhập msgv : ")
    val msgv = readLine().toString()

    println("Nhập Lương cứng : ")
    val luongCung = readLine()?.toFloatOrNull() ?: 0f

    println("Nhập Lương Thưởng : ")
    val luongThuong = readLine()?.toFloatOrNull() ?: 0f

    println("Nhập tiền phạt : ")
    val tienPhat = readLine()?.toFloatOrNull() ?: 0f

    val gv = CBGV(hoTen,tuoi,queQuan,msgv,luongCung,luongThuong,tienPhat)
    CBGV.themCBGV(gv)
}

fun deleteCBGV(){
    println("Nhập mã số giáo viên muốn xóa : ")
    val maGv = readLine().toString()
    CBGV.xoaCBGV(maGv)
}
