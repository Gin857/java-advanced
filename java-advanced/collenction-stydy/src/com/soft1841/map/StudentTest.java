package com.soft1841.map;
/**
 * list和map综合运用
 * 2019.3.19
 */
import java.util.*;

public class StudentTest {
    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<>();
        List<Student> list2 = new ArrayList<>();
        list1.add(new Student(122, "徐鹏"));
        list1.add(new Student(123, "侯粤嘉"));
        list2.add(new Student(112, "张丽"));
        list2.add(new Student(113, "王欢乐"));

        Map<String, List<Student>> map = new HashMap<>();
        map.put("男生", list1);
        map.put("女生", list2);
        System.out.println("**********按性别分*********");
//        Iterator<Map.Entry<String, List<Student>>> iterator = map.;
//        while (iterator.hasNext()) {
//            Map.Entry<String, List<Student>> entry = iterator.next();
//            System.out.println(entry.getKey());
//            List<Student> list = entry.getValue();
//
//            for (Student s :list){
//                System.out.print("学号："+s.getNumber()+"      姓名："+s.getNeme());
//                System.out.println();
//            }
//        }
    }
}
