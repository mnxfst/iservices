/**
 * 
 */
package com.mnxfst.iservices.domain.product.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

/**
 * Describes a product entity 
 * @author mnxfst
 *
 */ 
public class Product implements Serializable {

	private static final long serialVersionUID = -1086862291264948153L;
	
	/** unique identifier required by mongo database to reference the entity */
	private ObjectId id = null;
	
	/** unique product identifier used to reference the product within the marketplace space */  
	private String productId = null;

	/** information about the source the product originates from */
	private ProductSource source = null;
	
	/** minimum order quantity */
	private Integer minOrderQuantity = null;
	
	/** maximum order quantity */
	private Integer maxOrderQuantity = null;
	
	/** holds textual information describing the product */
	private List<ProductDescription> descriptions = new ArrayList<ProductDescription>();
			
	
	
}
