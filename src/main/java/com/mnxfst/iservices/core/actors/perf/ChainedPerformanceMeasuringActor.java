package com.mnxfst.iservices.core.actors.perf;

import akka.actor.Actor;
import akka.actor.Props;
import akka.actor.UntypedActorFactory;

import com.mnxfst.iservices.core.actors.base.ChainedForwardingActor;

public class ChainedPerformanceMeasuringActor extends PerformanceMeasuringActor {

	public ChainedPerformanceMeasuringActor() {
		super(null);
	}
	
	/**
	 * @see akka.actor.UntypedActor#preStart()
	 */
	public void preStart() {
		this.outboundActorRef = getContext().actorOf(new Props(new UntypedActorFactory() {
			
			public Actor create() throws Exception {
				return new ChainedForwardingActor(false);
			}
		}));
	}
}
