package com.symbl.core;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface WorkspaceContext {

    Reference<Actor> create(Factory<Actor> factory, String... args);

    <U> void supplyAsyncThenAccept(Supplier<U> supplier, Consumer<U> action);

    void terminate() throws InterruptedException;
}
