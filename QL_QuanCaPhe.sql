create database QL_QuanCaPhe
go
use QL_QuanCaPhe
go
set dateformat dmy
create table LoaiSanPham
(
	MaLSP char(10) primary key not null,
	TenLSP nvarchar(50),
)

create table SanPham
(
	MaSP char(10) primary key not null,
	TenSP nvarchar(50),
	GiaTien bigint,
	DVT nvarchar(20),
	MaLSP char(10),
	constraint fk_sp_lsp foreign key (MaLSP) references LoaiSanPham(MaLSP)
)

create table Ban
(
	MaBan char(10) primary key not null,
	TenBan nvarchar(50),
	TrangThai nvarchar(50) default N'Còn trống',
)

create table NhanVien
(
	MaNV char(10) primary key not null,
	TenNV nvarchar(50),
	NgaySinh date,
	GioiTinh nvarchar(10),
	DiaChi nvarchar(100),
	SDT char(11),
	Email char(100),
	HinhAnh char(100),
	TaiKhoan char(100),
	MatKhau char(100),
)

create table HoaDon
(
	MaHD char(10) primary key not null,
	MaNV char(10) not null,
	MaBan char(10) not null,
	NgayLapHD date not null,
	TongTien bigint,
	TinhTrang nvarchar(50) default N'Chưa thanh toán',
	constraint fk_hd_nv foreign key (MaNV) references NhanVien(MaNV),
	constraint fk_hd_maban foreign key (MaBan) references Ban(MaBan),
)

create table ChiTietHoaDon
(
	MaHD char(10) not null,
	MaSP char(10) not null,
	SoLuong int,
	GiamGia int,
	ThanhTien bigint,
	primary key(MaHD, MaSP),
	constraint fk_cthd_hd foreign key (MaHD) references HoaDon(MaHD),
	constraint fk_cthd_sp foreign key (MaSP) references SanPham(MaSP),
)

insert into LoaiSanPham(MaLSP, TenLSP) values ('LSP001', N'Cà phê')
insert into LoaiSanPham(MaLSP, TenLSP) values ('LSP002', N'Nước trái cây')
insert into LoaiSanPham(MaLSP, TenLSP) values ('LSP003', N'Nước ngọt')
insert into LoaiSanPham(MaLSP, TenLSP) values ('LSP004', N'Nước khoáng')

insert into SanPham(MaSP, TenSP, GiaTien, DVT, MaLSP) values ('SP001', N'Cà phê đá', 20000, N'Ly', 'LSP001')
insert into SanPham(MaSP, TenSP, GiaTien, DVT, MaLSP) values ('SP002', N'Cà phê sữa', 25000, N'Ly', 'LSP001')
insert into SanPham(MaSP, TenSP, GiaTien, DVT, MaLSP) values ('SP003', N'Nước cam', 15000, N'Ly', 'LSP002')
insert into SanPham(MaSP, TenSP, GiaTien, DVT, MaLSP) values ('SP004', N'Sting', 10000, N'Lon', 'LSP003')
insert into SanPham(MaSP, TenSP, GiaTien, DVT, MaLSP) values ('SP005', N'Aquafina', 7000, N'Chai', 'LSP004')

insert into Ban(MaBan, TenBan, TrangThai) values ('B001', N'Bàn 1', default)
insert into Ban(MaBan, TenBan, TrangThai) values ('B002', N'Bàn 2', default)
insert into Ban(MaBan, TenBan, TrangThai) values ('B003', N'Bàn 3', default)
insert into Ban(MaBan, TenBan, TrangThai) values ('B004', N'Bàn 4', default)
insert into Ban(MaBan, TenBan, TrangThai) values ('B005', N'Bàn 5', default)

insert into NhanVien(MaNV, TenNV, NgaySinh, GioiTinh, DiaChi, SDT, Email, HinhAnh, TaiKhoan, MatKhau) 
values ('NV001', N'Nguyễn Lê Huỳnh', '24-04-1999', N'Nam', N'Hồ Chí Minh', '0123465789', 'huynh@gmail.com', null, 'nguyenhuynh', 'nguyenhuynh')
insert into NhanVien(MaNV, TenNV, NgaySinh, GioiTinh, DiaChi, SDT, Email, HinhAnh, TaiKhoan, MatKhau) 
values ('NV002', N'Nguyễn Hải Nam', '13-03-1997', N'Nam', N'Hồ Chí Minh', '0987654321', 'nam@gmail.com', null, 'nguyennam', 'nguyennam')
insert into NhanVien(MaNV, TenNV, NgaySinh, GioiTinh, DiaChi, SDT, Email, HinhAnh, TaiKhoan, MatKhau) 
values ('NV003', N'Trần Trung Đại', '04-02-2000', N'Nam', N'Hồ Chí Minh', '0436823862', 'dai@gmail.com', null, 'trandai', 'trandai')

go

create procedure tongtien_hoadon @mahd char(10)
as
	update hoadon
	set tongtien = (select sum(thanhtien) from chitiethoadon where chitiethoadon.mahd = hoadon.mahd)
	where mahd = @mahd
go

create procedure doiban @mahd char(10), @maban char(10), @mabancandoi char(10)
as
	update hoadon
	set maban = @mabancandoi
	where mahd = @mahd

	update ban
	set TrangThai = N'Còn trống'
	where maban = @maban

	update ban
	set trangthai = N'Đang phục vụ'
	where maban = @mabancandoi
go