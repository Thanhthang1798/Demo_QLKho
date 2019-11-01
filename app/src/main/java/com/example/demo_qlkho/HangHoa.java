package com.example.demo_qlkho;

public class HangHoa {
    private int hinhanh,soluong;
    private String tensp,masp,donvitinh;

    //thứ tự hình ảnh -> tên sp-> mã sp -> số lượng -> đơn vị tính
    public HangHoa(int hinhanh, String tensp, String masp, int soluong, String donvitinh) {
        this.hinhanh = hinhanh;
        this.soluong = soluong;
        this.tensp = tensp;
        this.masp = masp;
        this.donvitinh = donvitinh;
    }

    public int getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getDonvitinh() {
        return donvitinh;
    }

    public void setDonvitinh(String donvitinh) {
        this.donvitinh = donvitinh;
    }
}
