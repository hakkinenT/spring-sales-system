package com.example.sales.repositories;

import com.example.sales.entities.sale.Sale;
import com.example.sales.repositories.custom.JpaRefreshRepository;

public interface SaleRepository extends JpaRefreshRepository<Sale, Long> {
}
