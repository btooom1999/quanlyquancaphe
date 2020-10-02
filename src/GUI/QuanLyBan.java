/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.BanDAO;
import DAO.HoaDonDAO;
import POJO.Ban;
import POJO.ConnectionDB;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author btooo
 */
public class QuanLyBan extends javax.swing.JFrame {

    Vector tblData = new Vector();
    Vector tblTitle = new Vector();
    DefaultTableModel tblModel;
    
    static ArrayList<Ban> dsb = BanDAO.getDSB();
    
    public QuanLyBan() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        btnXoa.setEnabled(false);
        btnSua.setEnabled(false);
        datformvitrigiua();
        bangban();
        laydulieuban();
    }

    public void datformvitrigiua(){
        this.setTitle("Quản lý bàn");
        int w = this.getWidth();
        int h = this.getHeight();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(
                (screenSize.width/2)-(w/2),
                ((screenSize.height/2)-(h/2)),w,h);
    }
    
    public void bangban(){
        tblTitle.add("Mã bàn"); tblTitle.add("Tên bàn"); tblTitle.add("Trạng thái");
    }
    
    public void laydulieuban(){
        for(Ban b : dsb){
            Vector v = new Vector();
            v.add(b.getMaban()); v.add(b.getTenban()); v.add(b.getTrangthai());
            tblData.add(v);
        }
        tblBan.setModel(new DefaultTableModel(tblData, tblTitle));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtMaBan = new javax.swing.JTextField();
        txtTenBan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBan = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Mã Bàn:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Tên Bàn: ");

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

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(26, 26, 26)
                                .addComponent(txtMaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTenBan, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnSua)
                    .addComponent(btnLamMoi))
                .addGap(55, 55, 55)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBanMouseClicked
        int i = tblBan.getSelectedRow();
        String maban = tblBan.getValueAt(i, 0).toString().trim();
        String tenban = tblBan.getValueAt(i, 1).toString().trim();
        txtMaBan.setText(maban);
        txtTenBan.setText(tenban);
        btnThem.setEnabled(false);
        btnXoa.setEnabled(true);
        btnSua.setEnabled(true);
        txtMaBan.setEnabled(false);
    }//GEN-LAST:event_tblBanMouseClicked

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        txtMaBan.setEnabled(true);
        btnThem.setEnabled(true);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        tblBan.setModel(new DefaultTableModel(tblData, tblTitle));
        txtMaBan.setText("");
        txtTenBan.setText("");
    }//GEN-LAST:event_btnLamMoiActionPerformed
    
    public Boolean KiemTraTXT(){
        if(txtMaBan.getText().equals("") || txtTenBan.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin", "Thông báo", 2);
            return false;
        }
        return true;
    }
    
    public Boolean ktmahople(){
        String maban = txtMaBan.getText().trim();
        if(maban.length() <= 1){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng mã loại sản phẩm là Bxxx với x là số", "Thông báo", 2);
            return false;
        }
        String dau = maban.substring(0,1);
        if(dau.equals("B") == false){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng mã loại sản phẩm là Bxxx với x là số", "Thông báo", 2);
            return false;
        }
        try {
            int duoi = Integer.parseInt(maban.substring(1));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng mã loại sản phẩm là Bxxx với x là số", "Thông báo", 2);
            return false;
        }
        return true;
    }
    
    public Boolean ktmatrung(){
        if(BanDAO.kiemtramatrung(dsb, txtMaBan.getText().trim())){
            JOptionPane.showMessageDialog(this, "Đã trùng mã bàn, vui lòng nhập mã khác", "Thông báo", 2);
            return false;
        }
        return true;
    }
    
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if(KiemTraTXT() && ktmahople() && ktmatrung()){
            if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thêm không?", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                String sql = "insert into ban(maban, tenban, trangthai) values ('"+txtMaBan.getText().trim()+"', N'"+txtTenBan.getText().trim()+"', default)";
                BanDAO.ThemXoaSuaBan(sql);
                Ban b = new Ban(txtMaBan.getText().trim(), txtTenBan.getText().trim(), "Còn trống");
                dsb.add(b);
                Vector v = new Vector();
                v.add(txtMaBan.getText().trim()); v.add(txtTenBan.getText().trim()); v.add("Còn trống");
                tblData.add(v);
                tblBan.setModel(new DefaultTableModel(tblData, tblTitle));
            }
        }          
    }//GEN-LAST:event_btnThemActionPerformed

    public Boolean kiemtramaban(int i){
        if(HoaDonDAO.KiemTraTonTaiMaBan(QuanLyBanHang.dshd, tblBan.getValueAt(i, 0).toString().trim())){
            JOptionPane.showMessageDialog(this, "Dữ liệu này đang được sử dụng, không thể xóa", "Thông báo", 2);
            return false;
        }
        return true;
    }
    
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int i = tblBan.getSelectedRow();
        if(kiemtramaban(i)){
            if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa không?", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                String sql = "delete from ban where maban = '"+txtMaBan.getText().trim()+"'";
                BanDAO.ThemXoaSuaBan(sql);
                BanDAO.XoaBan(dsb, txtMaBan.getText().trim());      
                tblModel = (DefaultTableModel) tblBan.getModel();
                tblModel.removeRow(i);
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if(KiemTraTXT()){
            if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa không?", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                String sql = "update ban set tenban = N'"+txtTenBan.getText().trim()+"' where maban = '"+txtMaBan.getText().trim()+"'";
                BanDAO.ThemXoaSuaBan(sql);
                BanDAO.SuaBan(dsb, new Ban(txtMaBan.getText().trim(), txtTenBan.getText().trim(), "Còn trống"));
                int i = tblBan.getSelectedRow();
                tblBan.setValueAt(txtTenBan.getText().trim(), i, 1);
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLyBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyBan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBan;
    private javax.swing.JTextField txtMaBan;
    private javax.swing.JTextField txtTenBan;
    // End of variables declaration//GEN-END:variables
}
