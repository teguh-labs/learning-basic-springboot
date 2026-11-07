package com.teguh.latihan_springboot.dto;

import lombok.Data;

@Data
public class ProductResponseDTO {

    private Long id;
    private String nama;
    private int harga;
}
