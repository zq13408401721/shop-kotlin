package com.shop.test;

import android.view.View;

public class BaseClass {
    protected View view;
    public int a,b,c,d,e,f;

    public BaseClass(View view){
        this.view = view;
    }

    public BaseClass fun1(){
        a = 1;
        b = 2;
        return this;
    }

    public BaseClass fun2(){
        a = 10;
        d = 2;
        return this;
    }

}
