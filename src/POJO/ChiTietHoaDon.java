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
public class ChiTietHoaDon {
    private String mahd, masp;
    private int soluong, giamgia, thanhtien;

    public ChiTietHoaDon(String mahd, String masp, int soluong, int giamgia, int thanhtien) {
        this.mahd = mahd;
        this.masp = masp;
        this.soluong = soluong;
        this.giamgia = giamgia;
        this.thanhtien = thanhtien;
    }

    public String getMahd() {
        return mahd;
    }

    public String getMasp() {
        return masp;
    }

    public int getSoluong() {
        return soluong;
    }

    public int getGiamgia() {
        return giamgia;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setGiamgia(int giamgia) {
        this.giamgia = giamgia;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon{" + "mahd=" + mahd + ", masp=" + masp + ", soluong=" + soluong + ", giamgia=" + giamgia + ", thanhtien=" + thanhtien + '}';
    }
}
