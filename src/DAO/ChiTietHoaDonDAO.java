/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.ConnectionDB;
import POJO.ChiTietHoaDon;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author btooo
 */
public class ChiTietHoaDonDAO {
    public static ArrayList<ChiTietHoaDon> getDSCTHD(){
        ArrayList<ChiTietHoaDon> dscthd = new ArrayList<ChiTietHoaDon>();
        try {
            String sql = "select * from chitiethoadon";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                ChiTietHoaDon cthd = new ChiTietHoaDon(rs.getString("mahd").trim(), rs.getString("masp").trim(), rs.getInt("soluong"), rs.getInt("giamgia"), rs.getInt("thanhtien"));
                dscthd.add(cthd);
            }
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu chi tiết hoá đơn");
        }
        return dscthd;
    }
    
    public static void ThemXoaSuaCTHD(String sql){
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
    
    public static int TongTien(ArrayList<ChiTietHoaDon> dscthd, String mahd){
        int sum = 0;
        for(ChiTietHoaDon cthd : dscthd)
            if(cthd.getMahd().equals(mahd))
                sum += cthd.getThanhtien();
        return sum;
    }
    
    public static ArrayList<ChiTietHoaDon> getDSCTHDTheoMaHD(ArrayList<ChiTietHoaDon> dscthd, String mahd){
        ArrayList<ChiTietHoaDon> cthdmahd = new ArrayList<ChiTietHoaDon>();
        for(ChiTietHoaDon cthd : dscthd){
            if(cthd.getMahd().equals(mahd)){
                ChiTietHoaDon cthd1 = new ChiTietHoaDon(cthd.getMahd(), cthd.getMasp(), cthd.getSoluong(), cthd.getGiamgia(), cthd.getThanhtien());
                cthdmahd.add(cthd1);
            }
        }
        return cthdmahd;
    }
    
    public static void XoaHDDaThanhToan(ArrayList<ChiTietHoaDon> dscthd, String mahd){
        dscthd.removeIf(x -> x.getMahd().equals(mahd));
    }
    
    public static Boolean KiemTraSPTonTaiTrongHD(ArrayList<ChiTietHoaDon> dscthd, String mahd, String masp){
        for(ChiTietHoaDon cthd : dscthd){
            if(cthd.getMahd().equals(mahd) && cthd.getMasp().equals(masp))
                return true;
        }
        return false;
    }
    
    public static Boolean KiemTraTonTaiMaSP(ArrayList<ChiTietHoaDon> dscthd, String masp){
        for(ChiTietHoaDon cthd : dscthd)
            if(cthd.getMasp().equals(masp))
                return true;
        return false;
    }
}
