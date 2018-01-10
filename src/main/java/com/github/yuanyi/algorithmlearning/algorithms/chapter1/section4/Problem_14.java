package com.github.yuanyi.algorithmlearning.algorithms.chapter1.section4;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

/**
 * 在一个不重复的数组中，找到所有符合以下条件的四元组：
 * 四元组中的四个数相加的结果为0
 *
 *
 * 学习笔记：设数组长度为N，则四元组有 N!/(4!*(N-4)!) 种可能  学习组合排列公式
 * 排列公式：设数组长度为N，需要取M个元素排列；则一共有 N!/(N-M)! 种可能
 * N*(N-1)*(N-2)……(N-M+1)
 * 组合公式：从排列总数除以排列 N!/(M!*(N-M)!)
 * @author 袁意
 */
public class Problem_14 {

    private int[] data;

    public static void main(String[] args) {
        Problem_14 problem = new Problem_14();
        problem.prepareData(100);
        problem.run();
    }

    public void run() {
        int count = 0;
        long totalTimes = 0;
        int length = data.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    for (int l = k + 1; l < length; l++) {
                        totalTimes++;
                        if (data[i] + data[j] + data[k] + data[l] == 0) {
                            count++;
                        } else {
                        }
                    }
                }
            }
        }
        System.out.println("total times is " + totalTimes);
        System.out.println("total sum is "+ count);
    }

    public void prepareData(int length) {
        SecureRandom random = new SecureRandom();
        Set<Integer> store = new HashSet<>();

        while (store.size() < length) {
            boolean isNe = random.nextBoolean();
            int number = random.nextInt(length * 10);
            store.add(number * (isNe ? -1 : 1));
        }

        data = store.stream().mapToInt(number -> number.intValue()).toArray();
    }
}
