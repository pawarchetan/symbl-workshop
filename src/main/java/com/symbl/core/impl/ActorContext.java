package com.symbl.core.impl;

import com.symbl.core.*;
import lombok.NonNull;
import lombok.ToString;

import java.util.UUID;

@ToString(exclude = {"workspaceContext"})
public class ActorContext implements Context<Actor> {

    private final UUID id = UUID.randomUUID();
    private final WorkspaceContext workspaceContext;
    private final Inbox inbox = new InboxImpl();

    public ActorContext(@NonNull WorkspaceContext workspaceContext) {
        this.workspaceContext = workspaceContext;
    }

    public void actor(@NonNull Actor actor) {
        workspaceContext.supplyAsyncThenAccept(() -> process(actor), this::next);
    }

    private Actor process(Actor actor) {
        return inbox.process(actor);
    }

    private void next(Actor actor) {
        workspaceContext.supplyAsyncThenAccept(() -> process(actor), this::next);
    }

    @Override
    public void send(Message message) {
        inbox.push(message);
    }

}
