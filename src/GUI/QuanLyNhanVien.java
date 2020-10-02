/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.HoaDonDAO;
import DAO.NhanVienDAO;
import POJO.ConnectionDB;
import POJO.NhanVien;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author btooo
 */
public class QuanLyNhanVien extends javax.swing.JFrame {

    Vector tblData = new Vector();
    Vector tblTitle = new Vector();
    DefaultTableModel tblModel;
    
    static ArrayList<NhanVien> dsnv = NhanVienDAO.getDSNV();
    
    public QuanLyNhanVien() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setenabled();
        datformvitrigiua();
        bangnhanvien();
        laydulieunhanvien();
    }
    
    public void datformvitrigiua(){
        this.setTitle("Quản lý nhân viên");
        int w = this.getWidth();
        int h = this.getHeight();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(
                (screenSize.width/2)-(w/2),
                ((screenSize.height/2)-(h/2)),w,h);
    }
    
    public void bangnhanvien(){
        tblTitle.add("Mã nhân viên"); tblTitle.add("Tên nhân viên"); tblTitle.add("Ngày sinh"); tblTitle.add("Giới tính");
        tblTitle.add("Địa chỉ"); tblTitle.add("Số điện thoại"); tblTitle.add("Email"); tblTitle.add("Hình ảnh");
        tblTitle.add("Tài khoản"); tblTitle.add("Mật khẩu"); 
    }
    
    public void laydulieunhanvien(){
        for(NhanVien nv : dsnv){
            Vector v = new Vector();
            v.add(nv.getManv()); v.add(nv.getTennv()); v.add(nv.getNgaysinh()); v.add(nv.getGioitinh()); v.add(nv.getDiachi());
            v.add(nv.getSdt()); v.add(nv.getEmail()); v.add(nv.getHinhanh()); v.add(nv.getTaikhoan()); v.add(nv.getMatkhau());
            tblData.add(v);
        }
        tblNV.setModel(new DefaultTableModel(tblData, tblTitle));
    }
    
    public void setenabled(){
        txtAnh.setEnabled(false);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
    }
    
    public String ngaysinh(){
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return df.format(txtNgaySinh.getDate());
    }
    
    public Boolean ktngaysinh(){
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        try {
            df.format(txtNgaySinh.getDate());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng kiểu dữ liệu dd-mm-yyyy cho ngày sinh", "Thông báo", 2);
            return false;
        }
        return true;
    }
    
    public String gioitinh(){
        if(rdNam.isSelected())
            return "Nam";
        else
            return "Nữ";
    }
    
    public Boolean kiemtraTXT(){
        if(txtMaNV.getText().equals("") || txtTenNV.getText().equals("") || txtDiaChi.getText().equals("") ||
                ngaysinh().equals("") || txtSDT.getText().equals("") || txtEmail.getText().equals("") ||
                txtAnh.getText().equals("") || txtTK.getText().equals("") || txtMK.getText().equals("") || txtXNMK.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin", "Thông báo", 2);
            return false;
        }
        return true;
    }
    
    public Boolean ktmanvhople(){
        String manv = txtMaNV.getText().trim();
        if(manv.length() <= 2){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng mã nhân viên là NVxxx với x là số", "Thông báo", 2);
            return false;
        }
        String dau = manv.substring(0,2);
        if(dau.equals("NV") == false){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng mã nhân viên là NVxxx với x là số", "Thông báo", 2);
            return false;
        }
        try {
            int duoi = Integer.parseInt(manv.substring(2));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng mã nhân viên là NVxxx với x là số", "Thông báo", 2);
            return false;
        }
        return true;
    }
    
    public Boolean ktmanvtrung(){
        if(NhanVienDAO.kiemtramatrung(dsnv, txtMaNV.getText().trim())){
            JOptionPane.showMessageDialog(this, "Đã trùng mã nhân viên, vui lòng nhập mã khác", "Thông báo", 2);
            return false;
        }
        return true;
    }
    
    public Boolean kttaikhoantrung(){
        if(NhanVienDAO.kiemtrataikhoantrung(dsnv, txtTK.getText().trim())){
            JOptionPane.showMessageDialog(this, "Đã trùng tài khoản, vui lòng nhập mã khác", "Thông báo", 2);
            return false;
        }
        return true;
    }
    
    public Boolean ktxacnhanmatkhau(){
        if(txtMK.getText().equals(txtXNMK.getText()) == false){
            JOptionPane.showMessageDialog(this, "Mật khẩu với xác nhận mật khảu không giống nhau, vui lòng nhập lại", "Thông báo", 2);
            return false;
        }
        return true;
    }
    
    public Boolean ktsuataikhoan(){
        if(NhanVienDAO.kiemtrasuataikhoankhac(dsnv, txtTK.getText().trim(), txtMaNV.getText().trim())){
            JOptionPane.showMessageDialog(this, "Đã trùng tài khoản nhân viên khác, vui lòng nhập tài khoản khác", "Thông báo", 2);
            return false;
        }
        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNV = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        lblHinhAnh = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTK = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMK = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtXNMK = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        txtAnh = new javax.swing.JTextField();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
        btnBrowser = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLamLoi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblNV.setModel(new javax.swing.table.DefaultTableModel(
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
        tblNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNV);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Ảnh đại diện");

        lblHinhAnh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Tài khoản: ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Mã nhân viên:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Tên nhân viên:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Ngày sinh:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Giới tính:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Mật khẩu:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Xác nhận mật khẩu:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Email");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Địa chỉ:");

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane2.setViewportView(txtDiaChi);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Ảnh:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Số điện thoại:");

        buttonGroup1.add(rdNam);
        rdNam.setSelected(true);
        rdNam.setText("Nam");

        buttonGroup1.add(rdNu);
        rdNu.setText("Nữ");

        txtNgaySinh.setDateFormatString("dd-MM-yyyy");

        btnBrowser.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnBrowser.setText("Browser");
        btnBrowser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowserActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLamLoi.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnLamLoi.setText("Làm mới");
        btnLamLoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamLoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(7, 7, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtXNMK, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTK, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(102, 102, 102)
                .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdNam)
                                .addGap(18, 18, 18)
                                .addComponent(rdNu))
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAnh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBrowser, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(568, 568, 568)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(375, 375, 375)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnLamLoi)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLamLoi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(txtXNMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(1, 1, 1))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rdNam)
                                        .addComponent(rdNu)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addGap(2, 2, 2)
                                .addComponent(btnBrowser, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 83, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowserActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        txtAnh.setText(filename);
        ImageIcon icon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lblHinhAnh.getWidth(), lblHinhAnh.getHeight(), Image.SCALE_SMOOTH));
        lblHinhAnh.setIcon(icon);
    }//GEN-LAST:event_btnBrowserActionPerformed
  
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if(ktngaysinh() && kiemtraTXT() && ktmanvhople() && ktmanvtrung() && kttaikhoantrung() && ktxacnhanmatkhau()){
            if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thêm không?", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                String sql = "set dateformat dmy insert into NhanVien values ('"+txtMaNV.getText().trim()+"', N'"+txtTenNV.getText().trim()+"', '"+ngaysinh()+"', N'"+gioitinh()+"', N'"+txtDiaChi.getText().trim()+"', '"+txtSDT.getText().trim()+"', '"+txtEmail.getText().trim()+"', '"+txtAnh.getText().trim()+"', '"+txtTK.getText().trim()+"', '"+txtMK.getText().trim()+"')";
                NhanVienDAO.ThemXoaSuaNhanVien(sql);
                NhanVien nv = new NhanVien(txtMaNV.getText().trim(), txtTenNV.getText().trim(), ngaysinh(), gioitinh(), txtDiaChi.getText().trim(), txtSDT.getText().trim(), txtEmail.getText().trim(), txtAnh.getText().trim(), txtTK.getText().trim(), txtMK.getText().trim());
                dsnv.add(nv);
                Vector v = new Vector();
                v.add(txtMaNV.getText().trim()); v.add(txtTenNV.getText().trim()); v.add(ngaysinh()); v.add(gioitinh());
                v.add(txtDiaChi.getText().trim()); v.add(txtSDT.getText().trim()); v.add(txtEmail.getText().trim());
                v.add(txtAnh.getText().trim()); v.add(txtTK.getText().trim()); v.add(txtMK.getText().trim());
                tblData.add(v);
                tblNV.setModel(new DefaultTableModel(tblData, tblTitle));
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNVMouseClicked
        int i = tblNV.getSelectedRow();
        String manv = tblNV.getValueAt(i, 0).toString().trim();
        String tennv = tblNV.getValueAt(i, 1).toString().trim();
        String ngaysinh = tblNV.getValueAt(i, 2).toString().trim();
        String gioitinh = tblNV.getValueAt(i, 3).toString().trim();
        String diachi = tblNV.getValueAt(i, 4).toString().trim();
        String sdt = tblNV.getValueAt(i, 5).toString().trim();
        String email = tblNV.getValueAt(i, 6).toString().trim();
        String anh = tblNV.getValueAt(i, 7).toString().trim();
        String taikhoan = tblNV.getValueAt(i, 8).toString().trim();
        String matkhau = tblNV.getValueAt(i, 9).toString().trim();
        String xacnhanmatkhau = tblNV.getValueAt(i, 9).toString().trim();
        txtMaNV.setText(manv);
        txtTenNV.setText(tennv);
        try {
            java.util.Date d = new SimpleDateFormat("dd-MM-yyyy").parse(ngaysinh);
            txtNgaySinh.setDate(d);
        } catch (Exception e) {
        }
        if(gioitinh.equals("Nam"))
            rdNam.setSelected(true);
        else
            rdNu.setSelected(true);
        txtDiaChi.setText(diachi);
        txtSDT.setText(sdt);
        txtEmail.setText(email);
        txtAnh.setText(anh);
        txtTK.setText(taikhoan);
        txtMK.setText(matkhau);
        txtXNMK.setText(xacnhanmatkhau);
        String filename = anh;
        ImageIcon icon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lblHinhAnh.getWidth(), lblHinhAnh.getHeight(), Image.SCALE_SMOOTH));
        lblHinhAnh.setIcon(icon);
        txtMaNV.setEnabled(false);
        btnThem.setEnabled(false);
        btnXoa.setEnabled(true);
        btnSua.setEnabled(true);
    }//GEN-LAST:event_tblNVMouseClicked

    private void btnLamLoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamLoiActionPerformed
        txtAnh.setText("");
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtMK.setText("");
        txtMaNV.setText("");
        txtNgaySinh.setDate(null);
        txtSDT.setText("");
        txtTK.setText("");
        txtTenNV.setText("");
        txtXNMK.setText("");
        btnThem.setEnabled(true);
        btnXoa.setEnabled(false);
        btnSua.setEnabled(false);
        tblNV.setModel(new DefaultTableModel(tblData, tblTitle));
        lblHinhAnh.setIcon(null);
        txtMaNV.setEnabled(true);
    }//GEN-LAST:event_btnLamLoiActionPerformed

    public Boolean kiemtramanv(int i){
        if(HoaDonDAO.KiemTraTonTaiMaNV(QuanLyBanHang.dshd, tblNV.getValueAt(i, 0).toString().trim())){
            JOptionPane.showMessageDialog(this, "Dữ liệu đang được sử dụng, không thể xóa", "Thông báo", 2);
            return false;
        }
        return true;
    }
    
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int i = tblNV.getSelectedRow();
        if(kiemtramanv(i)){
            if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa không?", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                String sql = "delete from nhanvien where manv = '"+txtMaNV.getText().trim()+"'";
                NhanVienDAO.ThemXoaSuaNhanVien(sql);
                NhanVienDAO.XoaNhanVien(dsnv, txtMaNV.getText().trim());         
                tblModel = (DefaultTableModel) tblNV.getModel();
                tblModel.removeRow(i);
            }   
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa không?", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            if(ktngaysinh() && kiemtraTXT() && ktsuataikhoan() && ktxacnhanmatkhau()){
                String manv = txtMaNV.getText().trim();
                String tennv = txtTenNV.getText().trim();             
                String diachi = txtDiaChi.getText().trim();
                String sdt = txtSDT.getText().trim();
                String email = txtEmail.getText().trim();
                String hinhanh = txtAnh.getText().trim();
                String taikhoan = txtTK.getText().trim();
                String matkhau = txtMK.getText().trim();
                String sql = "set dateformat dmy update nhanvien set tennv = N'"+tennv+"', ngaysinh = '"+ngaysinh()+"', gioitinh = N'"+gioitinh()+"', "
                    + "diachi = N'"+diachi+"', sdt = '"+sdt+"', email = '"+email+"', hinhanh = '"+hinhanh+"', taikhoan = '"+taikhoan+"', matkhau = '"+matkhau+"' "
                    + "where manv = '"+manv+"'";
                NhanVienDAO.ThemXoaSuaNhanVien(sql);
                NhanVienDAO.SuaNhanVien(dsnv, new NhanVien(manv, tennv, ngaysinh(), gioitinh(), diachi, sdt, email, hinhanh, taikhoan, matkhau));
                int i = tblNV.getSelectedRow();
                tblNV.setValueAt(tennv, i, 1);                           
                tblNV.setValueAt(ngaysinh(), i, 2);
                tblNV.setValueAt(gioitinh(), i, 3);
                tblNV.setValueAt(diachi, i, 4);
                tblNV.setValueAt(sdt, i, 5);
                tblNV.setValueAt(email, i, 6);
                tblNV.setValueAt(hinhanh, i, 7);
                tblNV.setValueAt(taikhoan, i, 8);
                tblNV.setValueAt(matkhau, i, 9);                                                                  
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
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowser;
    private javax.swing.JButton btnLamLoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTable tblNV;
    private javax.swing.JTextField txtAnh;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMK;
    private javax.swing.JTextField txtMaNV;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTK;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtXNMK;
    // End of variables declaration//GEN-END:variables
}
