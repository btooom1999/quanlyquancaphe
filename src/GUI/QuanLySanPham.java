/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.ChiTietHoaDonDAO;
import DAO.LoaiSanPhamDAO;
import DAO.SanPhamDAO;
import POJO.ConnectionDB;
import POJO.LoaiSanPham;
import POJO.SanPham;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author btooo
 */
public class QuanLySanPham extends javax.swing.JFrame {
    
    Vector tblDataLSP = new Vector();
    Vector tblTitleLSP = new Vector();
    Vector tblDataSP = new Vector();
    Vector tblTitleSP = new Vector();
    DefaultTableModel tblModel;
    
    ArrayList<LoaiSanPham> dslsp = LoaiSanPhamDAO.getDSLSP();
    static ArrayList<SanPham> dssp = SanPhamDAO.getDSSP();
    
    public QuanLySanPham() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        datformvitrigiua();
        formloaisanpham();
        formsanpham();
    }
    
    public void formloaisanpham(){
        btnXoaLSP.setEnabled(false);
        btnSuaLSP.setEnabled(false);
        bangloaisanpham();
        laydulieuloaisanphamvacombobox();
    }
    
    public void formsanpham(){
        btnXoaSP.setEnabled(false);
        btnSuaSP.setEnabled(false);
        bangsanpham();
        laydulieusanpham();
    }
    
    public void datformvitrigiua(){
        this.setTitle("Quản lý sản phẩm");
        int w = this.getWidth();
        int h = this.getHeight();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(
                (screenSize.width/2)-(w/2),
                ((screenSize.height/2)-(h/2)),w,h);
    }
    
    public void bangloaisanpham(){
        tblTitleLSP.add("Mã loại sản phẩm"); tblTitleLSP.add("Tên loại sản phẩm");
    }
    
    public void bangsanpham(){
        tblTitleSP.add("Mã sản phẩm"); tblTitleSP.add("Tên sản phẩm"); tblTitleSP.add("Giá tiền");
        tblTitleSP.add("Đơn vị tính"); tblTitleSP.add("Loại sản phẩm");
    }
    
    public void laydulieuloaisanphamvacombobox(){
        for(LoaiSanPham lsp: dslsp){
            Vector v = new Vector();
            v.add(lsp.getMalsp()); v.add(lsp.getTenlsp());
            tblDataLSP.add(v);
            cbboxLSP.addItem(lsp.getTenlsp());
        }
        tblLSP.setModel(new DefaultTableModel(tblDataLSP, tblTitleLSP));
    }
    
    public void laydulieusanpham(){
        for(SanPham sp: dssp){
            Vector v = new Vector();
            v.add(sp.getMasp()); v.add(sp.getTensp()); v.add(sp.getGiatien());
            v.add(sp.getDvt()); v.add(LoaiSanPhamDAO.LayTenLoaiSanPham(dslsp, sp.getMalsp()));
            tblDataSP.add(v);
        }
        tblSP.setModel(new DefaultTableModel(tblDataSP, tblTitleSP));
    }
    
    public int tablepanel(){
        String str = tblPanel.getTitleAt(tblPanel.getSelectedIndex());
        if(str.equals("Loại sản phẩm"))
            return 1;
        return 2;
    }
    
    public Boolean KiemTraTXT(){
        if(tablepanel() == 1){
            if(txtMaLSP.getText().equals("") || txtTenLSP.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin", "Thông báo", 2);
                return false;
            }
        }
        else{
            if(txtMaSP.getText().equals("") || txtTenSP.getText().equals("") || txtGia.getText().equals("")
                    || txtDVT.getText().equals("") || cbboxLSP.getSelectedItem().toString().equals("")){
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin", "Thông báo", 2);
                return false;
            }
        }
        return true;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tblPanel = new javax.swing.JTabbedPane();
        pnLSP = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaLSP = new javax.swing.JTextField();
        txtTenLSP = new javax.swing.JTextField();
        btnThemLSP = new javax.swing.JButton();
        btnXoaLSP = new javax.swing.JButton();
        btnSuaLSP = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLSP = new javax.swing.JTable();
        btnLamMoiLSP = new javax.swing.JButton();
        pnSP = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDVT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbboxLSP = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSP = new javax.swing.JTable();
        btnThemSP = new javax.swing.JButton();
        btnXoaSP = new javax.swing.JButton();
        btnSuaSP = new javax.swing.JButton();
        btnLamMoiSP = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Mã Loại Sản Phẩm: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("Tên Loại Sản Phẩm :");

        btnThemLSP.setText("Thêm");
        btnThemLSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemLSPActionPerformed(evt);
            }
        });

        btnXoaLSP.setText("Xóa");
        btnXoaLSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaLSPActionPerformed(evt);
            }
        });

        btnSuaLSP.setText("Sửa");
        btnSuaLSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaLSPActionPerformed(evt);
            }
        });

        tblLSP.setModel(new javax.swing.table.DefaultTableModel(
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
        tblLSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLSP);

        btnLamMoiLSP.setText("Làm mới");
        btnLamMoiLSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiLSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnLSPLayout = new javax.swing.GroupLayout(pnLSP);
        pnLSP.setLayout(pnLSPLayout);
        pnLSPLayout.setHorizontalGroup(
            pnLSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLSPLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnLSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnLSPLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnLSPLayout.createSequentialGroup()
                        .addGroup(pnLSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnLSPLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTenLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnLSPLayout.createSequentialGroup()
                                .addComponent(btnThemLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnXoaLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSuaLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnLamMoiLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLSPLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnLSPLayout.setVerticalGroup(
            pnLSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLSPLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(pnLSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaLSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(pnLSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenLSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(pnLSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemLSP)
                    .addComponent(btnXoaLSP)
                    .addComponent(btnSuaLSP)
                    .addComponent(btnLamMoiLSP))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        tblPanel.addTab("Loại sản phẩm", pnLSP);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Mã Sản Phẩm:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Tên Sản Phẩm:");

        txtGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGiaKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Giá:");

        txtDVT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDVTKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Đơn vị tính:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Loại Sản Phẩm:");

        tblSP.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSP);

        btnThemSP.setText("Thêm");
        btnThemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSPActionPerformed(evt);
            }
        });

        btnXoaSP.setText("Xóa");
        btnXoaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSPActionPerformed(evt);
            }
        });

        btnSuaSP.setText("Sửa");
        btnSuaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSPActionPerformed(evt);
            }
        });

        btnLamMoiSP.setText("Làm mới");
        btnLamMoiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnSPLayout = new javax.swing.GroupLayout(pnSP);
        pnSP.setLayout(pnSPLayout);
        pnSPLayout.setHorizontalGroup(
            pnSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSPLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnSPLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addGroup(pnSPLayout.createSequentialGroup()
                        .addGroup(pnSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(pnSPLayout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnSPLayout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnSPLayout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(26, 26, 26)
                                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnSPLayout.createSequentialGroup()
                                    .addGroup(pnSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(pnSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtDVT, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                        .addComponent(cbboxLSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(pnSPLayout.createSequentialGroup()
                                .addComponent(btnThemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnXoaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSuaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLamMoiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnSPLayout.setVerticalGroup(
            pnSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSPLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(pnSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(pnSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbboxLSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(pnSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemSP)
                    .addComponent(btnXoaSP)
                    .addComponent(btnSuaSP)
                    .addComponent(btnLamMoiSP))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tblPanel.addTab("Sản phẩm", pnSP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tblPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tblPanel)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblLSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLSPMouseClicked
        int i = tblLSP.getSelectedRow();
        String malsp = tblLSP.getValueAt(i, 0).toString().trim();
        String tenlsp = tblLSP.getValueAt(i, 1).toString().trim();
        txtMaLSP.setText(malsp);
        txtTenLSP.setText(tenlsp);
        btnThemLSP.setEnabled(false);
        btnXoaLSP.setEnabled(true);
        btnSuaLSP.setEnabled(true);
        txtMaLSP.setEnabled(false);
    }//GEN-LAST:event_tblLSPMouseClicked

    private void btnLamMoiLSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiLSPActionPerformed
        txtMaLSP.setText("");
        txtTenLSP.setText("");
        tblLSP.setModel(new DefaultTableModel(tblDataLSP, tblTitleLSP));
        btnThemLSP.setEnabled(true);
        btnXoaLSP.setEnabled(false);
        btnSuaLSP.setEnabled(false);
        txtMaLSP.setEnabled(true);
    }//GEN-LAST:event_btnLamMoiLSPActionPerformed
  
    public Boolean ktmahople(){
        if(tablepanel() == 1){
            String malsp = txtMaLSP.getText().trim();
            if(malsp.length() <= 3){
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng mã loại sản phẩm là LSPxxx với x là số", "Thông báo", 2);
                return false;
            }
            String dau = malsp.substring(0,3);
            if(dau.equals("LSP") == false){
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng mã loại sản phẩm là LSPxxx với x là số", "Thông báo", 2);
                return false;
            }
            try {
                int duoi = Integer.parseInt(malsp.substring(3));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng mã loại sản phẩm là LSPxxx với x là số", "Thông báo", 2);
                return false;
            }
        }
        else{
            String masp = txtMaSP.getText().trim();
            if(masp.length() <= 2){
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng mã loại sản phẩm là SPxxx với x là số", "Thông báo", 2);
                return false;
            }
            String dau = masp.substring(0,2);
            if(dau.equals("SP") == false){
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng mã loại sản phẩm là SPxxx với x là số", "Thông báo", 2);
                return false;
            }
            try {
                int duoi = Integer.parseInt(masp.substring(2));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng mã loại sản phẩm là SPxxx với x là số", "Thông báo", 2);
                return false;
            }
        }
        return true;
    }
    
    public Boolean ktmatrung(){
        if(tablepanel() == 1){
            if(LoaiSanPhamDAO.KiemTraMaTrung(dslsp, txtMaLSP.getText().trim())){
                JOptionPane.showMessageDialog(this, "Đã trùng mã loại sản phẩm, vui lòng nhập mã khác", "Thông báo", 2);
                    return false;
            }
        }
        else{
            if(SanPhamDAO.KiemTraMaTrung(dssp, txtMaSP.getText().trim())){
                JOptionPane.showMessageDialog(this, "Đã trùng mã sản phẩm, vui lòng nhập mã khác", "Thông báo", 2);
                    return false;
            }
        }
        return true;
    }
    
    private void btnThemLSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemLSPActionPerformed
        if(KiemTraTXT() && ktmahople() && ktmatrung()){
            if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thêm không?", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                String sql = "insert into loaisanpham(malsp, tenlsp) values ('"+txtMaLSP.getText().trim()+"', N'"+txtTenLSP.getText().trim()+"')";  
                LoaiSanPhamDAO.ThemXoaSuaLoaiSanPham(sql);
                LoaiSanPham lsp = new LoaiSanPham(txtMaLSP.getText().trim(), txtTenLSP.getText().trim());
                dslsp.add(lsp);
                Vector v = new Vector();
                v.add(txtMaLSP.getText().trim()); v.add(txtTenLSP.getText().trim());
                tblDataLSP.add(v);
                tblLSP.setModel(new DefaultTableModel(tblDataLSP, tblTitleLSP));
                cbboxLSP.addItem(txtTenLSP.getText().trim());                                                        
            }              
        }
    }//GEN-LAST:event_btnThemLSPActionPerformed
 
    private void btnSuaLSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaLSPActionPerformed
        if(KiemTraTXT()){
            if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa không?", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                String sql = "update loaisanpham set tenlsp = N'"+txtTenLSP.getText().trim()+"' where malsp = '"+txtMaLSP.getText().trim()+"'";
                LoaiSanPhamDAO.ThemXoaSuaLoaiSanPham(sql);
                int i = tblLSP.getSelectedRow();
                String tenlspbanglsp = tblLSP.getValueAt(i, 1).toString().trim();
                LoaiSanPhamDAO.SuaLoaiSanPham(dslsp, new LoaiSanPham(txtMaLSP.getText().trim(), txtTenLSP.getText().trim()));
                tblLSP.setValueAt(txtTenLSP.getText().trim(), i, 1);
                cbboxLSP.removeItemAt(i);
                cbboxLSP.addItem(txtTenLSP.getText());
                for(int j = 0; j < tblSP.getRowCount(); j++)
                    if(tblSP.getValueAt(j, 4).equals(tenlspbanglsp))
                        tblSP.setValueAt(txtTenLSP.getText().trim(), j, 4);
                
            }
        }
    }//GEN-LAST:event_btnSuaLSPActionPerformed

    public Boolean ktmalsp(int i){
        if(SanPhamDAO.KiemTraTonTaiMaLSP(dssp, tblLSP.getValueAt(i, 0).toString().trim())){
            JOptionPane.showMessageDialog(this, "Dữ liệu này đang được sử dụng, không thể xóa", "Thông báo", 2);
            return false;
        }
        return true;
    }
    
    private void btnXoaLSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaLSPActionPerformed
        int i = tblLSP.getSelectedRow();
        if(ktmalsp(i)){
            if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa không?", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                String sql = "delete from loaisanpham where malsp = '"+txtMaLSP.getText().trim()+"'";
                LoaiSanPhamDAO.ThemXoaSuaLoaiSanPham(sql);
                LoaiSanPhamDAO.XoaLoaiSanPham(dslsp, txtMaLSP.getText().trim());
                tblModel = (DefaultTableModel) tblLSP.getModel();
                tblModel.removeRow(i);
                cbboxLSP.removeItem(txtTenLSP.getText());
            }
        }
    }//GEN-LAST:event_btnXoaLSPActionPerformed

    private void btnThemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSPActionPerformed
        if(KiemTraTXT() && ktmahople() && ktmatrung()){
            if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thêm không?", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){              
                String sql = "insert into sanpham(masp, tensp, giatien, dvt, malsp) values ('"+txtMaSP.getText().trim()+"', N'"+txtTenSP.getText().trim()+"', "
                    + ""+Integer.parseInt(txtGia.getText().trim())+", N'"+txtDVT.getText().trim()+"', '"+LoaiSanPhamDAO.LayMaLoaiSanPham(dslsp, cbboxLSP.getSelectedItem().toString().trim())+"')";
                SanPhamDAO.ThemXoaSuaSanPham(sql);
                dssp.add(new SanPham(txtMaSP.getText().trim(), txtTenSP.getText().trim(), Integer.parseInt(txtGia.getText().trim()), txtDVT.getText().trim(), LoaiSanPhamDAO.LayMaLoaiSanPham(dslsp, cbboxLSP.getSelectedItem().toString().trim())));
                Vector v = new Vector();
                v.add(txtMaSP.getText().trim()); v.add(txtTenSP.getText().trim()); v.add(Integer.parseInt(txtGia.getText().trim())); 
                v.add(txtDVT.getText().trim()); v.add(cbboxLSP.getSelectedItem().toString().trim());
                tblDataSP.add(v);
                tblSP.setModel(new DefaultTableModel(tblDataSP, tblTitleSP));                                     
            }
        }
    }//GEN-LAST:event_btnThemSPActionPerformed

    private void tblSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPMouseClicked
        int i = tblSP.getSelectedRow();
        String masp = tblSP.getValueAt(i, 0).toString();
        String tensp = tblSP.getValueAt(i, 1).toString();
        String giatien = tblSP.getValueAt(i, 2).toString();
        String dvt = tblSP.getValueAt(i, 3).toString();
        String tenlsp = tblSP.getValueAt(i, 4).toString();
        txtMaSP.setText(masp); 
        txtTenSP.setText(tensp); 
        txtGia.setText(giatien);
        txtDVT.setText(dvt); 
        cbboxLSP.setSelectedItem(tenlsp);
        btnThemSP.setEnabled(false); 
        btnXoaSP.setEnabled(true); 
        btnSuaSP.setEnabled(true);
        txtMaSP.setEnabled(false);
        
    }//GEN-LAST:event_tblSPMouseClicked

    private void btnLamMoiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiSPActionPerformed
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtGia.setText("");
        txtDVT.setText("");
        cbboxLSP.setSelectedIndex(0);
        tblSP.setModel(new DefaultTableModel(tblDataSP, tblTitleSP));
        btnThemSP.setEnabled(true);
        btnXoaSP.setEnabled(false);
        btnSuaSP.setEnabled(false);
        txtMaSP.setEnabled(true);
    }//GEN-LAST:event_btnLamMoiSPActionPerformed

    public Boolean kiemtramasp(int i){
        if(ChiTietHoaDonDAO.KiemTraTonTaiMaSP(QuanLyBanHang.dscthd, tblSP.getValueAt(i, 0).toString().trim())){
            JOptionPane.showMessageDialog(this, "Dữ liệu này đang được sử dụng, không thể xóa", "Thông báo", 2);
            return false;
        }
        return true;
    }
    
    private void btnXoaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSPActionPerformed
        int i = tblSP.getSelectedRow();
        if(kiemtramasp(i)){
            if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa không?", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                String sql = "delete from sanpham where masp = '"+txtMaSP.getText().trim()+"'";
                SanPhamDAO.ThemXoaSuaSanPham(sql);
                SanPhamDAO.XoaSanPham(dssp, txtMaSP.getText().trim());          
                tblModel = (DefaultTableModel) tblSP.getModel();
                tblModel.removeRow(i);         
            }            
        }
    }//GEN-LAST:event_btnXoaSPActionPerformed

    private void btnSuaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSPActionPerformed
        if(KiemTraTXT()){
            if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa không?", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                String sql = "update sanpham set tensp = N'"+txtTenSP.getText().trim()+"', giatien = "+Integer.parseInt(txtGia.getText().trim())+", dvt = N'"+txtDVT.getText().trim()+"', malsp = '"+LoaiSanPhamDAO.LayMaLoaiSanPham(dslsp, cbboxLSP.getSelectedItem().toString().trim())+"' where masp = '"+txtMaSP.getText().trim()+"'";
                SanPhamDAO.ThemXoaSuaSanPham(sql);
                SanPhamDAO.SuaSanPham(dssp, new SanPham(txtMaSP.getText().trim(), txtTenSP.getText().trim(), Integer.parseInt(txtGia.getText().trim()), txtDVT.getText().trim(), LoaiSanPhamDAO.LayMaLoaiSanPham(dslsp, cbboxLSP.getSelectedItem().toString().trim())));
                int i = tblSP.getSelectedRow();
                tblSP.setValueAt(txtTenSP.getText().trim(), i, 1);
                tblSP.setValueAt(Integer.parseInt(txtGia.getText().trim()), i, 2);
                tblSP.setValueAt(txtDVT.getText().trim(), i, 3);
                tblSP.setValueAt(cbboxLSP.getSelectedItem().toString().trim(), i, 4);
            }
        }
    }//GEN-LAST:event_btnSuaSPActionPerformed

    private void txtGiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiaKeyTyped
        int c = evt.getKeyChar();
        if(c < '0' || c > '9')
            evt.consume();
    }//GEN-LAST:event_txtGiaKeyTyped

    private void txtDVTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDVTKeyTyped
        int c = evt.getKeyChar();
        if(c >= '0' && c <= '9')
            evt.consume();
    }//GEN-LAST:event_txtDVTKeyTyped

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
            java.util.logging.Logger.getLogger(QuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLySanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoiLSP;
    private javax.swing.JButton btnLamMoiSP;
    private javax.swing.JButton btnSuaLSP;
    private javax.swing.JButton btnSuaSP;
    private javax.swing.JButton btnThemLSP;
    private javax.swing.JButton btnThemSP;
    private javax.swing.JButton btnXoaLSP;
    private javax.swing.JButton btnXoaSP;
    private javax.swing.JComboBox<String> cbboxLSP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnLSP;
    private javax.swing.JPanel pnSP;
    private javax.swing.JTable tblLSP;
    private javax.swing.JTabbedPane tblPanel;
    private javax.swing.JTable tblSP;
    private javax.swing.JTextField txtDVT;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaLSP;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtTenLSP;
    private javax.swing.JTextField txtTenSP;
    // End of variables declaration//GEN-END:variables
}
