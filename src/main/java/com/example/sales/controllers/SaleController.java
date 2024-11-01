package com.example.sales.controllers;

import com.example.sales.entities.sale.dto.SaleDTO;
import com.example.sales.entities.sale.dto.SaleMinDTO;
import com.example.sales.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
    @Autowired
    private SaleService saleService;

    @PostMapping
    public ResponseEntity<SaleDTO> insert(@RequestBody SaleMinDTO dto){
        SaleDTO sdto = saleService.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sdto.getId()).toUri();
        return ResponseEntity.created(uri).body(sdto);
    }
}
