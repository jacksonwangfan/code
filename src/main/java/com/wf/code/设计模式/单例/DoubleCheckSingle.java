package com.wf.code.设计模式.单例;

public class DoubleCheckSingle {
    
    private static volatile DoubleCheckSingle doubleCheckSingle;
    
    public static DoubleCheckSingle getInstance() {
        if (doubleCheckSingle == null) {
            synchronized (DoubleCheckSingle.class) {
                if (doubleCheckSingle == null) {
                    doubleCheckSingle = new DoubleCheckSingle();
                }
            }
        }
        return doubleCheckSingle;
    }
}
