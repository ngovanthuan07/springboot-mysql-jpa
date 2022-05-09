package com.example.springmysql.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class NhanKhau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maNhanKhau;

    @NotNull
    @Size(min= 1, max = 50)
    private String hoVaTen;

    @NotNull
    @Size(min= 1, max = 50)
    private String tenGoiKhac;

    @NotNull
    private int gioiTinh;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaySinh;

    @NotNull
    private String queQuan;

    @NotNull
    @Size(max = 50)
    private String danToc;

    @NotNull
    @Size(max = 50)
    private String trinhDoVanHoa;

    @NotNull
    @Size(max = 50)
    private String ngheNghiep;

    @NotNull
    @Size(max = 50)
    private String cmnd;

    @NotNull
    private int trangThai;

    @Size(max = 50)
    private String tinhTrang;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayCapNhat;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nhanKhau", fetch = FetchType.LAZY)
    private Collection<NhanKhauThuongTru> nhanKhauThuongTrus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nhanKhau", fetch = FetchType.LAZY)
    private Collection<NhanKhauTamTru> nhanKhauTamTrus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nhanKhau", fetch = FetchType.LAZY)
    private Collection<NhanKhauKhaiSinh> nhanKhauKhaiSinhs;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nhanKhau", fetch = FetchType.LAZY)
    private Collection<NhanKhauDaChet> nhanKhauDaChets;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ma_nguoi_dung", referencedColumnName = "maNguoiDung")
    private NguoiDung nguoiDung;

}
