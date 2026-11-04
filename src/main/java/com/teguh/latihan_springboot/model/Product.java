package com.teguh.latihan_springboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_produk") //nama tabel di mysql
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment ID
    private Long id;

    @NotBlank(message = "Nama produk tidak boleh kosong!")
    @Size(min = 3, message = "Nama Produk minimal harus 3 karakter!")
    private String nama;

    @NotNull(message = "Harga tidak boleh 0!")
    @Min(value = 500, message = "Harga minimal harus Rp 500!")
    private int harga;
}
