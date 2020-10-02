/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.ConnectionDB;
import POJO.SanPham;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author btooo
 */
public class SanPhamDAO {
    public static ArrayList<SanPham> getDSSP(){
        ArrayList<SanPham> dssp = new ArrayList<SanPham>();
        try {
            String sql = "select masp, tensp, giatien, dvt, malsp from sanpham";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                SanPham sp = new SanPham(rs.getString("masp").trim(), rs.getString("tensp").trim(), rs.getInt("giatien"), rs.getString("dvt").trim(), rs.getString("malsp").trim());
                dssp.add(sp);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu sản phẩm");
        }
        return dssp;
    }
    
    public static void ThemXoaSuaSanPham(String sql){
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
    
    public static void XoaSanPham(ArrayList<SanPham> dssp, String masp){
        dssp.removeIf(x -> x.getMasp().equals(masp));
    }
    
    public static void SuaSanPham(ArrayList<SanPham> dssp, SanPham sanpham){
        for(SanPham sp: dssp){
            if(sp.getMalsp().equals(sanpham.getMalsp())){
                sp.setTensp(sanpham.getTensp());
                sp.setDvt(sanpham.getDvt());
                sp.setGiatien(sanpham.getGiatien());
                sp.setMalsp(sanpham.getMalsp());
            }
        }
    }
    
    public static Boolean KiemTraMaTrung(ArrayList<SanPham> dssp, String masp){
        for(SanPham sp: dssp){
            if(sp.getMasp().equals(masp))
                return true;
        }
        return false;
    }
    
    public static String MaSanPham(ArrayList<SanPham> dssp, String tensp){
        for(SanPham sp : dssp)
            if(sp.getTensp().equals(tensp))
                return sp.getMasp();
        return "";
    }
    
    public static String TenSanPham(ArrayList<SanPham> dssp, String masp){
        for(SanPham sp : dssp)
            if(sp.getMasp().equals(masp))
                return sp.getTensp();
        return "";
    }
    
    public static int ThanhTien(ArrayList<SanPham> dssp, String masp, int soluong, int giamgia){
        int thanhtien = 0;
        for(SanPham sp : dssp)
            if(sp.getMasp().equals(masp))
                thanhtien = sp.getGiatien() * soluong - giamgia;
        return thanhtien;
    }
    
    public static Boolean KiemTraTonTaiMaLSP(ArrayList<SanPham> dssp, String malsp){
        for(SanPham sp : dssp)
            if(sp.getMalsp().equals(malsp))
                return true;
        return false;
    }
}
