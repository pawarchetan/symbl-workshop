package com.symbl.core;

import com.symbl.core.impl.DefaultWorkspaceContext;
import org.junit.Test;

import java.util.UUID;

public class ApplicationTest {

    @Test
    public void application() {
        try {
            WorkspaceContext system = new DefaultWorkspaceContext(1);
            Reference<Actor> from = system.create(UserActor.factory);
            Reference<Actor> to = system.create(UserActor.factory);
            System.out.println("Sender : " + from.toString());
            System.out.println("Receiver : " + to.toString());
            from.send(new SimpleMessage(to, UUID.randomUUID().toString()));
            system.terminate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
