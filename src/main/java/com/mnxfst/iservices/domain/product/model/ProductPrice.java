/**
 * 
 */
package com.mnxfst.iservices.domain.product.model;

import java.io.Serializable;

import org.bson.types.ObjectId;

/**
 * Pricing details
 * @author mnxfst
 *
 */
public class ProductPrice implements Serializable {

	private static final long serialVersionUID = -5436842081162545243L;
	
	///////////////////////////////////////////////////////////////////////////////////
	// identifiers required for product lookups
	
	/** unique identifier required by mongo database to reference the entity */
	private ObjectId id = null;
	
	/** unique identifier used to reference the product this price is associated with */  
	private String productId = null;
	
	/** unique identifier used to reference the platform this price is defined for */ 
	private String vendorId = null;
	
	///////////////////////////////////////////////////////////////////////////////////
	
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public ProductPriceType getType() {
		return type;
	}

	public void setType(ProductPriceType type) {
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

	/** names the type of the current price, eg. MSRP */
	private ProductPriceType type = null; 
	
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

	
	
}
