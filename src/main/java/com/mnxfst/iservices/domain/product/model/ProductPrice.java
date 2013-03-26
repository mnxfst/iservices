/**
 * 
 */
package com.mnxfst.iservices.domain.product.model;

import java.io.Serializable;

/**
 * Pricing details
 * @author mnxfst
 *
 */
public class ProductPrice implements Serializable {

	private static final long serialVersionUID = -5436842081162545243L;
	
	/** names the type of the current price, eg. MSRP */
	private String type = null; // TODO enum instead?
	
	/** price */
	private Double value = null;
	
	/** currency the price is expressed in */
	private String currency = null;
	
	/** additional tax to be added provided as total value */
	private Double tax = null; 
	
	/** value added tax to be added provided as percentage */
	private Double vat = null;
	
	public ProductPrice() {		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getVat() {
		return vat;
	}

	public void setVat(Double vat) {
		this.vat = vat;
	}
	
	

	
	
}
