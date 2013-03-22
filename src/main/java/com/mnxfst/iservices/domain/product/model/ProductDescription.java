/**
 * 
 */
package com.mnxfst.iservices.domain.product.model;

import java.io.Serializable;

/**
 * Holds the description of a {@link Product product} entities of this type are associated with.
 * @author mnxfst
 *
 */
public class ProductDescription implements Serializable {

	private static final long serialVersionUID = -8351363126532996926L;

	/** hold the text describing the product */ 
	private String value = null;
	
	/** holds the description type, e.g. long-description, short-description */
	private ProductDescriptionType type = null;
	
	/** holds the ISO code of the language the provided text is written in */
	private String language = null;
	
	/**
	 * Default constructor
	 */
	public ProductDescription() {		
	}
	
	/**
	 * Initializes the entity using the provided information
	 * @param type
	 * @param value
	 * @param language
	 */
	public ProductDescription(ProductDescriptionType type, String value, String language) {
		this.type = type;
		this.value = value;
		this.language = language;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ProductDescriptionType getType() {
		return type;
	}

	public void setType(ProductDescriptionType type) {
		this.type = type;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	
}
