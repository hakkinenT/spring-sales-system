package com.example.sales.repositories;

import com.example.sales.entities.saleitem.SaleItem;
import com.example.sales.entities.saleitem.pk.SaleItemPK;
import com.example.sales.repositories.custom.JpaRefreshRepository;

public interface SaleItemRepository extends JpaRefreshRepository<SaleItem, SaleItemPK> {
}
