package com.lightbend.akka.sample.myself.chat1;

import akka.actor.UntypedActor;

/**
 * Created by yangyuan on 7/20/18.
 */
public class ActorDemo extends UntypedActor {
    @Override
    public void onReceive(Object o) throws Throwable {
        if(o instanceof String){
            System.out.println(o + "发送者:" + getSender() + "wo ---" + getSelf());
            getSender().tell("hello:" + o, getSelf());
        }
        unhandled(o);
    }
}
