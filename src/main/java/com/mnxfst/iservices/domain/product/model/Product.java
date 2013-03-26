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
	
	///////////////////////////////////////////////////////////////////////////////////
	// identifiers required for product lookups
	
	/** unique identifier required by mongo database to reference the entity */
	private ObjectId id = null;
	
	/** unique product identifier used to reference the product within the marketplace space */  
	private String productId = null;

	/** information about the source the product originates from */
	private ProductSource source = null;
	///////////////////////////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////////////////////////////
	// unit, order quantities 
	
	/** minimum order quantity */
	private Integer minOrderQuantity = null;
	
	/** maximum order quantity */
	private Integer maxOrderQuantity = null;
	
	/** unit the quantity is expressed in */
	private QuantityUnit quantityUnit = null;
	///////////////////////////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////////////////////////////
	// product description, additional product information
	
	/** holds textual information describing the product */
	private List<ProductDescription> descriptions = new ArrayList();
	
	/** holds a list of tags describing the product with a single or two-word expression; used for searching etc. */
	private List<String> tags = new ArrayList<>();
	
	/** information about the product manufacturer */
	private Manufacturer manufacturer = null;	
	////////////////////////////////////////////////////////////////////////////////////
	
	///////////////////////////////////////////////////////////////////////////////////
	// pricing details
	
	/** names all available prices - when ordering a product, the caller must provide a reference to the selected price */
	private List<ProductPrice> prices = new ArrayList<>();
	
	
	
	///////////////////////////////////////////////////////////////////////////////////

}
