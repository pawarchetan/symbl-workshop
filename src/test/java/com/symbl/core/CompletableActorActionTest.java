package com.symbl.core;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;

public class CompletableActorActionTest {

    @Test
    public void complete() {
        CompletableFuture<Void> done = CompletableFuture.supplyAsync(() -> true).thenAccept(this::print);
//        Assertions.fail();
    }

    private void print(Boolean results) {
        System.out.println("Done: " + results);
    }

}
