package com.anze.ai3;

import com.anze.ai3.GA.CalculateValue;
import com.anze.ai3.GA.Evolve;
import com.anze.ai3.GA.InitPopulation;
import com.anze.ai3.utils.Utils;

import java.util.ArrayList;

public class MainApplication {
    public static void main(String[] args) {
        int[][] arr = {{31, 41, 25, 30},
                    {19, 55, 3, 34},
                    {23, 42, 27, 6},
                    {13, 22, 14, 13},
                    {33, 5, 57, 19}};
        for(int i=0;i<20;i++){
            solveFSP(arr);
        }
    }

    public static void solveFSP(int[][]ancestor){
        final int populationSize = 20;//种群染色体数量
        final int GenerationSize = 20;//迭代次数
        final double Cross_RATE = 0.6;//交叉率
        final double Mutation_RATE = 0.1;//变异率
        //遗传算子
        Evolve evolve = new Evolve();
        InitPopulation initPopuUtil = new InitPopulation();
        //TODO:初始化种群
        ArrayList<int[][]> initPopulation = initPopuUtil.initPopulation(ancestor, populationSize);
        //迭代结果数据-将每一代最优值即最小完工时间存入数组bestValue[]
        //并将每次迭代的种群，最优个体存入generation_Best_Chrome
        int[] bestValue = new int[GenerationSize];
        ArrayList<int[][]> generation_Best_Chrome = new ArrayList<>();
        ArrayList<int[][]> pop = initPopulation;
        //TODO：迭代开始->
        for (int i =0;i<GenerationSize;i++){
//            System.out.println("开始第"+(i+1)+"代->");
            //临时数组，存放当前种群每个染色体的目标值，即完工时间
            ArrayList<int[][]> tempPop = new ArrayList<>();
            int[] popValue = new int[populationSize];
            for (int j = 0 ; j<pop.size();j++){
                int[][] chrome = pop.get(j);
                int objValue = CalculateValue.calculateTime(chrome);
                popValue[j]=objValue;
            }
            //当前种群最优值的位置
            int index = Utils.minValueIndex(popValue);
            bestValue[i]=popValue[index];
            //记录当前种群中最优染色体
            int[][] curr_bestChrome = pop.get(index);
            generation_Best_Chrome.add(curr_bestChrome);
//            Utils.print(curr_bestChrome);
            //TODO：遗传操作
            //保留一个精英-淘汰机制
            tempPop.add(curr_bestChrome);
            //关键部分，遗传操作，选择-交叉-变异
            for (int m = 0 ; m<populationSize-1;m++){
                //轮盘赌算法，选择双亲
                int[][] P1 = evolve.select(pop);
                int[][] P2 = evolve.select(pop);
                //随机交叉率
                double cr = Math.random();
                //随机变异率
                double mr = Math.random();
                int[][] tempChrome = P1;
                //当满足定义的交叉概率时，进行交叉操作
                if (cr<Cross_RATE){
                    //这里交叉为便于达到n-1的种群数量，只得到一个子代，亦可得到两个，修改交叉算子即可
                    int[][] child = evolve.crossOver(P1, P2);
                    tempChrome = child;
                }
                //对将加入种群的染色体变异
                if (mr<Mutation_RATE){
                    tempChrome = evolve.mutation(tempChrome);
                }
                //循环得到n个染色体的下一代新种群
                tempPop.add(tempChrome);
            }
            pop = tempPop;
            // tempPop.clear();
        }
        System.out.println("int[]bestValue个数："+bestValue.length);
        for (int a:bestValue) {
            System.out.print(a+" ");
        }
        System.out.println();
    }
}
