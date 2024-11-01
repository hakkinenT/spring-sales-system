package com.example.sales.entities.sale.dto;

import com.example.sales.entities.sale.Sale;
import com.example.sales.entities.saleitem.dto.SaleItemDTO;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class SaleDTO {
    private Long id;
    private Instant moment;
    private Double total;
    private List<SaleItemDTO> items = new ArrayList<>();

    public SaleDTO() {
    }

    public SaleDTO(Long id, Instant moment, Double total) {
        this.id = id;
        this.moment = moment;
        this.total = total;
    }

    public SaleDTO(Sale entity) {
        this.id = entity.getId();
        this.moment = entity.getMoment();
        this.total = entity.getTotal();
        this.items = entity.getSaleItems().stream().map(SaleItemDTO::new).toList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<SaleItemDTO> getItems() {
        return items;
    }

    public void setItems(List<SaleItemDTO> items) {
        this.items = items;
    }
}
