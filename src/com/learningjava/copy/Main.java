package com.learningjava.copy;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.address.city = "guangzhou";
        Person person2 = (Person) person.clone();
        person2.name = "kdlsd";
        System.out.println(person.toString());

    }
}

class Person implements Cloneable {
    public String name = "xiaohoang";
    public int age = 19;
    public Address address = new Address();

    @Override
    public Object clone() {
        Person person = null;
        try {
            person = (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return person;
    }
}

class Address implements Cloneable {
    public String city = "shenzhen";

    @Override
    public Object clone() {
        Address address = null;
        try {
            address = (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return address;
    }
}