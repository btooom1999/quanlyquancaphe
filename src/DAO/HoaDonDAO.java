/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.ConnectionDB;
import POJO.HoaDon;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javafx.util.converter.LocalDateStringConverter;

/**
 *
 * @author btooo
 */
public class HoaDonDAO {
    public static ArrayList<HoaDon> getDSHD(){
        ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
        try {
            String sql = "select * from hoadon";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                HoaDon hd = new HoaDon(rs.getString("mahd").trim(), rs.getString("manv").trim(), rs.getString("maban").trim(), rs.getString("ngaylaphd").trim(), rs.getInt("tongtien"), rs.getString("tinhtrang").trim());
                dshd.add(hd);
            }
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu hoá đơn");
            e.printStackTrace();
        }
        return dshd;
    }
    
    public static void ThemXoaSuaHD(String sql){
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
    
    public static String mahd1 = "HD00";
    public static String mahd2 = "HD0";
    public static String mahd3 = "HD";
    public static String MaHoaDon(ArrayList<HoaDon> dshd){
        int i = 1;
        for(HoaDon hd : dshd)
            i++;
        if(i < 10)
            return mahd1 + i;
        else if(i > 100)
            return mahd3 + i;
        else
            return mahd2 + i;
    }
    
    public static String MaHoaDonDangPhucVu(ArrayList<HoaDon> dshd, String maban){
        for(HoaDon hd : dshd)
            if(hd.getMaban().equals(maban) && hd.getTinhtrang().equals("Chưa thanh toán"))
                return hd.getMahd();
        return "";
    }
    
    public static void SuaTinhTrang(ArrayList<HoaDon> dshd, String mahd){
        for(HoaDon hd : dshd){
            if(hd.getMahd().equals(mahd)){
                hd.setTinhtrang("Đã thanh toán");
            }
        }
    }
    
    public static void DoiBan(ArrayList<HoaDon> dshd, String mahd, String mabancandoi){
        for(HoaDon hd : dshd){
            if(hd.getMahd().equals(mahd))
                hd.setMaban(mabancandoi);
        }
    }
    
    public static Boolean KiemTraTonTaiMaBan(ArrayList<HoaDon> dshd, String maban){
        for(HoaDon hd : dshd)
            if(hd.getMaban().equals(maban))
                return true;
        return false;
    }
    
    public static Boolean KiemTraTonTaiMaNV(ArrayList<HoaDon> dshd, String manv){
        for(HoaDon hd : dshd)
            if(hd.getManv().equals(manv))
                return true;
        return false;
    }
}
