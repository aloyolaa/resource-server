package com.aloyolaa.resourceserver.controller;

import com.aloyolaa.resourceserver.dto.InvoiceDetailDto;
import com.aloyolaa.resourceserver.dto.InvoiceDto;
import com.aloyolaa.resourceserver.repository.InvoiceRepository;
import com.aloyolaa.resourceserver.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/invoices")
public class InvoiceController {
    private final InvoiceService invoiceService;
    private final InvoiceRepository invoiceRepository;

    @GetMapping("/")
    public ResponseEntity<List<InvoiceDetailDto>> getAll() {
        return new ResponseEntity<>(invoiceService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDetailDto> getOne(@PathVariable Long id) {
        return new ResponseEntity<>(invoiceService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<InvoiceDetailDto> save(@RequestBody InvoiceDto invoiceDto) {
        return new ResponseEntity<>(invoiceService.save(invoiceDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<InvoiceDetailDto> update(@RequestBody InvoiceDto invoiceDto) {
        return new ResponseEntity<>(invoiceService.update(invoiceDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return new ResponseEntity<>(invoiceService.delete(id), HttpStatus.OK);
    }
}
