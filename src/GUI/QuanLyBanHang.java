/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.BanDAO;
import DAO.ChiTietHoaDonDAO;
import DAO.HoaDonDAO;
import DAO.NhanVienDAO;
import DAO.SanPhamDAO;
import POJO.Ban;
import POJO.ChiTietHoaDon;
import POJO.ConnectionDB;
import POJO.HoaDon;
import POJO.SanPham;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author btooo
 */
public class QuanLyBanHang extends javax.swing.JFrame {

    Vector tblDataBan = new Vector();
    Vector tblTitleBan = new Vector();
    Vector tblDataCTHD = new Vector();
    Vector tblTitleCTHD = new Vector();
    DefaultTableModel tblModel;
    
    static ArrayList<HoaDon> dshd = HoaDonDAO.getDSHD();
    static ArrayList<ChiTietHoaDon> dscthd = ChiTietHoaDonDAO.getDSCTHD();
    
    public QuanLyBanHang() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        txtTongTien.setEnabled(false);
        datformvitrigiua();
        bangban();
        laydulieuban();
        taidulieucomboboxssanpham();
        bangchitiethoadon();
        txtSoLuong.setText("" + 1);
        txtGiamGia.setText("" + 0);
        txtTongTien.setText("" + 0);
        btnThanhToan.setEnabled(false);
        btnThemMon.setEnabled(false);
        btnChuyenBan.setEnabled(false);
        jLabel1.setText("Xin chào nhân viên " + NhanVienDAO.TimTenNVBangTaiKhoan(QuanLyNhanVien.dsnv, DangNhap.taikhoan) + " - " + NhanVienDAO.TimMaNVBangTaiKhoan(QuanLyNhanVien.dsnv, DangNhap.taikhoan));
    }
    
    public void datformvitrigiua(){
        this.setTitle("Quản lý bán hàng");
        int w = this.getWidth();
        int h = this.getHeight();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(
                (screenSize.width/2)-(w/2),
                ((screenSize.height/2)-(h/2)),w,h);
    }
    
    public void bangban(){
        tblTitleBan.add("Mã bàn"); tblTitleBan.add("Tên bàn"); tblTitleBan.add("Trạng thái");
    }
    
    public void bangchitiethoadon(){
        tblTitleCTHD.add("Tên sản phẩm"); tblTitleCTHD.add("Số lượng"); 
        tblTitleCTHD.add("Giảm giá"); tblTitleCTHD.add("Thành tiền");
        tblCTHD.setModel(new DefaultTableModel(tblDataCTHD, tblTitleCTHD));
    }
    
    public void laydulieuban(){
        for(Ban b : QuanLyBan.dsb){
            Vector v = new Vector();
            v.add(b.getMaban()); v.add(b.getTenban()); v.add(b.getTrangthai());
            tblDataBan.add(v);
            cbboxBan.addItem(b.getMaban());
        }
        tblBan.setModel(new DefaultTableModel(tblDataBan, tblTitleBan));
    }
    
    public void taidulieucomboboxssanpham(){
        for(SanPham sp : QuanLySanPham.dssp){
            cbboxNuocUong.addItem(sp.getTensp());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBan = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cbboxNuocUong = new javax.swing.JComboBox<>();
        btnThemMon = new javax.swing.JButton();
        txtSoLuong = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCTHD = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnChuyenBan = new javax.swing.JButton();
        cbboxBan = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtGiamGia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        txtTongTien = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("jLabel1");

        tblBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBan);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Danh sách bàn");

        btnThemMon.setText("Thêm nước uống");
        btnThemMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMonActionPerformed(evt);
            }
        });

        txtSoLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSoLuongKeyTyped(evt);
            }
        });

        tblCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblCTHD);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Giảm giá:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Nước uống:");

        btnChuyenBan.setText("Chuyển bàn");
        btnChuyenBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenBanActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Số lượng:");

        txtGiamGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGiamGiaKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Tổng tiền:");

        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        txtTongTien.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(cbboxNuocUong, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(18, 18, 18)
                            .addComponent(btnThemMon))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5))
                            .addGap(324, 324, 324)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnChuyenBan)
                            .addComponent(cbboxBan, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThanhToan)))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnThemMon, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnChuyenBan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbboxBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbboxNuocUong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))))))
                .addGap(107, 107, 107))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void capnhattrangthaiphong(int i){
        if(tblBan.getValueAt(i, 2).toString().equals("Còn trống")){
            String sql = "update ban set trangthai = N'Đang phục vụ' where maban = '"+tblBan.getValueAt(i, 0).toString().trim()+"'";
            BanDAO.ThemXoaSuaBan(sql);
            tblBan.setValueAt("Đang phục vụ", i, 2);
            String maban = tblBan.getValueAt(i, 0).toString();
            String sql1 = "set dateformat dmy insert into hoadon (mahd, manv, maban, ngaylaphd, tongtien, tinhtrang) values ('"+HoaDonDAO.MaHoaDon(dshd).trim()+"', '"+NhanVienDAO.TimMaNVBangTaiKhoan(QuanLyNhanVien.dsnv, DangNhap.taikhoan).trim()+"', '"+maban+"', getdate(), 0, default)";
            HoaDonDAO.ThemXoaSuaHD(sql1);  
            String date = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(LocalDateTime.now());
            dshd.add(new HoaDon(HoaDonDAO.MaHoaDon(dshd).trim(), NhanVienDAO.TimMaNVBangTaiKhoan(QuanLyNhanVien.dsnv, DangNhap.taikhoan).trim(), maban, date, 0, "Chưa thanh toán"));
        }
    }
    
    public Boolean kiemtratxt(){
        if(txtGiamGia.getText().equals("") || txtSoLuong.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin", "Thông báo", 2);
            return false;
        }
        return true;
    }

    public Boolean kiemtrasptronghd(String mahd, String masp){
        if(ChiTietHoaDonDAO.KiemTraSPTonTaiTrongHD(dscthd, mahd, masp)){
            JOptionPane.showMessageDialog(this, "Sản phẩm này đã có trong bàn, không thể thêm được nữa", "Thông báo", 2);
            return false;
        }
        return true;
    }
    
    private void btnThemMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMonActionPerformed
        int i = tblBan.getSelectedRow();
        if(i < 0){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn bàn để thêm thức uống", "Thông báo", 2);
            return;
        }
        if(kiemtratxt()){
            if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thêm?", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                capnhattrangthaiphong(i);   
                String maban = tblBan.getValueAt(i, 0).toString();
                String tensanpham = cbboxNuocUong.getSelectedItem().toString();
                int soluong = Integer.parseInt(txtSoLuong.getText());
                int giamgia = Integer.parseInt(txtGiamGia.getText());
                String mahd = HoaDonDAO.MaHoaDonDangPhucVu(dshd, maban).trim();
                String masp = SanPhamDAO.MaSanPham(QuanLySanPham.dssp, tensanpham).trim();
                int thanhtien = SanPhamDAO.ThanhTien(QuanLySanPham.dssp, SanPhamDAO.MaSanPham(QuanLySanPham.dssp, tensanpham), soluong, giamgia);
                String sql = "insert into chitiethoadon values ('"+mahd+"', '"+masp+"', "+soluong+", "+giamgia+", "+thanhtien+") exec tongtien_hoadon @mahd = '"+mahd+"'";
                ChiTietHoaDonDAO.ThemXoaSuaCTHD(sql);
                dscthd.add(new ChiTietHoaDon(mahd, masp, soluong, giamgia, thanhtien));
                Vector v = new Vector();
                v.add(tensanpham); v.add(soluong);
                v.add(giamgia); v.add(SanPhamDAO.ThanhTien(QuanLySanPham.dssp, SanPhamDAO.MaSanPham(QuanLySanPham.dssp, tensanpham), soluong, giamgia));
                tblDataCTHD.add(v);
                tblCTHD.setModel(new DefaultTableModel(tblDataCTHD, tblTitleCTHD));
                txtTongTien.setText("" + ChiTietHoaDonDAO.TongTien(dscthd, mahd));
                buttonthanhtoan();  
            }
        }
    }//GEN-LAST:event_btnThemMonActionPerformed

    public void buttonthanhtoan(){
        if(Integer.parseInt(txtTongTien.getText()) > 0)
        {
            btnThanhToan.setEnabled(true);
            btnChuyenBan.setEnabled(true);
        }
        else
        {
            btnThanhToan.setEnabled(false);
            btnChuyenBan.setEnabled(false);
        }
    }
    
    private void tblBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBanMouseClicked
        tblModel = (DefaultTableModel) tblCTHD.getModel();
        tblModel.setRowCount(0);
        tblDataCTHD.clear();
        int i = tblBan.getSelectedRow();
        String maban = tblBan.getValueAt(i, 0).toString();
        ArrayList<ChiTietHoaDon> cthdmahd = ChiTietHoaDonDAO.getDSCTHDTheoMaHD(dscthd, HoaDonDAO.MaHoaDonDangPhucVu(dshd, maban));
        for(ChiTietHoaDon cthd : cthdmahd){
            Vector v = new Vector();
            v.add(SanPhamDAO.TenSanPham(QuanLySanPham.dssp, cthd.getMasp())); v.add(cthd.getSoluong());
            v.add(cthd.getGiamgia()); v.add(cthd.getThanhtien());
            tblDataCTHD.add(v);
        }
        tblCTHD.setModel(new DefaultTableModel(tblDataCTHD, tblTitleCTHD));
        txtTongTien.setText("" + ChiTietHoaDonDAO.TongTien(dscthd, HoaDonDAO.MaHoaDonDangPhucVu(dshd, maban)));
        btnThemMon.setEnabled(true);
        btnChuyenBan.setEnabled(true);
        buttonthanhtoan();
    }//GEN-LAST:event_tblBanMouseClicked
   
    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        int i = tblBan.getSelectedRow();
        if(i >= 0){
            if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thanh toán?", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                String maban = tblBan.getValueAt(i, 0).toString();
                String mahd = HoaDonDAO.MaHoaDonDangPhucVu(dshd, maban).trim();
                String updateb = "update ban set trangthai = N'Còn trống' where maban = '"+maban+"'";      
                String updatehd = "update hoadon set tinhtrang = N'Đã thanh toán' where mahd = '"+mahd+"'";
                BanDAO.ThemXoaSuaBan(updateb);
                BanDAO.SuaTrangThaiBan(QuanLyBan.dsb, maban, "Còn trống");
                HoaDonDAO.ThemXoaSuaHD(updatehd);
                HoaDonDAO.SuaTinhTrang(dshd, mahd);
                tblBan.setValueAt("Còn trống", i, 2);
                tblModel = (DefaultTableModel) tblCTHD.getModel();
                tblModel.setRowCount(0);
                ChiTietHoaDonDAO.XoaHDDaThanhToan(dscthd, mahd);
                txtTongTien.setText("0");
            }
        }
        else{  
            JOptionPane.showMessageDialog(this, "Vui lòng chọn bàn để thanh toán", "Thông báo", 2);
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void txtSoLuongKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuongKeyTyped
        char c = evt.getKeyChar();
        if(c < '0' || c > '9')
            evt.consume();
    }//GEN-LAST:event_txtSoLuongKeyTyped

    private void txtGiamGiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiamGiaKeyTyped
        char c = evt.getKeyChar();
        if(c < '0' || c > '9')
            evt.consume();
    }//GEN-LAST:event_txtGiamGiaKeyTyped

    public Boolean kiemtraban(int i){
        if(BanDAO.KiemTraBan(QuanLyBan.dsb, cbboxBan.getSelectedItem().toString().trim())){
            JOptionPane.showMessageDialog(this, "Bàn này đang phục vụ, vui lòng chọn bàn khác", "Thông báo", 2);
            return false;
        }
        return true;
    }
    
    private void btnChuyenBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenBanActionPerformed
        int i = tblBan.getSelectedRow();
        if(i < 0){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn bàn để thêm thức uống", "Thông báo", 2);
            return;
        }
        if(kiemtraban(i) && JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn đổi bàn?", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            String maban = tblBan.getValueAt(i, 0).toString().trim();
            String mabancandoi = cbboxBan.getSelectedItem().toString().trim();
            String mahd = HoaDonDAO.MaHoaDonDangPhucVu(dshd, maban).trim();
            String sql = "exec doiban @mahd = '"+mahd+"', @maban = '"+maban+"', @mabancandoi = '"+mabancandoi+"'";
            HoaDonDAO.ThemXoaSuaHD(sql);
            HoaDonDAO.DoiBan(dshd, mahd, mabancandoi);
            BanDAO.SuaTrangThaiBan(QuanLyBan.dsb, maban, "Còn trống");
            BanDAO.SuaTrangThaiBan(QuanLyBan.dsb, mabancandoi, "Đang phục vụ");
            tblBan.setValueAt("Còn trống", i, 2);
            for(int x = 0; x < tblBan.getRowCount(); x++){
                if(tblBan.getValueAt(x, 0).toString().trim().equals(mabancandoi))
                    tblBan.setValueAt("Đang phục vụ", x, 2);
            }
            tblModel = (DefaultTableModel) tblCTHD.getModel();
            tblModel.setRowCount(0);
        }    
    }//GEN-LAST:event_btnChuyenBanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyBanHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChuyenBan;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemMon;
    private javax.swing.JComboBox<String> cbboxBan;
    private javax.swing.JComboBox<String> cbboxNuocUong;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblBan;
    private javax.swing.JTable tblCTHD;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
