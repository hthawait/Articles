package io.springboot.service;

import io.springboot.models.InvoiceModel;
import io.springboot.dal.InvoiceRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class InvoiceService {

	// private static final Logger logger =
	// LoggerFactory.getLogger(InvoiceService.class);

	@Autowired
	InvoiceRepository invoiceRepository;

	public List<InvoiceModel> findAllInvoices() {
		return (List<InvoiceModel>) this.invoiceRepository.findAll();
	}


	public boolean addInvoices(InvoiceModel invoice) {
		this.invoiceRepository.save(invoice);
		return true;
	}


	public boolean deleteInvoices(Long invoice_id) {
		this.invoiceRepository.deleteById(invoice_id);
		return true;
	}

}