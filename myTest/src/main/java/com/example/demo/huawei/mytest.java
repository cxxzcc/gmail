package com.example.demo.huawei;

import java.util.*;

/**
 * @author cch
 * @date 2021/11/28$
 * @since JDK1.8
 */
public class mytest {

    public static int step = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            final String s = sc.nextLine();

            final ArrayList<Integer> integers = new ArrayList<>();
            String[] s1 = s.split(" ");
            for (int i = 0; i < s1.length / 2; i++) {
                step = 0;
                if (step(s1, i)) {
                    integers.add(step);
                }
            }

            if (integers.size()==0) {
                System.out.println(-1);
            }else {
                Collections.sort(integers);
                System.out.println(integers.get(0));
            }
        }
    }

    public static boolean step(String[] l, int index) {
        step++;
        if (l.length-1 == index) {
            return true;
        } else if (index > l.length-1) {
            return false;
        } else {
            return step(l, index + Integer.parseInt(l[index]));
        }

    }
}
