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
public class NhanVien {
    private String manv, tennv, ngaysinh, gioitinh, diachi, sdt, email, hinhanh, taikhoan, matkhau;

    public NhanVien(String manv, String tennv, String ngaysinh, String gioitinh, String diachi, String sdt, String email, String hinhanh, String taikhoan, String matkhau) {
        this.manv = manv;
        this.tennv = tennv;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.sdt = sdt;
        this.email = email;
        this.hinhanh = hinhanh;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
    }

    public String getManv() {
        return manv;
    }

    public String getTennv() {
        return tennv;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public String getEmail() {
        return email;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "manv=" + manv + ", tennv=" + tennv + ", ngaysinh=" + ngaysinh + ", gioitinh=" + gioitinh + ", diachi=" + diachi + ", sdt=" + sdt + ", email=" + email + ", hinhanh=" + hinhanh + ", taikhoan=" + taikhoan + ", matkhau=" + matkhau + '}';
    }
}
