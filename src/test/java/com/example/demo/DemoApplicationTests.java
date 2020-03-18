package com.example.demo;

import com.example.demo.annotation.PersonField;
import com.example.demo.entity.Person;
import com.example.demo.strategy.IStrategy;
import com.example.demo.factory.StrategyFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private StrategyFactory strategyFactory;

    @Test
    void contextLoads() {
        IStrategy one = strategyFactory.getStrategy("one");
        one.work();
        IStrategy two = strategyFactory.getStrategy("two");
        two.work();
    }

    @Test
    public void test1() throws IllegalAccessException {
        Person person1 = new Person();
        person1.setName("张三").setAge(1).setSex(true);
        Person person2 = new Person();
        person2.setName("张三").setAge(2).setSex(false);
        Class<? extends Person> aClass1 = person1.getClass();
        Class<? extends Person> aClass2 = person2.getClass();
        if (!aClass1.equals(aClass2)) {
            return;
        }
        Field[] declaredFields1 = person1.getClass().getDeclaredFields();
        Field[] declaredFields2 = person2.getClass().getDeclaredFields();
        Map<String, Object> map = new HashMap<>();
        for (Field field : declaredFields1) {
            if (field.isAnnotationPresent(PersonField.class)) {
                String name = field.getAnnotation(PersonField.class).name();
                field.setAccessible(true);
                Object val = field.get(person1);
                map.put(name, val);
            }
        }
    }

}
