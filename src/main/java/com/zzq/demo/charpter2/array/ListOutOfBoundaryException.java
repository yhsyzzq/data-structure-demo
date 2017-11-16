package com.zzq.demo.charpter2.array;

/**
 * Created by 332406 on 2017-11-16.
 */
public class ListOutOfBoundaryException extends Exception {

    public ListOutOfBoundaryException(String msg) {
        super(msg);
    }

    public ListOutOfBoundaryException(Throwable e) {
        super(e);
    }

    public ListOutOfBoundaryException(String msg, Throwable e) {
        super(msg, e);
    }
}
