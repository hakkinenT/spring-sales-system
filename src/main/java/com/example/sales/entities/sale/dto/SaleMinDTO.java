package com.example.sales.entities.sale.dto;

import com.example.sales.entities.saleitem.dto.SaleItemMinDTO;

import java.util.ArrayList;
import java.util.List;

public class SaleMinDTO {
    private List<SaleItemMinDTO> items = new ArrayList<>();

    public SaleMinDTO() {
    }

    public SaleMinDTO(List<SaleItemMinDTO> items) {
        this.items = items;
    }

    public List<SaleItemMinDTO> getItems() {
        return items;
    }

    public void setItems(List<SaleItemMinDTO> items) {
        this.items = items;
    }
}
