# Symbl.ai workshop

_**@Toshish:**_ As you are aware, In the pair programming session I have implemented the one to one message, but that was not `Asynchronous Non-Blocking`.
You suggested to use `Actor` design pattern for the same. This repository contains all core implementation of our messaging system (Actor based implementation).
#### Technology used :
* Java8
* JUnit
* Gradle
* IDE used --> IntelliJ

#### How to run :
* To send message, please run `ApplicationTest.java` test file.

#### Assumptions made :
* User and Channel will act as `Actor`

#### Implementation details :
* Workspace has been implemented in the form of context (`DefaultWorkspaceContext.java`)
* For channel communication, we will have same context will pool size equal to number of users.
* Each actor will have his own Inbox to keep track of messages.
* Inbox will be presented as `BlockingQueue` for thread safety purposes.
* Specifically for Async purpose `CompletableFuture` from Java8 has been used.
* Highlights: 
1. Standard Actor model for messaging
2. Proper use of OOP's concepts to develop extensible system (Abstraction, Encapsulation etc)
3. Classes should be small and independent.

#### Code coverage :
* Above 85%, most of the code has been covered (measured using Intellij IDEA plugin)