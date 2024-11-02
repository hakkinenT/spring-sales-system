package com.example.sales.services;

import com.example.sales.entities.product.Product;
import com.example.sales.entities.sale.Sale;
import com.example.sales.entities.sale.dto.SaleDTO;
import com.example.sales.entities.sale.dto.SaleMinDTO;
import com.example.sales.entities.saleitem.SaleItem;
import com.example.sales.entities.saleitem.dto.SaleItemMinDTO;
import com.example.sales.repositories.ProductRepository;
import com.example.sales.repositories.SaleItemRepository;
import com.example.sales.repositories.SaleRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleItemRepository saleItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public SaleDTO insert(SaleMinDTO dto){
        Sale sale = new Sale();
        sale.setMoment(Instant.now());
        sale = saleRepository.save(sale); //Mantêm o mesmo comportamento com saveAndFlush()
        
        for (SaleItemMinDTO item : dto.getItems()){
            Product product = productRepository.getReferenceById(item.getProduct().getId());
            SaleItem saleItem = new SaleItem(product, sale, item.getQuantity());
            saleItem = saleItemRepository.saveAndFlush(saleItem);

            sale.getSaleItems().add(saleItem);
        }

        entityManager.refresh(sale);

        return new SaleDTO(sale);
    }

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable){
        Page<Sale> sales = saleRepository.findAll(pageable);
        return sales.map(SaleDTO::new);
    }
}
