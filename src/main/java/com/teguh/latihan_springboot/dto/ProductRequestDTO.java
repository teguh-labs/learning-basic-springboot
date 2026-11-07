package com.teguh.latihan_springboot.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductRequestDTO {

    @NotBlank(message = "Nama produk tidak boleh kosong")
    @Size(min = 3, message = "Nama produk minimal harus 3 karakter")
    private String nama;

    @NotNull(message = "Harga tidak boleh kosong")
    @Min(value = 500, message = "Harga minimal Harus Rp 500")
    private int harga;
}
