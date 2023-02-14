package com.example.demo.huawei;

import com.sun.javafx.css.CalculatedValue;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author cch
 * @date 2021/11/24$
 * @since JDK1.8
 */
public class test {

    public static void main(String[] args) {
        Double x=1.2;
        long l = (long) 1.2;
        float f = (float) (x/l);
        System.out.println(f);


        byte b1=1,b2=2,b3,b6,b8;
        final byte b4=4,b5=6,b7;
        b3= (byte) (b1+b2);  /*语句1*/
        b6=(b4+b5);    /*语句2*/
        b8= (byte) (b1+b4);  /*语句3*/
        b7= (byte) (b2+b5);  /*语句4*/
        System.out.println(b3+b6);


        System.out.println(new BigDecimal(-7).divide(new BigDecimal(3), RoundingMode.UP));
    }

//    public static void main(String[] args) {
////        Scanner in = new Scanner(System.in);
////        while (in.hasNextLine()) {
////            String str = in.nextLine();
////            StringBuilder  stringBuffer = new StringBuilder ();
////            stringBuffer.reverse(str);
////            System.out.println(stringBuffer);
//
//
////        }
//    }

//    public static void main(String[] args) throws ScriptException {
//
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//
////            extracted2(in);
//
//            int i = in.nextInt();
//            int count = 0;
//            while (i>0){
//                if (i%2==1){
//                    count++;
//                }
//                i = i >> 1;
//            }
//
//
//
//            System.out.println(count);
//
//            HashMap<String, Integer> map = new HashMap<>();
//            ArrayList<Map.Entry<String,Integer>> arrayList = new ArrayList(map.keySet());
//            final StringBuffer stringBuffer = new StringBuffer();
//            stringBuffer.reverse();
//            System.out.println(stringBuffer);
//            arrayList.stream().sorted(Comparator.comparing(x->x.toString()).thenComparing(x->x.toString()))
//                    .forEach(System.out::println);
//        }
//
//class num{
//            String code;
//            Integer num;
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public Integer getNum() {
//        return num;
//    }
//
//    public void setNum(Integer num) {
//        this.num = num;
//    }
//}
////        extracted1();
//
////        extracted(sc);
////        extracted();
//    }

    private static int count(int a, int b) {
        if (a<0||b<0){
            return 0;
        }else if (a==1||b==1||a==0){
            return 1;
        }else {
            return count(a, b - 1) + count(a - b, b);
        }
    }
    private static void extracted2(Scanner in) {
        char[] a = in.nextLine().toCharArray();
        char c = getaVoid(a);
        if (c=='1'){
            System.out.println(-1);
        }else {
            System.out.println(c);
        }
    }

    private static char getaVoid(char[] a) {
        final HashMap<Character, Integer> h = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            h.put(a[i], h.getOrDefault(a[i], 0) + 1);
        }
        for (char c : a) {
            if (h.get(c)==1) {
                return  c;
            }
        }
        return '1';
    }

    private static void extracted1(Scanner sc) {
        final int length = sc.nextInt();
        final ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            integers.add(sc.nextInt());
        }

        final int i = Integer.parseInt(sc.nextLine());
        final int index = length - i;
        if (i == 0) {
            System.out.println(i);
        } else {

            System.out.println(integers.get(index));
        }
    }

    private static void extracted1() throws ScriptException {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        input = input.replace("[", "(");
        input = input.replace("{", "(");
        input = input.replace("}", ")");
        input = input.replace("]", ")");
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
        System.out.println(scriptEngine.eval(input));
    }

    private static void extracted(Scanner sc) {
        while (sc.hasNext()) {

            final int i = sc.nextInt();
            final int head = sc.nextInt();
            final ArrayList<Integer> integers = new ArrayList<>();
            integers.add(head);
            for (int i1 = 1; i1 < i; i1++) {
                final int i2 = sc.nextInt();
                final int i3 = sc.nextInt();

                integers.add(integers.indexOf(i3) + 1, i2);
            }
            integers.remove(sc.nextInt());
            integers.forEach(x -> System.out.print(x + " "));


        }
    }

    static class Point {
        int num;
        Point nextPoint;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public Point getNextPoint() {
            return nextPoint;
        }

        public void setNextPoint(Point nextPoint) {
            this.nextPoint = nextPoint;
        }
    }

    private static String prase(String s) {
        final char[] chars = s.toCharArray();
        final HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        for (char aChar : chars) {
            final Integer orDefault = characterIntegerHashMap.getOrDefault(aChar, 0);
            characterIntegerHashMap.put(aChar, orDefault + 1);
        }
        final ArrayList<Integer> ints = new ArrayList<Integer>();
        characterIntegerHashMap.forEach((x, y) -> ints.add(y));
        final List<Integer> collect = ints.stream().sorted().collect(Collectors.toList());
        int num = 26;
        int sum = 0;
        for (int i = collect.size() - 1; i >= 0; i--) {
            sum += collect.get(i) * num;
            num--;
        }
        return "" + sum;
    }

    private static void extracted() {
        String a = "nihao".toUpperCase();
        String b = "ni";

        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();

        final LinkedHashSet<Character> objects = new LinkedHashSet<>();
        for (char c : aa) {
            objects.add(c);
        }
        for (int i = 0; i <= 26; i++) {
            final char e = (char) ('A' + i);
            objects.add(e);
        }
        final ArrayList<Character> arrayList = new ArrayList<>(objects);
        final StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bb.length; i++) {
            if (bb[i] == ' ') {
                stringBuffer.append(bb[i]);
            } else if (bb[i] < 'a') {
                final int i1 = bb[i] - 'A';
                stringBuffer.append(arrayList.get(i1));
            } else {
                final int i1 = bb[i] - 'a';
                final int i2 = arrayList.get(i1) - 'A' + 'a';
                stringBuffer.append((char) i2);
            }


        }
    }

}
