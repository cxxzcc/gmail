package com.atguigu.gmall.seckill.myTest;

/**
 * @author cch
 * @date 2021/11/10$
 * @since JDK1.8
 */
public class aaa implements aa{

    @Override
    public boolean isDone(String s) {
        return "a".equals(s);
    }

    @Override
    public void done(String s) {
        System.out.println(s);
    }
}
