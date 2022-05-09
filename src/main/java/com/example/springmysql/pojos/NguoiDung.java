package com.example.springmysql.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class NguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maNguoiDung;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String email;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ma_vai_tro", referencedColumnName = "maVaiTro")
    private VaiTro vaiTro;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoiDung", fetch = FetchType.LAZY)
    private Collection<NhanKhau> nhanKhaus;

}
