package Comparato;

import Model.Student;

import java.util.Comparator;

public class SortPointDown implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        int point1 = o1.getPoint();
        int point2= o2.getPoint();
        if (point1 < point2){
            return -1;
        }else return 1;
    }
}
