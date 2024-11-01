package com.example.sales.entities.saleitem;

import com.example.sales.entities.product.Product;
import com.example.sales.entities.sale.Sale;
import com.example.sales.entities.saleitem.pk.SaleItemPK;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.ReadOnlyProperty;

import java.util.Objects;

@Entity
@Table(name = "tb_sale_item")
public class SaleItem {
    @EmbeddedId
    private SaleItemPK id = new SaleItemPK();

    private Integer quantity;

    private Double subtotal;

    public SaleItem() {
    }

    public SaleItem(Product product, Sale sale, Integer quantity) {
        this.id.setProduct(product);
        this.id.setSale(sale);
        this.quantity = quantity;
    }

    public SaleItem(Product product, Sale sale, Integer quantity, Double subtotal) {
        this.id.setProduct(product);
        this.id.setSale(sale);
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    public Product getProduct(){
        return this.id.getProduct();
    }

    public void setProduct(Product product){
        this.id.setProduct(product);
    }

    public Sale getSale(){
        return this.id.getSale();
    }

    public void setSale(Sale sale){
        this.id.setSale(sale);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleItem saleItem = (SaleItem) o;
        return Objects.equals(id, saleItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
