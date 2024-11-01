package com.example.sales.repositories;

import com.example.sales.entities.saleitem.SaleItem;
import com.example.sales.entities.saleitem.pk.SaleItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleItemRepository extends JpaRepository<SaleItem, SaleItemPK> {
}
