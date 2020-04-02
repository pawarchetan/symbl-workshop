package com.symbl.core.impl;

import com.symbl.core.Actor;
import com.symbl.core.Reference;
import lombok.Getter;
import lombok.ToString;

@ToString
public abstract class AbstractMessage {

    @Getter
    private final Reference<Actor> sender;

    public AbstractMessage(Reference<Actor> sender) {
        this.sender = sender;
    }

}
