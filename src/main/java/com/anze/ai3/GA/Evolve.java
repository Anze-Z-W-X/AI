package com.anze.ai3.GA;

import com.anze.ai3.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;

public class Evolve {
    //TODO：选择算子
    public int[][] select(ArrayList<int[][]> initpopulation) {
        ArrayList<int[][]> population = new ArrayList<>();
        double[] Probability = new double[initpopulation.size()];
        Fitness fitness = new Fitness();
        //总的适应度
        double allfitness = 0;
        for (int[][] ints : initpopulation) {
            allfitness += fitness.fitness(ints);
        }
        //单个个体的累积概率
        for (int i = 0; i < initpopulation.size(); i++) {
            Probability[i] = fitness.fitness(initpopulation.get(i)) / allfitness;
        }
        //选择initpopulation的index
        int index = selectindex(Probability);
        return initpopulation.get(index);
    }
    public int selectindex(double[] Probability) {
        double sum = 0;
        double r = Math.random();
        int index = 0;
        for (int i = 0; i < Probability.length; i++) {
            sum += Probability[i];
            if (sum > r) {
                index = i;
                break;
            }
        }
        return index;
    }
    //TODO:交叉算子-单点交叉，注释部分可生成另一个子代
    public int[][] crossOver(int[][]P1, int[][]P2){
        //  ArrayList<int[][]> two_chird = new ArrayList<>();
        int size = P1.length;
        int cross_point = (int)(Math.random() * size)%size;
        //   int[][] C1 = P1.clone();
        int[][]C1= Utils.copy(P1);
        int[][]C2= Utils.copy(P1);
        //  int[][] C2 = P2.clone();
        int index = cross_point;
        //交叉过程利用插入排序的思想
        for (int i = 0; i <= index; i++) {
            for (int j = 0; j < P1.length; j++) {
                if (Arrays.equals(P1[i],C2[j])) {
                    for (int m = j; m > i; m--) {
                        swap(C2, m, m - 1);
                    }
                }
            }
        }
        return C2;
       /* for (int i = 0; i <= index; i++) {
            for (int j = 0; j < P1.length; j++) {
                if (Arrays.equals(P2[i],C1[j])) {
                    for (int m = j; m > i; m--) {
                        swap(C1, m, m - 1);
                    }
                }
            }
        }
        two_chird.add(C1);
        two_chird.add(C2);
        return two_chird;*/
    }

    //变异算子
    public int[][] mutation(int[][]arr){
        int size = arr.length;
        int point1 = (int)(Math.random() * size)%size;
        int point2 = (int)(Math.random() * size)%size;
        while (point1==point2){
            point2 = (int)(Math.random() * size)%size;
        }
        swap(arr,point1,point2);
        return arr;
    }
    //二维数组交换
    public  int[][] swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }
}