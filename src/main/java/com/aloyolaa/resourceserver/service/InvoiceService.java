package com.aloyolaa.resourceserver.service;

import com.aloyolaa.resourceserver.dto.InvoiceDetailDto;
import com.aloyolaa.resourceserver.dto.InvoiceDto;

import java.util.List;

public interface InvoiceService {
    List<InvoiceDetailDto> findAll();

    InvoiceDetailDto findById(Long id);

    InvoiceDetailDto save(InvoiceDto invoiceDto);

    InvoiceDetailDto update(InvoiceDto invoiceDto);

    Boolean delete(Long id);
}
