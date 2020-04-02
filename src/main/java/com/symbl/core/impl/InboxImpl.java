package com.symbl.core.impl;

import com.symbl.core.Actor;
import com.symbl.core.Inbox;
import com.symbl.core.Message;
import lombok.ToString;

import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;

@ToString(exclude = {"queue"})
public class InboxImpl implements Inbox {

    private final UUID id = UUID.randomUUID();
    private final Queue<Message> queue = new LinkedBlockingQueue<>();

    @Override
    public void push(Message message) {
        queue.add(message);
    }

    @Override
    public Actor process(Actor actor) {
        while (queue.size() > 0) {
            System.out.println("Queue : " + id + " , contains : " + queue.size() + " messages");
            Message message = queue.poll();
            System.out.println("**** Queue : " + id);
            System.out.println("**** Message: " + message);
            actor.message(message);
        }
        return actor;
    }

}
