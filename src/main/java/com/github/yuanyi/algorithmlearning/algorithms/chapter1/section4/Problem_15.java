package com.github.yuanyi.algorithmlearning.algorithms.chapter1.section4;

import com.github.yuanyi.algorithmlearning.algorithms.ProblemRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * 3-sum 平方级实现
 * Created by 袁意 on 2018/1/11.
 */
public class Problem_15 extends ProblemRunner {

    public static void main(String[] args) {
        new Problem_15().doRun();
    }

    @Override
    public void doRun() {
        int found = 0;
        int[] ints = generateNoRepeatAndRandomAndSortedAscData(10000);
        for (int i = 0; i < ints.length; i++) {
            List<int[]> results = fastTwoSum(-ints[i], ints, i+1, ints.length - 1);
            found+=results.size();
            for (int[] array : results) {
                System.out.printf("found : %d+%d+%d=%d\n", ints[i], array[0], array[1], ints[i]+array[0]+array[1]);
            }
        }
        System.out.println("total found:"+found);
    }

    public List<int[]> fastTwoSum(int result, int[] data, int from, int end) {
        int posA = from;
        int posB = end;

        List retValue = new ArrayList();
        while (posA < posB) {
            int addedResult = data[posA] + data[posB];
            if (addedResult > result) {
                posB--;
            } else if (addedResult < result) {
                posA++;
            } else {
                retValue.add(new int[] {data[posA], data[posB]});
                posA++;
                posB--;
            }
        }

        return retValue;
    }
}
