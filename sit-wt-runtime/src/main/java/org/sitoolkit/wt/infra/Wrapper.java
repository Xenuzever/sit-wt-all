package org.sitoolkit.wt.infra;

public class Wrapper<T> {
    T original;

    public Wrapper(T original) {
        this.original = original;
    };

    public T get() {
        return original;
    }
}
