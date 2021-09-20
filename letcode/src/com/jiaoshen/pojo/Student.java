package com.jiaoshen.pojo;

public class Student implements Comparable<Student> {

    private String name;

    private int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }


    @Override
    public int compareTo(Student o) {
        return this.score - o.score;
    }

    @Override
    public  boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null ||o.getClass() !=Student.class){
            return false;
        }
        Student another = (Student)o;
        return this.name.equals(another.name);

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
