/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.ConnectionDB;
import POJO.Ban;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author btooo
 */
public class BanDAO {
    public static ArrayList<Ban> getDSB(){
        ArrayList<Ban> dsb = new ArrayList<Ban>();
        try {
            String sql = "select * from ban";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                Ban b = new Ban(rs.getString("maban").trim(), rs.getString("tenban").trim(), rs.getString("trangthai").trim());
                dsb.add(b);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu bàn");
        }
        return dsb;
    }
    
    public static void ThemXoaSuaBan(String sql){
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
    
    public static Boolean kiemtramatrung(ArrayList<Ban> dsb, String maban){
        for(Ban b: dsb){
            if(b.getMaban().equals(maban))
                return true;
        }
        return false;
    }
    
    public static void XoaBan(ArrayList<Ban> dsb, String maban){
        dsb.removeIf(x -> x.getMaban().equals(maban));
    }
    
    public static void SuaBan(ArrayList<Ban> dsb, Ban ban){
        for(Ban b: dsb){
            if(b.getMaban().equals(ban.getMaban())){
                b.setTenban(ban.getTenban());
            }
        }
    }
    
    public static void SuaTrangThaiBan(ArrayList<Ban> dsb, String maban, String trangthai){
        for(Ban b: dsb){
            if(b.getMaban().equals(maban)){
                b.setTrangthai(trangthai);
            }
        }
    }
    
    public static Boolean KiemTraBan(ArrayList<Ban> dsb, String maban){
        for(Ban b : dsb)
            if(b.getMaban().equals(maban) && b.getTrangthai().equals("Đang phục vụ"))
                return true;
        return false;        
    } 
}
