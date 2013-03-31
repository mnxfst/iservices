/**
 * 
 */
package com.mnxfst.iservices.domain.product.model;

import java.io.Serializable;

/**
 * Shipment information
 * @author mnxfst
 *
 */
public class ProductShipping implements Serializable {

	private static final long serialVersionUID = -714659580757062545L;

	/** references the country this shipping information is dedicated to, the value is an ISO3166 encoded string */
	private String country = null;
	
	/** additional regional information */
	private String region = null;
	
	/** service type, e.g. EXPRESS or STANDARD */
	private String service = null;
	
	/** price charged for shipping the product */
	private Double price = null;
	
	public ProductShipping() {		
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}
