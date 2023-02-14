package com.example.demo.huawei;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * @author cch
 * @date 2021/11/28$
 * @since JDK1.8
 */
public class mytest2 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            final String s = sc.nextLine();

            final String[] split = s.split(" ");
            for (int i = 0; i < split.length; i++) {
                if (split[i].contains("add")) {
                    split[i + 1] = split[i + 1] + "+";
                    split[i] = split[i].replace("add", "");
                }
                if (split[i].contains("sub")) {
                    split[i + 1] = split[i + 1] + "-";
                    split[i] = split[i].replace("sub", "");
                }
                if (split[i].contains("mul")) {
                    split[i + 1] = split[i + 1] + "*";
                    split[i] = split[i].replace("mul", "");
                }
                if (split[i].contains("div")) {
                    split[i + 1] = split[i + 1] + "/";
                    split[i] = split[i].replace("div", "");
                }

            }
            final StringBuilder stringBuilder = new StringBuilder();

            for (String s1 : split) {
                stringBuilder.append(s1);
            }
            final String[] split1 = stringBuilder.toString().split("\\(");
            try {
                System.out.println(step(split1, 1));
            } catch (ArithmeticException e) {
                System.out.println("error");
            }


        }
//(add 2 (add 1 (div -7 3)))

    }

    public static int step(String[] s, int index) {


            final String s1 = s[index].replaceAll("\\)", "");
        final boolean b = index < s.length-1;
        if (s1.contains("/")) {

                final String[] replace = s1.split("/");
                final int i = Integer.parseInt(replace[0]);
                if (b) {
                    return i / step(s, index + 1);
                }else {

                    final BigDecimal divide = new BigDecimal(i).divide(new BigDecimal(replace[1]), RoundingMode.UP);
                    return Integer.parseInt(divide.toString());
                }

            }
            if (s1.contains("+")) {
                final String[] replace = s1.split("\\+");
                final int i = Integer.parseInt(replace[0]);
                if (b) {
                return i + step(s, index + 1);
                 }else {
                    return i  +Integer.parseInt(replace[1]);
                }
            }
            if (s1.contains("-")) {
                final String[] replace = s1.split("-");
                final int i = Integer.parseInt(replace[0]);
                if (b) {
                return i - step(s, index + 1);
                 }else {
                    return i  -Integer.parseInt(replace[1]);
                }
            }
            if (s1.contains("*")) {
                final String[] replace = s1.split("\\*");
                final int i = Integer.parseInt(replace[0]);
                if (b) {
                return i * step(s, index + 1);
                 }else {
                    return i  *Integer.parseInt(replace[1]);
                }
            }
            return Integer.parseInt(s1);

    }
}
