package com.teguh.latihan_springboot.controller;

import com.teguh.latihan_springboot.model.Product;
import com.teguh.latihan_springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HelloController {

    @Autowired
    private ProductRepository productRepository; // Inject interface repository JPA

    //1. GET ALL PRODUK DARI DATABASE
    @GetMapping("/produk")
    public List<Product> getAllProduct(){
        //SELECT * FROM tb_produk;
        return productRepository.findAll();
    }

    //2. CARI PRODUK BERDASARKAN ID
    @GetMapping("/produk/{id}")
    public Product getProductById(@PathVariable Long id){
        // SELECT * FROM tb_produk
        // WHERE id = {id};
        return productRepository.findById(id).orElse(null);
    }

    //3. SIMPAN PRODUK BARU KE DATABASE
    @PostMapping("/produk")
    public Map<String, Object> tambahProduk(@RequestBody Product product){

        // INSERT INTO tb_produk(nama, harga)
        Product produkTersimpan = productRepository.save(product);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Produk berhasil disimpan ke MySQL!");
        response.put("data_produk", produkTersimpan);

        return response;
    }

    //4. UPDATE PRODUK YANG SUDAH ADA
    @PutMapping("/produk/{id}")
    public Map<String, Object> updateProduk(@PathVariable Long id, @RequestBody Product detailProduct){
        Product existProduct = productRepository.findById(id).orElse(null);

        Map<String, Object> response = new HashMap<>();

        if(existProduct != null){
            existProduct.setNama(detailProduct.getNama());
            existProduct.setHarga(detailProduct.getHarga());

            /*
                UPDATE tb_product
                SET nama = ' '
                    harga = ' '
                WHERE id = {id};
             */
            Product updatedProduct = productRepository.save(existProduct);

            response.put("message", "Produk berhasil di-update!");
            response.put("data", updatedProduct);
        } else {
            response.put("message", "Produk dengan ID = " + id + " tidak ditemukan");
        }

        return response;
    }

    //5. HAPUS PRODUK DENGAN ID
    @DeleteMapping("/produk/{id}")
    public Map<String, Object> deleteProduct(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();

        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
            response.put("message", "Produk dengan ID = " + id + " Berhasil dihapus!");
        } else {
            response.put("message", "Produk tidak ditemukan!");
        }

        return response;
    }

}
