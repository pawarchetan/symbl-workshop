package com.symbl.core;

public interface Inbox {

    void push(Message message);

    Actor process(Actor actor);

}
