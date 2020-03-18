package com.example.demo.entity;

import com.example.demo.annotation.PersonField;

/**
 * 人
 *
 * @author wangzhuang
 * @date 2020/03/05
 */
public class Person {

    @PersonField(name = "姓名")
    private String name;
    @PersonField(name = "年龄")
    private Integer age;

    private boolean sex;

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Person setAge(Integer age) {
        this.age = age;
        return this;
    }

    public boolean isSex() {
        return sex;
    }

    public Person setSex(boolean sex) {
        this.sex = sex;
        return this;
    }
}
