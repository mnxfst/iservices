package com.mnxfst.iservices.core.actors.base;

import org.apache.commons.lang.StringUtils;

import akka.actor.Props;

import com.mnxfst.iservices.core.actors.perf.ChainedPerformanceMeasuringActor;
import com.mnxfst.iservices.core.actors.perf.PerformanceMeasuringActor;

public class ChainedForwardingActor extends ForwardingActor {

	private boolean configuredOutbound = false;
	
	public ChainedForwardingActor(boolean configureOutbound) {
		super(null);
		this.configuredOutbound = configureOutbound;
	}
	
	/**
	 * @see akka.actor.UntypedActor#preStart()
	 */
	public void preStart() {
		if(configuredOutbound)
			this.outboundActorRef = getContext().actorOf(new Props(ChainedPerformanceMeasuringActor.class));
		System.out.println("Configured");
	}	
	
}


