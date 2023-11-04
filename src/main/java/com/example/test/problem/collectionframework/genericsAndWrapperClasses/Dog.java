package com.example.test.problem.collectionframework.genericsAndWrapperClasses;

public class Dog<E, AB> {
    E id;
    AB name;

    public Dog(E id, AB name) {
        this.id = id;
        this.name = name;
    }

    E getId() {
        return this.id;
    }
}
