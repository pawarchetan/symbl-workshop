package com.symbl.core;

public interface ActorState {

    ActorState message(Reference actor, Message message);

}
