package com.symbl.core.impl;

import com.symbl.core.Actor;
import com.symbl.core.Reference;
import lombok.Getter;

public abstract class AbstractActor implements Actor {

    @Getter
    private Reference<Actor> self;

    public AbstractActor(Reference<Actor> self) {
        this.self = self;
    }

}
