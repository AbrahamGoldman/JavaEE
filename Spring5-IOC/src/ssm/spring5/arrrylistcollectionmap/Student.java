package ssm.spring5.arrrylistcollectionmap;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Abraham
 * @create 10:16/周六/10/07/2021
 */
public class Student {
    private String[] score; //得分
    private Book[] books;   //book数组，一共有多少本书
    private List<Course> courseList; //Course课程集合
    private Map<Integer,String> map; //这个map就是测试的
    private Map<String,Person> family; //这个map表示的是家庭成员

    public void setScore(String[] score) {
        this.score = score;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

    public void setFamily(Map<String, Person> family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "Student{" +
                "score=" + Arrays.toString(score) +
                ", books=" + Arrays.toString(books) +
                ", courseList=" + courseList +
                ", map=" + map +
                ", family=" + family +
                '}';
    }
}
