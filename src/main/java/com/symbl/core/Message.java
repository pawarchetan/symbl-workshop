package com.symbl.core;

public interface Message {

    Reference<Actor> getReceiver();

    String getBody();

}
