package io.springboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import  io.springboot.models.InvoiceModel;
import  io.springboot.service.InvoiceService;

@CrossOrigin
@RestController
@RequestMapping("/invoice")
public class InvoiceController {

	private InvoiceService invescoService;

	@Autowired
	public InvoiceController(InvoiceService invescoService) {
		super();
		this.invescoService = invescoService;
	}

	@GetMapping("/all")
	public List<InvoiceModel> findAllInvoices() {
		return invescoService.findAllInvoices();
	}


	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public boolean saveInvoice() {
		  InvoiceModel invoice = new InvoiceModel();
		 // invoice.setRecordID(1);
		  invoice.setAmount(100.0);
		  invoice.setInvoiceDescription("invoice_From Spring-Boot");
		  invoice.setInvoiceNumber("101");
		  invoice.setVendorName("vendor_name");
       
		
		return invescoService.addInvoices(invoice);
	}


	@RequestMapping(value = "/delete/{invoice_id}", method = RequestMethod.DELETE)
	public boolean deleteSecurity(@PathVariable("invoice_id") Long invoice_id) {
		return invescoService.deleteInvoices(invoice_id);
	}
}
