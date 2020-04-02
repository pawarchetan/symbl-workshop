package com.symbl.core;

@FunctionalInterface
public interface Factory<T> {

    T create(Reference<T> self, String... args);

}
