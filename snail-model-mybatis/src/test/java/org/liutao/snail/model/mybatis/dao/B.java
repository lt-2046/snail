package org.liutao.snail.model.mybatis.dao;

import com.sun.istack.internal.NotNull;

public class B extends A {
    public B() {
        System.out.println("class B");
    }

    {
        System.out.println("I am B class");
    }

    static {
        System.out.println("class B static");
    }

    public void pr(@NotNull  String s) {

    }

    public static void main(String[] args) {
        B b = new B();
        b.pr(null);

        System.out.println(2<<2 );
    }
}