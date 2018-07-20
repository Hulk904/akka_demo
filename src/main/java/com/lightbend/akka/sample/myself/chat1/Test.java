package com.lightbend.akka.sample.myself.chat1;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.dispatch.OnSuccess;
import akka.pattern.Patterns;
import akka.util.Timeout;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

/**
 * Created by yangyuan on 7/20/18.
 */
public class Test {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("sys");
        ActorRef actorRef = system.actorOf(Props.create(ActorDemo.class), "demo");
        Timeout timeout = new Timeout(Duration.create(2, "seconds"));
        Future<Object> future = Patterns.ask(actorRef, "akka ask", timeout);
        System.out.println("ask ...");
        future.onSuccess(new OnSuccess<Object>(){
            @Override
            public void onSuccess(Object o) throws Throwable {
                System.out.println("receive :" + o);
            }
        }, system.dispatcher());
        System.out.println("continue...");
    }
}
