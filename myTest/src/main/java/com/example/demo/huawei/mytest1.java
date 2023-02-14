package com.example.demo.huawei;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author cch
 * @date 2021/11/28$
 * @since JDK1.8
 */
public class mytest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            final String s = sc.nextLine();
            final String out = sc.nextLine();
            final String[] split = s.split(",");

            final String[] split1 = out.split(",");

            final HashMap<Integer, Integer> map = new HashMap<>();
            for (String s1 : split) {
                String[] strings = s1.split(":");
                map.put(Integer.parseInt(strings[0]),Integer.parseInt(strings[1]));
            }
            final ArrayList<Integer> integers2 = new ArrayList<>();


            final List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());
            collect.forEach(x->{
                for (int i = 0; i < split1.length; i++) {
                    if (!split1[i].equals("")) {

                        final int e = Integer.parseInt(split1[i]);
                        if (integers2.contains(i)) {
                            continue;
                        }
                        if (x.getKey()>= e &&x.getValue()>0){
                            integers2.add(i);
                            x.setValue(x.getValue()-1);
                        }
                    }else {
                        integers2.add(i);
                    }
                }
            });
            for (int i = 0; i < split1.length; i++) {
                if (integers2.contains(i)) {
                    System.out.print(true);
                }else {
                    System.out.print(false);
                }
                if (i!=split1.length-1){

                    System.out.print(",");
                }
            }

        }
    }
}
