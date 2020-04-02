package com.symbl.core;

import lombok.ToString;
import lombok.Value;

import java.util.UUID;

@Value
@ToString(exclude = {"receiver"})
public class SimpleMessage implements Message {

    UUID id = UUID.randomUUID();

    Reference<Actor> receiver;

    String body;

}
