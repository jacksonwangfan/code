package com.wf.code;

import java.lang.instrument.Instrumentation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @auter wf
 * @date 2020/12/10
 */
public class test {

    public static void main(String[] args) {
        System.out.println(String.join(",","223312313"));
        System.out.println( new  IllegalArgumentException() instanceof  Throwable );
        ko:
        for (int i = 0; i < 100; i++) {
            b0:
            for (int j = 0; j < 100; j++) {
                break b0;
            }
        }
    }

}
