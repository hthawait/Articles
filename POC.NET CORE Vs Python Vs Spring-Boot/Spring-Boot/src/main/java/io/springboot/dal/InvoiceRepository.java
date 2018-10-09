package io.springboot.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.springboot.models.InvoiceModel;

@Repository
public interface InvoiceRepository extends CrudRepository<InvoiceModel, Long> {
    
}