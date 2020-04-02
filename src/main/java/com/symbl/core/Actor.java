package com.symbl.core;

public interface Actor {

    Reference<Actor> getSelf();

    void message(Message message);

}
