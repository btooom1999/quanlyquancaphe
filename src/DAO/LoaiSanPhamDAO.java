/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.ConnectionDB;
import POJO.LoaiSanPham;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author btooo
 */
public class LoaiSanPhamDAO {
    public static ArrayList<LoaiSanPham> getDSLSP(){
        ArrayList<LoaiSanPham> dslsp = new ArrayList<LoaiSanPham>();
        try {
            String sql = "select * from loaisanpham";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                LoaiSanPham lsp = new LoaiSanPham(rs.getString("malsp").trim(), rs.getString("tenlsp").trim());
                dslsp.add(lsp);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu loại sản phẩm");
        }
        return dslsp;
    }
    
    public static void ThemXoaSuaLoaiSanPham(String sql){
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
    
    public static Boolean KiemTraMaTrung(ArrayList<LoaiSanPham> dslsp, String malsp){
        for(LoaiSanPham lsp: dslsp){
            if(lsp.getMalsp().equals(malsp))
                return true;
        }
        return false;
    }
    
    public static void XoaLoaiSanPham(ArrayList<LoaiSanPham> dslsp, String malsp){
        dslsp.removeIf(x -> x.getMalsp().equals(malsp));
    }
    
    public static void SuaLoaiSanPham(ArrayList<LoaiSanPham> dslsp, LoaiSanPham loaisanpham){
        for(LoaiSanPham lsp: dslsp){
            if(lsp.getMalsp().equals(loaisanpham.getMalsp())){
                lsp.setTenlsp(loaisanpham.getTenlsp());
            }
        }
    }
    
    public static String LayMaLoaiSanPham(ArrayList<LoaiSanPham> dslsp, String tenlsp){
        for(LoaiSanPham lsp: dslsp){
            if(lsp.getTenlsp().equals(tenlsp))
                return lsp.getMalsp();
        }
        return "";
    }
    
    public static String LayTenLoaiSanPham(ArrayList<LoaiSanPham> dslsp, String malsp){
        for(LoaiSanPham lsp: dslsp){
            if(lsp.getMalsp().equals(malsp))
                return lsp.getTenlsp();
        }
        return "";
    }
}
