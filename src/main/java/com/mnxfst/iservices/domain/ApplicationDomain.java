/**
 * 
 */
package com.mnxfst.iservices.domain;

import java.io.Serializable;

/**
 * Names all domains currently supported by the application. This information
 * is required by the {@link BaseMessage base message}
 * @author mnxfst
 *
 */
public enum ApplicationDomain implements Serializable {

	ORDER, CUSTOMER, PRODUCT, PAYMENT, STATISTICS, ARCHIVE, LOGGING, UNKNOWN
	
}
