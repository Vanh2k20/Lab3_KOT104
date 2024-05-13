package com.example.lab3

open class SinhVien(
    var hoTen : String,
    var tuoi : Int,
    var lop : String
){

    companion object {
        val listSV = mutableListOf<SinhVien>()

        fun addSV(sv : SinhVien){
            listSV.add(sv);
            println("Thêm thành công sinh viên : ${sv}")
        }

        fun getDanhSach(){
            if (listSV.size == 0){
                println("Danh sách rỗng!")
            }else{
                println("Danh sách sinh viên : ")
                for (sv in listSV){
                    println(sv)
                }
            }
        }

        fun getSinhVien(hoTen: String): SinhVien? {
            val checkSv = listSV.find { it.hoTen == hoTen }
            if (checkSv != null){
                return checkSv
            }else{
                return null
            }
        }
    }

    override fun toString(): String {
        return "Sinh Viên : Họ tên: $hoTen, Tuổi: $tuoi, Lớp: $lop"
    }

}


class TheMuon(
    var sinhVien: SinhVien,
    var maPhieu: String,
    var ngayMuon: Int,
    var hanTra: Int,
    var soHieuSach: String
){
    companion object {
        val listTheMuon = mutableListOf<TheMuon>()

        fun addTheMuon(theMuon: TheMuon){
            listTheMuon.add(theMuon)
            println("Thêm thành công : $theMuon")
            getDanhSachThe()
        }

        fun deleteTheMuon(maPhieu: String){
            var phieuCheck = listTheMuon.find { it.maPhieu == maPhieu }
            if (phieuCheck != null){
                listTheMuon.remove(phieuCheck)
                println("Đã xóa thành công phiếu $maPhieu")
            }else{
                println("Không tìm thấy phiếu nào có mã $maPhieu")
            }
        }

        fun getDanhSachThe(){
            if (listTheMuon.size == 0){
                println("Danh sách rỗng!")
            }else{
                println("Danh sách thẻ mượn : ")
                for (the in listTheMuon){
                    println(the)
                }
            }
        }
    }

    override fun toString(): String {
        return "TheMuon : Mã phiếu: $maPhieu, Ngày mượn: $ngayMuon, Hạn trả: $hanTra, Số hiệu sách: $soHieuSach -->" +
                "Sinh viên mượn : $sinhVien"
    }
}

fun main(){
    do {
        println("Bài 8 buổi 3")
        println("1. Hiển thị danh sách sinh vien")
        println("2. Hiển thị danh sách thẻ mượn")
        println("3. Thêm sinh viên mới")
        println("4. Thêm thẻ mượn ")
        println("5. Xóa thẻ mượn ")
        println("Bấm bất kỳ để thoát")
        println("Mời bạn chọn : ")
        val choose = readLine()?.toIntOrNull() ?: -1
        when(choose){
            1 -> SinhVien.getDanhSach()
            2 -> TheMuon.getDanhSachThe()
            3 -> addSinhVien()
            4 -> addTheMuon()
            5 -> deleteTheMuon()
            else -> break
        }

        println("Bạn có muốn tiếp tục hay không ( Bấm c để tiếp tục) ?")
        val s = readLine()
        if (s != "c") break
    }while (true)
}

fun addSinhVien(){
    println("Nhập họ tên sinh viên : ")
    val hoTen = readLine().toString()

    var tuoi : Int
    do {
        println("Nhập tuổi ( lớn hơn 0 ): ")
        tuoi = readLine()?.toIntOrNull() ?: -1
    }while (tuoi <= 0)

    println("Nhập lớp : ")
    val lop = readLine().toString()

    val sv = SinhVien(hoTen,tuoi,lop)
    SinhVien.addSV(sv)
}

fun addTheMuon(){
    var ngayMuon : Int
    var hanTra : Int
    var sv : SinhVien
    do {
        println("Nhập tên sinh viên mượn sách : ")
        val tenSv = readLine().toString()
        sv = SinhVien.getSinhVien(tenSv)!!
        if (sv != null) break
    }while (true)



    println("Nhập mã phiếu : ")
    val maPhieu = readLine().toString()

    do {
        println("Nhập ngày mượn (số nguyên dương) : ")
        ngayMuon = readLine()?.toIntOrNull() ?: -1
        if (ngayMuon > 0) break
    }while (true)

    do {
        println("Nhập hạn trả (số nguyên dương) : ")
        hanTra = readLine()?.toIntOrNull() ?: -1
        if (hanTra > 0) break
    }while (true)

    println("Nhập số hiệu sách : ")
    val soHieuSach = readLine().toString()

    val theMuon = TheMuon(sv,maPhieu,ngayMuon,hanTra,soHieuSach)
    TheMuon.addTheMuon(theMuon)
}

fun deleteTheMuon(){
    println("Nhập mã thẻ muốn xóa : ")
    var maThe = readLine().toString()
    TheMuon.deleteTheMuon(maThe)
}