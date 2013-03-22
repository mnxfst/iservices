package com.mnxfst.iservices.domain;

import java.io.Serializable;

/**
 * Defines the common base which must be used as parent by all messages being passed
 * around in the application. It contains the most common information required by the
 * service components in order to forward it to the right consumer 
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
	
	/** holds the domain the message is associated with */
	private ApplicationDomain applicationDomain = ApplicationDomain.UNKNOWN;
	
	/** names the domain service the message must be forwarded to */
	private String applicationDomainService = null;
	
	/** references the initiating party */
	private String apiKey = null;
	
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
	public BaseMessage(String messageId, long creationTimestamp, String initialActorRef, ApplicationDomain applicationDomain, String applicationDomainService, String apiKey) {
		this.messageId = messageId;
		this.creationTimestamp = creationTimestamp;
		this.initialActorRef = initialActorRef;
		this.apiKey = apiKey;
		this.applicationDomain = applicationDomain;
		this.applicationDomainService = applicationDomainService;
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

	public ApplicationDomain getApplicationDomain() {
		return applicationDomain;
	}

	public void setApplicationDomain(ApplicationDomain applicationDomain) {
		this.applicationDomain = applicationDomain;
	}

	public String getApplicationDomainService() {
		return applicationDomainService;
	}

	public void setApplicationDomainService(String applicationDomainService) {
		this.applicationDomainService = applicationDomainService;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	
}
