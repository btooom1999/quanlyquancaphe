/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.ConnectionDB;
import POJO.NhanVien;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author btooo
 */
public class NhanVienDAO {
    public static ArrayList<NhanVien> getDSNV(){
        ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
        try {
            String sql = "select * from nhanvien";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                NhanVien nv = new NhanVien(rs.getString("manv").trim(), rs.getString("tennv").trim(), rs.getString("ngaysinh").trim(), rs.getString("gioitinh").trim(), rs.getString("diachi").trim(), rs.getString("sdt").trim(), rs.getString("email").trim(), rs.getString("hinhanh").trim(), rs.getString("taikhoan").trim(), rs.getString("matkhau").trim());
                dsnv.add(nv);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu nhân viên");
            e.printStackTrace();
        }
        return dsnv;
    }
    
    public static void ThemXoaSuaNhanVien(String sql){
        try {
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            int i = cn.executeUpdate(sql);
            cn.close();
            System.out.println("Thêm/xóa/sửa thành công");
        } catch (Exception e) {
            System.out.println("Thêm/xóa/sửa không thành công");
        }
    }
    
    public static Boolean kiemtramatrung(ArrayList<NhanVien> dsnv, String manv){
        for(NhanVien nv: dsnv){
            if(nv.getManv().equals(manv))
                return true;
        }
        return false;
    }
    
    public static Boolean kiemtrataikhoantrung(ArrayList<NhanVien> dsnv, String taikhoan){
        for(NhanVien nv: dsnv){
            if(nv.getTaikhoan().equals(taikhoan))
                return true;
        }
        return false;
    }
    
    public static Boolean kiemtrasuataikhoankhac(ArrayList<NhanVien> dsnv, String taikhoan, String manv){
        for(NhanVien nv: dsnv){
            if(nv.getTaikhoan().equals(taikhoan) && nv.getManv().equals(manv) == false)
                return true;
        }
        return false;
    }
    
    public static void XoaNhanVien(ArrayList<NhanVien> dsnv, String manv){
        dsnv.removeIf(x -> x.getManv().equals(manv));
    }
    
    public static void SuaNhanVien(ArrayList<NhanVien> dsnv, NhanVien nhanvien){
        for(NhanVien nv: dsnv){
            if(nv.getManv().equals(nhanvien.getManv())){
                nv.setDiachi(nhanvien.getDiachi());
                nv.setEmail(nhanvien.getEmail());
                nv.setGioitinh(nhanvien.getGioitinh());
                nv.setHinhanh(nhanvien.getHinhanh());
                nv.setMatkhau(nhanvien.getMatkhau());
                nv.setNgaysinh(nhanvien.getNgaysinh());
                nv.setSdt(nhanvien.getSdt());
                nv.setTaikhoan(nhanvien.getTaikhoan());
                nv.setTennv(nhanvien.getTennv());
            }
        }
    }
    
    public static String TimMaNVBangTaiKhoan(ArrayList<NhanVien> dsnv, String taikhoan){
        for(NhanVien nv : dsnv){
            if(nv.getTaikhoan().equals(taikhoan))
                return nv.getManv();
        }
        return "";
    }
    
    public static String TimTenNVBangTaiKhoan(ArrayList<NhanVien> dsnv, String taikhoan){
        for(NhanVien nv : dsnv){
            if(nv.getTaikhoan().equals(taikhoan))
                return nv.getTennv();
        }
        return "";
    }
}
