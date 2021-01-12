package com.shop.test;

import android.view.View;

import androidx.databinding.ViewDataBinding;

public class MyClass extends BaseClass{

    private ViewDataBinding binding;

    public MyClass(ViewDataBinding binding){
        super(binding.getRoot());
        this.binding = binding;
    }


    public void test(){

    }

}
