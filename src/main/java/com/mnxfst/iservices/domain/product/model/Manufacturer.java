/**
 * 
 */
package com.mnxfst.iservices.domain.product.model;

import java.io.Serializable;

/**
 * Holds additional information about the manufacturer of a {@link Product product}
 * @author mnxfst
 * @since 26.03.2013
 */
public class Manufacturer implements Serializable {

	private static final long serialVersionUID = -7659696993721668493L;
	
	/** manufacturers company name */
	private String name = null;
	
	// TODO add more: address, contact information, email, website ...
	
	public Manufacturer() {		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
