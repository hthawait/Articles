package io.springboot.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "invoice")
public class InvoiceModel  implements Serializable{
	
	private static final long serialVersionUID = -3223451991002372807L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long record_id;

	private String invoice_number;

	private Double amount;

	private String invoice_description;

	private String vendor_name;
	
	public Long getRecordID() {
		return record_id;
	}

	public void setRecordID(Long i) {
		this.record_id = i;
	}

	public String getInvoiceNumber() {
		return invoice_number;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoice_number = invoiceNumber;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public String getInvoiceDescription() {
		return invoice_description;
	}

	public void setInvoiceDescription(String invoiceDescription) {
		this.invoice_description = invoiceDescription;
	}


	public String getVendorName() {
		return vendor_name;
	}

	public void setVendorName(String vendorName) {
		this.vendor_name = vendorName;
	}

}
