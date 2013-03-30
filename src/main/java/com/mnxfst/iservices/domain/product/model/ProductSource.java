/**
 * 
 */
package com.mnxfst.iservices.domain.product.model;

import java.io.Serializable;

/**
 * Holds information about the source of a {@link Product product} entity. It contains
 * a reference to the owner as well as the identifier used by the owner to reference
 * the product in his space. Instances of this object must be associated directly with
 * a {@link Product product} instance. 
 * @author mnxfst
 * 
 */
public class ProductSource implements Serializable {

	private static final long serialVersionUID = 129393839101586403L;
	
	/** holds the reference towards the product owner and can be used in the owner domain to lookup the party */ 
	private String supplierId = null;
	
	/** holds the identifier used by the owner to reference the product */
	private String productId = null;
	
	public ProductSource() {		
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

}
