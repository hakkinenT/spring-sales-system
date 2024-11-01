package com.example.sales.entities.saleitem.dto;

import com.example.sales.entities.product.dto.ProductDTO;
import com.example.sales.entities.saleitem.SaleItem;

public class SaleItemMinDTO {
    private ProductDTO product;
    private Integer quantity;

    public SaleItemMinDTO() {
    }

    public SaleItemMinDTO(ProductDTO product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public SaleItemMinDTO(SaleItem entity) {
        this.product = new ProductDTO(entity.getProduct());
        this.quantity = entity.getQuantity();
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
