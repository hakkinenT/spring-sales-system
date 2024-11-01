package com.example.sales.entities.saleitem.dto;

import com.example.sales.entities.product.dto.ProductDTO;
import com.example.sales.entities.saleitem.SaleItem;

public class SaleItemDTO {
    private ProductDTO product;
    private Integer quantity;
    private Double subtotal;

    public SaleItemDTO() {
    }

    public SaleItemDTO(ProductDTO product, Integer quantity, Double subtotal) {
        this.product = product;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    public SaleItemDTO(SaleItem entity) {
        this.product = new ProductDTO(entity.getProduct());
        this.quantity = entity.getQuantity();
        this.subtotal = entity.getSubtotal();
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

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
}
