package com.mnxfst.iservices.core.actors.perf;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

import com.mnxfst.iservices.core.messages.BaseMessage;

/**
 * Simple performance measuring actor which counts inbound messages and reads out
 * the time they've been traveling through the system so far.   
 * @author mnxfst
 * @since 31.01.2013
 * 
 * TODO
 * 		- add automated reset
 * 		- implement behavior for in case of number overflow
 */
public class PerformanceMeasuringActor extends UntypedActor {
	
	/** path to outbound actor */
	private String outboundActorPath = null;
	
	/** reference to actor receiving the incoming message after it has been measured */
	protected ActorRef outboundActorRef = null;
	
	/** number of messages seen so far */
	private long messageCount = 0;
	
	/** total number of millis messages have been floating around the system before seeing this actor */
	private long totalTravelTime = 0;
	
	private long averageTravelingTime = 0;
	private long first = 0;
	private long last = 0;
	
	/**
	 * Initializes the actor instance
	 * @param outboundActorPath
	 */
	public PerformanceMeasuringActor(String outboundActorPath) {
		this.outboundActorPath = outboundActorPath;
	}
	
	/**
	 * @see akka.actor.UntypedActor#preStart()
	 */
	public void preStart() {
		super.preStart();		
		outboundActorRef = getContext().actorFor(this.outboundActorPath);
	}

	/**
	 * @see akka.actor.UntypedActor#onReceive(java.lang.Object)
	 */
	public void onReceive(Object message) throws Exception {
		
		if(message instanceof BaseMessage) {
			BaseMessage<?> baseMessage = (BaseMessage<?>)message;
			this.messageCount = this.messageCount + 1;
			long now = System.currentTimeMillis();
			long time = (now - baseMessage.getCreationTimestamp());
			this.totalTravelTime = this.totalTravelTime + time;			
			this.outboundActorRef.tell(message, getSelf());
			first = (first == 0 ? baseMessage.getCreationTimestamp() : first);
			if(this.messageCount % 1000 == 0) {				
				last = System.currentTimeMillis();
				System.out.println("Message count: " + messageCount + ", Time: " + time + "ms, Total traveling time: " + totalTravelTime + "ms, Average traveling time: " + ((double)totalTravelTime / (double)messageCount) + "ms, Duration: " + (last-first)+"ms");
			}
				
		} else {
			unhandled(message);
		}
		
	}

}
