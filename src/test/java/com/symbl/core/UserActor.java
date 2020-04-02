package com.symbl.core;

import com.symbl.core.impl.AbstractActor;
import lombok.ToString;

@ToString
public class UserActor extends AbstractActor implements Actor {

    public static final Factory<Actor> factory = (self, args) -> new UserActor(self);

    private ActorState state = new SimpleState.WorkingState();

    private UserActor(Reference<Actor> self) {
        super(self);
    }

    @Override
    public void message(Message message) {
        state = state.message(getSelf(), message);
    }

}
