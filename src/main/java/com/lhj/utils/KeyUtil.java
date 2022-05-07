package com.lhj.utils;

import java.util.Random;

/**
 * 生成随机数主键
 *
 * @author lhj on 2022/4/28
 */
public class KeyUtil {
    /**
     * 生成唯一的主键
     * 格式:时间+随机数
     * 注意:时间+随机数的方式在多线程并发时可能会生成重复内容,所以要使用synchronized加锁
     * @return
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        //保证生成的位数都相同 生成6位随机数
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }

}
