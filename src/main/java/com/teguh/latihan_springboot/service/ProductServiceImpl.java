package com.teguh.latihan_springboot.service;

import com.teguh.latihan_springboot.dto.ProductRequestDTO;
import com.teguh.latihan_springboot.dto.ProductResponseDTO;
import com.teguh.latihan_springboot.model.Product;
import com.teguh.latihan_springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repo;

    // Helper method manual (Konversi Entity ke ResponseDTO)
    private ProductResponseDTO convertToResponseDTO(Product product){

        ProductResponseDTO dto = new ProductResponseDTO();

        dto.setId(product.getId());
        dto.setNama(product.getNama());
        dto.setHarga(product.getHarga());

        return dto;
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = repo.findAll();
        List<ProductResponseDTO> responseList = new ArrayList<>();

        for(Product product : products){
            ProductResponseDTO dto = convertToResponseDTO(product);
            responseList.add(dto);
        }

        return responseList;
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        Product product = repo.findById(id).orElse(null);

        if(product != null){
            return convertToResponseDTO(product);
        }

        return null;
    }

    @Override
    public Map<String, Object> addProduct(ProductRequestDTO requestDTO) {
        //Mapping RequestDTO -> Entity
        Product product = new Product();
        product.setNama(requestDTO.getNama());
        product.setHarga(requestDTO.getHarga());

        Product savedProduct = repo.save(product);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "produk berhasil disimpan");
        response.put("data", convertToResponseDTO(savedProduct));

        return response;
    }

    @Override
    public Map<String, Object> updateProduct(Long id, ProductRequestDTO requestDTO) {
        Product existProduct = repo.findById(id). orElse(null);
        Map<String, Object> response = new LinkedHashMap<>();

        if(existProduct != null){
            existProduct.setNama(requestDTO.getNama());
            existProduct.setHarga(requestDTO.getHarga());

            Product updatedProduct = repo.save(existProduct);

            response.put("message", "Produk berhasil diubah!");
            response.put("data", convertToResponseDTO(updatedProduct));
        } else {
            response.put("message", "Produk dengan ID " + id + " tidak ditemukan!");
        }

        return response;
    }

    @Override
    public Map<String, Object> deleteProduct(Long id) {
        Product findProduct = repo.findById(id).orElse(null);
        Map<String, Object> response = new LinkedHashMap<>();

        if (findProduct != null){
            repo.delete(findProduct);
            response.put("message", "Produk ID " + id + " berhasil dihapus!");
        } else {
            response.put("message", "Produk dengan ID " + id + " tidak ditemukan!");
        }

        return response;
    }

}
