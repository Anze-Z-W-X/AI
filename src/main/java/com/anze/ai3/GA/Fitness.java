package com.anze.ai3.GA;

public class Fitness {
    //适应度计算
    public double fitness(int[][]piece){
        int temp = CalculateValue.calculateTime(piece);
        //   System.out.println("Fitness-calValue()->"+temp);
        //这里返回double，用1.0而不是1去除
        return 1.0/temp;
    }
}