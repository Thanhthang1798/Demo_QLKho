package com.example.demo_qlkho;

public class DanhMuc {
    private String tendanhmuc,motadanhmuc;

    public DanhMuc(String tendanhmuc, String motadanhmuc) {
        this.tendanhmuc = tendanhmuc;
        this.motadanhmuc = motadanhmuc;
    }

    public String getTendanhmuc() {
        return tendanhmuc;
    }

    public void setTendanhmuc(String tendanhmuc) {
        this.tendanhmuc = tendanhmuc;
    }

    public String getMotadanhmuc() {
        return motadanhmuc;
    }

    public void setMotadanhmuc(String motadanhmuc) {
        this.motadanhmuc = motadanhmuc;
    }
}
