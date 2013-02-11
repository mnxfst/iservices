package com.mnxfst.iservices.core.messages;

import java.io.Serializable;

/**
 * Defines the core type of a message being passed around on the platform.
 * All implemented actors must be able to react at least on this type.
 * @author mnxfst
 * @since 31.01.2013
 * @param <E> identifies the payload type 
 */
public class BaseMessage<E extends Serializable> implements Serializable {

	private static final long serialVersionUID = 7166485095606780451L;

	/** unique key required to identify the message at any time */
	private String messageId = null;
	
	/** holds the creation time */
	private long creationTimestamp = 0;
	
	/** names the actor which has initially created/seen this message */
	private String initialActorRef = null;
	
	/** message payload */
	private E payload = null;
	
	/**
	 * Default constructor
	 */
	public BaseMessage() {		
	}
	
	/**
	 * Initializes the message using the provided information
	 * @param messageId
	 * @param creationTimestamp
	 * @param initialActorRef
	 * @param payload
	 */
	public BaseMessage(String messageId, long creationTimestamp, String initialActorRef, E payload) {
		this.messageId = messageId;
		this.creationTimestamp = creationTimestamp;
		this.initialActorRef = initialActorRef;
		this.payload = payload;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public long getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(long creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	public String getInitialActorRef() {
		return initialActorRef;
	}

	public void setInitialActorRef(String initialActorRef) {
		this.initialActorRef = initialActorRef;
	}

	public E getPayload() {
		return payload;
	}

	public void setPayload(E payload) {
		this.payload = payload;
	}
	
	
}
