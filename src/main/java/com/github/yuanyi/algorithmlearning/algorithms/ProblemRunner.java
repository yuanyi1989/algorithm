package com.github.yuanyi.algorithmlearning.algorithms;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 袁意 on 2018/1/10.
 */
public abstract class ProblemRunner {

    public abstract void doRun();

    public int[] generateNoRepeatAndRandomAndSortedAscData(int length) {
        int[] ints = generateNoRepeatRandomData(length);
        Arrays.sort(ints);
        return ints;
    }

    public int[] generateNoRepeatRandomData(int length) {
        SecureRandom random = new SecureRandom();
        Set<Integer> store = new HashSet<>();

        while (store.size() < length) {
            boolean isNe = random.nextBoolean();
            int number = random.nextInt(length * 10);
            store.add(number * (isNe ? -1 : 1));
        }

        return store.stream().mapToInt(number -> number.intValue()).toArray();
    }

}
