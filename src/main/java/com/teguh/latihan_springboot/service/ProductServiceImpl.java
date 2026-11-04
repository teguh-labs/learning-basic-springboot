package com.teguh.latihan_springboot.service;

import com.teguh.latihan_springboot.model.Product;
import com.teguh.latihan_springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repo;

    @Override
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Map<String, Object> addProduct(Product product) {
        Product newProduct = repo.save(product);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Data berhasil disimpan ke database");
        response.put("data", newProduct);

        return response;
    }

    @Override
    public Map<String, Object> updateProduct(Long id, Product detailProduct) {
        Product existProduct = repo.findById(id). orElse(null);
        Map<String, Object> response = new HashMap<>();

        if(existProduct != null){
            existProduct.setNama(detailProduct.getNama());
            existProduct.setHarga(detailProduct.getHarga());

            Product updatedProduct = repo.save(existProduct);

            response.put("message", "Produk berhasil diubah!");
            response.put("data", updatedProduct);
        } else {
            response.put("message", "Produk dengan ID " + id + " tidak ditemukan!");
        }

        return response;
    }

    @Override
    public Map<String, Object> deleteProduct(Long id) {
        Product existProduct = repo.findById(id).orElse(null);
        Map<String, Object> response = new HashMap<>();

        if (existProduct != null){
            repo.deleteById(id);
            response.put("message", "Produk ID " + id + " berhasil dihapus!");
        } else {
            response.put("message", "Produk dengan ID " + id + " tidak ditemukan!");
        }

        return response;
    }

}
