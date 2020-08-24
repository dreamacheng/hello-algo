package exm.algo.interview;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SortLog {

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println(logSort("C:\\Users\\ACHENG\\Desktop\\student.log"));
    }

    /**
     * 现有日志文件   student.log
     * 日志内容为  张三|20110123|650， 李四|20130562|700， 王五|20194561|450 //分别代表 姓名|学号|分数
     * 要求:  根据分数进行降序输出， 时间复杂度 O(n)
     * @param filePath 日志路径
     * @return
     * @throws IOException
     */
    public static List<Student> logSort(String filePath) throws IOException {
        LinkedList<Student> rest = new LinkedList<>();
        try (BufferedReader is = new BufferedReader( // 读取日志文件封装到集合
                new FileReader(filePath)
                )){
            String line;
            while ((line = is.readLine()) != null) {
                String[] group = line.split("\r\n");
                for (String single : group) {
                    String[] s = single.split("\\|");
                    rest.add(new Student(s[0], s[1], Short.parseShort(s[2])));
                }
            }
        }
        short min = Short.MAX_VALUE, max = Short.MIN_VALUE; // 限定数组大小
        for (int i = 0; i < rest.size(); i++) {
            Student curr = rest.get(i);
            min = curr.score > min ? min : curr.score;
            max = curr.score < max ? max : curr.score;
        }
        Node[] nodes = new Node[max - min + 1]; //  通过数组加链表实现计数排序
        for (int i = 0; i < rest.size(); i++) {
            Student curr = rest.get(i);
            Node vacancy;
            if ((vacancy = nodes[curr.score - min]) == null) {
                nodes[curr.score - min] = new Node(curr, null);
            } else {
                while (vacancy.next != null) {
                    vacancy = vacancy.next;
                }
                vacancy.next = new Node(curr, null);
            }
        }
        rest.clear();

        for (Node curr : nodes) {
            while (curr != null) {
                rest.addFirst(curr.student);
                curr = curr.next;
            }
        }
        return rest;
    }
}

class Student {
    String name;
    String Number;
    short score;

    public Student(String name, String number, short score) {
        this.name = name;
        Number = number;
        this.score = score;
    }
}

class Node {
    Student student;
    Node next;

    public Node(Student student, Node next) {
        this.student = student;
        this.next = next;
    }
}
