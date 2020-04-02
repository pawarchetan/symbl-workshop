package com.symbl.core.impl;

import com.symbl.core.Actor;
import com.symbl.core.Message;
import com.symbl.core.Reference;
import lombok.NonNull;
import lombok.ToString;
import lombok.Value;

@Value
@ToString
public class ActorReference implements Reference<Actor> {

    @NonNull ActorContext context;

    @Override
    public void send(Message message) {
        context.send(message);
    }

}
