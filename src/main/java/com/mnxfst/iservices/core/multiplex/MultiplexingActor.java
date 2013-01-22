/**
 * 
 */
package com.mnxfst.iservices.core.multiplex;

import akka.actor.UntypedActor;

/**
 * Provides the implementation of a very basic message multiplexing actor.
 * Incoming messages are forwarded to a defined set of actors independently
 * from their contents 
 * @author mnxfst
 *
 */
public class MultiplexingActor extends UntypedActor {

	/**
	 * @see akka.actor.UntypedActor#onReceive(java.lang.Object)
	 */
	public void onReceive(Object message) throws Exception {
		
		
		
	}

}
