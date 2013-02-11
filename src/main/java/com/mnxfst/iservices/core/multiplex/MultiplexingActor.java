/**
 * 
 */
package com.mnxfst.iservices.core.multiplex;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import com.mnxfst.iservices.core.messages.BaseMessage;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

/**
 * Provides the implementation of a very basic message multiplexing actor. Incoming messages are forwarded to a defined set 
 * of actors independently. If the multiplexing actor is configured such that there are no outbound actors, the messages
 * will be forwarded to {@link UntypedActor#unhandled(Object)} which also applies to messages which are not of type {@link BaseMessage} 
 * from their contents 
 * @author mnxfst
 *
 */
public class MultiplexingActor extends UntypedActor {

	/** holds the initial set of actor identifiers used to fetch outbound actor references on startup */ 
	private Set<String> outboundActorIdentifiers = new HashSet<String>();
	
	/** holds the actual list of references to actors receiving copies of the inbound message */ 
	private Set<ActorRef> outboundActorRefs = new HashSet<ActorRef>();
		
	/**
	 * Initializes the actor using the provided input
	 * @param outboundActorIdentifiers
	 */
	public MultiplexingActor(Set<String> outboundActorIdentifiers) {
		if(outboundActorIdentifiers != null && !outboundActorIdentifiers.isEmpty())
			this.outboundActorIdentifiers.addAll(outboundActorIdentifiers);
	}
		
	/**
	 * @see akka.actor.UntypedActor#preStart()
	 */
	public void preStart() {
		super.preStart();
		
		// make sure the ref set is empty
		this.outboundActorRefs.clear();
		
		// step through identifiers, fetch referenced actor and add it to actor ref set
		for(String outboundActorId : this.outboundActorIdentifiers) {
			getContext().actorFor(outboundActorId.trim());			
		}
	}


	/**
	 * @see akka.actor.UntypedActor#onReceive(java.lang.Object)
	 */
	public void onReceive(Object message) throws Exception {
		
		if(message instanceof BaseMessage && !outboundActorRefs.isEmpty()) {
			
			for(ActorRef oaRef : outboundActorRefs) {
				oaRef.tell(message, getSelf());
			}
			
		} else {
			unhandled(message);
		}
		
		
	}

}
