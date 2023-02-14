package com.example.demo.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 描述
 * 定义一个单词的“兄弟单词”为：交换该单词字母顺序（注：可以交换任意次），而不添加、删除、修改原有的字母就能生成的单词。
 * 兄弟单词要求和原来的单词不同。例如： ab 和 ba 是兄弟单词。 ab 和 ab 则不是兄弟单词。
 * 现在给定你 n 个单词，另外再给你一个单词 str ，让你寻找 str 的兄弟单词里，按字典序排列后的第 k 个单词是什么？
 * 注意：字典中可能有重复单词。本题含有多组输入数据。
 *
 * 数据范围：，输入的字符串长度满足  ，
 * 输入描述：
 * 先输入单词的个数n，再输入n个单词。 再输入一个单词，为待查找的单词x 最后输入数字k
 * 输出描述：
 * 输出查找到x的兄弟单词的个数m 然后输出查找到的按照字典顺序排序后的第k个兄弟单词，没有符合第k个的话则不用输出。
 * 示例1
 * 输入：
 * 3 abc bca cab abc 1
 * 输出：
 * 2
 * bca
 *
 * 示例2
 * 输入：
 * 6 cab ad abcd cba abc bca abc 1
 * 输出：
 * 3
 * bca
 * 说明：
 * abc的兄弟单词有cab cba bca，所以输出3
 * 经字典序排列后，变为bca cab cba，所以第1个字典序兄弟单词为bca
 */
public class BroWord {
    public boolean isBro(String str, String b) {
        if (str.equals(b)||str.length()!=b.length()){
            return false;
        }
        final char[] a = str.toCharArray();
        Arrays.sort(a);
        final char[] a1 = b.toCharArray();
        Arrays.sort(a1);
        final String s1 = new String(a);
        final String s2 = new String(a1);
        return s1.equals(s2);

    }
    public static void main(String[] args) {
        BroWord solution = new BroWord();
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();

            final String[] s = str.split(" ");
            Integer s1 = new Integer(s[0]);

            final String s2 = s[s.length - 2];
            final String s3= s[s.length - 1];


            final ArrayList<Object> arrayList = new ArrayList<>();
            for (String s4 : s) {
                if (solution.isBro(s4, s2)) {
                    arrayList.add(s4);
                }
            }
            System.out.println(arrayList.size());
            final List<Object> collect = arrayList.stream().sorted().collect(Collectors.toList());
            final int index = new Integer(s3) - 1;
            if(collect.size()>index){
                System.out.println(collect.get(index));
            }

        }
    }
}
