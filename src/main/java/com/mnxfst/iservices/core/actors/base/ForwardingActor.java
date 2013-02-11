/**
 * 
 */
package com.mnxfst.iservices.core.actors.base;

import org.apache.commons.lang.StringUtils;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

import com.mnxfst.iservices.core.messages.BaseMessage;

/**
 * Provides the implementation of a message forwarding actor. It receives incoming messages
 * and forwards them to a defined actor. In case the message is not of the expected {@link BaseMessage}
 * type or the outbound actor has not been defined/found, it will be directed to {@link UntypedActor#unhandled(Object)}
 * @author mnxfst
 * @since 31.01.2013
 */
public class ForwardingActor extends UntypedActor {

	/** path to outbound actor */
	private String outboundActorPath = null;
	
	/** references the actor receiving incoming messages */
	protected ActorRef outboundActorRef = null;
	
	/**
	 * Initializes the actor using the provided input
	 * @param outboundActorPath
	 */
	public ForwardingActor(String outboundActorPath) {
		this.outboundActorPath = outboundActorPath;
	}
		
	/**
	 * @see akka.actor.UntypedActor#preStart()
	 */
	public void preStart() {
		super.preStart();	
		if(StringUtils.isNotBlank(this.outboundActorPath))
			outboundActorRef = getContext().actorFor(this.outboundActorPath);
	}


	/**
	 * @see akka.actor.UntypedActor#onReceive(java.lang.Object)
	 */	
	public void onReceive(Object message) throws Exception {
		
		if(message instanceof BaseMessage) {
			if(this.outboundActorRef != null)
				this.outboundActorRef.tell(message, getSelf());
		} else {
			unhandled(message);
		}
		
	}

}
