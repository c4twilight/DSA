package com.example.test.problem.collectionframework.collectionQueueAndSet;

import java.util.Objects;

class Student {
    int rollNo;
    String name;

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Student student = (Student)o;
            return this.rollNo == student.rollNo;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.rollNo});
    }

    public String toString() {
        return "Student{rollNo=" + this.rollNo + ", name='" + this.name + "'}";
    }
}
