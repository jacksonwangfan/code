package com.wf.code.设计模式.单例;

public class Single {
    
    private static class SingleHolder {
        private static Single single = new Single();
    }
    
    public static Single getInstance() {
        return SingleHolder.single;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Single.getInstance());
        }
    }
    
    
}
