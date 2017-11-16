package com.zzq.demo.charpter2.array;

/**
 * Created by 332406 on 2017-11-16.
 */
public class ListHasFullException extends Exception {
    public ListHasFullException(String msg) {
        super(msg);
    }

    public ListHasFullException(Throwable e) {
        super(e);
    }

    public ListHasFullException(String msg, Throwable e) {
        super(msg, e);
    }
}
