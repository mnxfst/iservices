/**
 * 
 */
package com.mnxfst.iservices.core.perf;

import org.junit.Test;

import akka.actor.Actor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActorFactory;
import akka.routing.RoundRobinRouter;

import com.mnxfst.iservices.core.actors.base.ForwardingActor;
import com.mnxfst.iservices.core.actors.perf.PerformanceMeasuringActor;
import com.mnxfst.iservices.core.messages.BaseMessage;

/**
 * Simple test case for demonstrating throughput of akka based queueing system
 * @author mnxfst
 *
 */
public class SimpleThroughputTest {

	@Test
	public void testSimple() {
		
		ActorSystem system = ActorSystem.create("root");
		
		final String startingActor = "start";
		final String perfActor = "perf";
		final String endActor = "end";

		final ActorRef finalActor = system.actorOf(new Props(new UntypedActorFactory() {
			
			public Actor create() throws Exception {
				return new ForwardingActor(null);
			}
		}).withRouter(new RoundRobinRouter(100)), endActor);
		System.out.println("End Actor: " + finalActor);

		final ActorRef perfMeasuringActor = system.actorOf(new Props(new UntypedActorFactory() {			
			public Actor create() throws Exception {
				return new PerformanceMeasuringActor(finalActor.path().toString());
			}
		}), perfActor);
		System.out.println("Perf Actor: " + perfMeasuringActor);

		final ActorRef startActor = system.actorOf(new Props(new UntypedActorFactory() {
			
			public Actor create() throws Exception {
				return new ForwardingActor(perfMeasuringActor.path().toString());
			}
		}).withRouter(new RoundRobinRouter(100)), startingActor);
		
		
		
		System.out.println("Start Actor: " + startActor);

		for(int i = 0; i < 2000000; i++) {
			startActor.tell(new BaseMessage<String>("msg-"+i, System.currentTimeMillis(), startActor.path().name(), ""), null);
		}
		
		try {
			System.out.println("Sleeping");
			Thread.sleep(10000);
		} catch(Exception e) {
			
		}
	}
	
}
