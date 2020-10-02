/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author btooo
 */
public class HoaDon {
    private String mahd, manv, maban, ngaylaphd, tinhtrang;
    private int tongtien;

    public HoaDon(String mahd, String manv, String maban, String ngaylaphd, int tongtien, String tinhtrang) {
        this.mahd = mahd;
        this.manv = manv;
        this.maban = maban;
        this.ngaylaphd = ngaylaphd;
        this.tongtien = tongtien;
        this.tinhtrang = tinhtrang;
    }

    public String getMahd() {
        return mahd;
    }

    public String getManv() {
        return manv;
    }

    public String getMaban() {
        return maban;
    }

    public String getNgaylaphd() {
        return ngaylaphd;
    }

    public int getTongtien() {
        return tongtien;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public void setMaban(String maban) {
        this.maban = maban;
    }

    public void setNgaylaphd(String ngaylaphd) {
        this.ngaylaphd = ngaylaphd;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "mahd=" + mahd + ", manv=" + manv + ", maban=" + maban + ", ngaylaphd=" + ngaylaphd + ", tongtien=" + tongtien + ", tinhtrang=" + tinhtrang + '}';
    }
}
