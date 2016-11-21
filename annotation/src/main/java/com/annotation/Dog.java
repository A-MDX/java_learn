package com.annotation;

import com.annotation.anno.Seven;

/**
 * Created by A-mdx on 2016/11/21.
 */
public class Dog {
    
    @Seven(value = "Lumia")
    private String name;
    
    private String Property;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getProperty() {
        System.out.println(this.name + this.Property);
    }

    @Seven(Property = "OK I AM SUPERMAN.")
    public void setProperty(String property) {
        Property = property;
    }

    public void say() {
        System.out.println("小狗:汪汪汪汪.....");
    }
    
}
