package com.example.demo.huawei;

/**
 * @author cch
 * @date 2021/11/23$
 * @since JDK1.8
 */

import sun.net.util.IPAddressUtil;

import java.util.*;
import java.util.stream.Collectors;

public class demo {
    public static void main(String[] args) {
//
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
//            System.out.println(format(in.nextLine()));
//            snack(in.nextLine());
            mima(in);
            System.out.println(in.nextInt()*(1+2*Math.pow(0.5,1)+2*Math.pow(0.5,2)+2*Math.pow(0.5,3)+2*Math.pow(0.5,4)));

        }


    }




    public static void mima(Scanner in) {
        String a = in.nextLine().toUpperCase();
        String b = in.nextLine();

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

    public static void snack(String str) {

        final int n = Integer.parseInt(str);

        int[][] result = new int[n][];    //建立数组（n行）
        int t = 1;    //记录依次赋予的数组值
        for (int i = 0; i < n; i++) {
            result[i] = new int[n - i];    //数组第i行有n-i个元素
            for (int j = 0; j < i + 1; j++) {    //对第i个对角线赋值
                result[i - j][j] = t;
                t++;
            }
        }

        //输出数组值
        for (int[] a : result) {
            for (int a1 : a)
                System.out.print(a1 + " ");
            System.out.println();
        }


    }

    public static String format(String str) {

        final char[] chars = str.toCharArray();
        Arrays.sort(chars);

        return new String(chars);

    }

    public static String ip(String str) {
        if (str.contains(".")) {

            final String[] split = str.split("\\.", -1);
            int s0 = Integer.parseInt(split[0]);
            int s1 = Integer.parseInt(split[1]);
            int s2 = Integer.parseInt(split[2]);
            int s3 = Integer.parseInt(split[3]);

            return String.valueOf(s0 << 24 + s1 << 16 + s2 << 8 + s3);
        } else {
            long ipv4 = Long.parseLong(str);
            String result = "";
            for (int i = 0; i < 4; i++) {
                result = ipv4 % 256 + "." + result;
                ipv4 = ipv4 >> 8;
            }
            return result.substring(0, result.length() - 1);
        }
    }

    public static String reverse(String str) {
        // 匹配非字母的字符进行分割
        String[] words = str.split("[^A-Za-z]");
        StringBuilder result = new StringBuilder();

        // 逆序添加分割完的单词
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]).append(" ");
        }
        return result.toString().trim();
    }

    private static String out(String code) {
        final String replace = code.replace(" ", "");


        final char[] chars = replace.toCharArray();
        final ArrayList<Object> arrayList = new ArrayList<>();
        final ArrayList<Object> arrayList2 = new ArrayList<>();
        for (char aChar : chars) {
            if (chars.length % 2 == 1) {
                arrayList.add(aChar);
            } else {
                arrayList2.add(aChar);
            }
        }
        final List<Object> collect = arrayList.stream().sorted().collect(Collectors.toList());
        final List<Object> collect1 = arrayList2.stream().sorted().collect(Collectors.toList());


        return "";

    }

    //加密函数
    private static String encode(String code) {
        char[] t = code.toCharArray();    //将String对象转换为字符数组
        for (int i = 0; i < t.length; i++) {
            if (t[i] >= 'a' && t[i] < 'z')
                t[i] = (char) (t[i] - 'a' + 'A' + 1);
            else if (t[i] == 'z')
                t[i] = 'A';
            else if (t[i] >= 'A' && t[i] < 'Z')
                t[i] = (char) (t[i] - 'A' + 'a' + 1);
            else if (t[i] == 'Z')
                t[i] = 'a';
            else if (t[i] >= '0' && t[i] <= '9')
                t[i] = (char) ((t[i] + 1) % 10);
//            else if(t[i] == '9')
//                t[i] = '0';
        }
        return String.valueOf(t);
    }

    //解密函数
    private static String decode(String password) {
        char[] t = password.toCharArray();
        for (int i = 0; i < t.length; i++) {
            if (t[i] > 'a' && t[i] <= 'z')
                t[i] = (char) (t[i] - 'a' + 'A' - 1);
            else if (t[i] == 'a')
                t[i] = 'Z';
            else if (t[i] > 'A' && t[i] <= 'Z')
                t[i] = (char) (t[i] - 'A' + 'a' - 1);
            else if (t[i] == 'A')
                t[i] = 'z';
            else if (t[i] > '0' && t[i] <= '9')
                t[i] = (char) (t[i] - 1);
            else if (t[i] == '0')
                t[i] = '9';
        }
        return String.valueOf(t);
    }
}