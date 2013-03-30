/**
 * 
 */
package com.mnxfst.iservices.domain.product.model;

import java.io.Serializable;

/**
 * Available price types, eg. MSRP (manufacturer suggested retail price) or selling price
 * @author mnxfst
 *
 */
public enum ProductPriceType implements Serializable {

	MSRP, // manufacturer suggested retail price
	SELLING_PRICE, // current selling price
	OLD_SELLING_PRICE // former selling price	
	
}
