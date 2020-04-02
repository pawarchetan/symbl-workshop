package com.symbl.core.impl;

import com.symbl.core.Actor;
import com.symbl.core.Factory;
import com.symbl.core.Reference;
import com.symbl.core.WorkspaceContext;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class DefaultWorkspaceContext implements WorkspaceContext {

    private final int POOL_SIZE = Runtime.getRuntime().availableProcessors();

    private final ExecutorService executorService;

    public DefaultWorkspaceContext() {
        executorService = Executors.newFixedThreadPool(POOL_SIZE);
    }

    public DefaultWorkspaceContext(int pool) {
        executorService = Executors.newFixedThreadPool(pool);
    }

    @Override
    public Reference<Actor> create(Factory<Actor> factory, String... args) {
        ActorContext context = new ActorContext(this);
        Reference<Actor> reference = new ActorReference(context);
        Actor actor = factory.create(reference, args);
        context.actor(actor);
        return reference;
    }

    @Override
    public void terminate() throws InterruptedException {
        executorService.awaitTermination(100, TimeUnit.MILLISECONDS);
    }

    @Override
    public <U> void supplyAsyncThenAccept(Supplier<U> supplier, Consumer<U> action) {
        CompletableFuture.supplyAsync(supplier, executorService).thenAcceptAsync(action, executorService);
    }

}
