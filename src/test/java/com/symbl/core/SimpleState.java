package com.symbl.core;

import lombok.extern.slf4j.Slf4j;

public class SimpleState {

    public static class WorkingState implements ActorState {

        @Override
        public ActorState message(final Reference self, final Message message) {
            message.getReceiver().send(new SimpleMessage(self, message.getBody()));
            return new DoneState();
        }

    }

    public static class DoneState implements ActorState {

        @Override
        public ActorState message(Reference actor, Message message) {
            System.out.println("Completed");
            return this;
        }

    }

}
