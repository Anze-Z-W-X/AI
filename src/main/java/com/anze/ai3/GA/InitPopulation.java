package com.anze.ai3.GA;

import com.anze.ai3.utils.Utils;
import java.util.ArrayList;

public class InitPopulation {
    //初始化种群，参数：种群数量与初始染色体
    public ArrayList<int[][]> initPopulation(int[][] piece, int size) {
        ArrayList<int[][]> population = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            population.add(Utils.shuffle(piece));
        }
        return population;
    }
}
