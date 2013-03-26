/**
 * 
 */
package com.mnxfst.iservices.domain.product.model;

import java.io.Serializable;

/**
 * Names the allowed units being used to express the quantity of a {@link Product product}.
 * The named values are selected according to EANCOM spec.
 * @author mnxfst
 *
 */
public enum QuantityUnit implements Serializable {
	
	KGM, // kilogram 
	MTK, // square meters
	LTR, // litre
	PCE, // piece
	PR, // PAIR
	TNE // metric ton (1000kg)
	
}
