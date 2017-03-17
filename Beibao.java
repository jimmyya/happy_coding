package com.chen.solution.sss;

import java.util.Scanner;

/**
 * Created by CHEN on 2017/3/17.
 * 所谓的背包放货物
 * 货物只有两种状态，放或不放
 * 假设放的状态进行递归，如果可以就返回
 * 直接返回不放的状态进行递归
 *
 */
public class Beibao {

    static int date[]=new int[1005];

    private static boolean isFit(int w,int s){
        if(w==0) return true;
        if(w<0||w>0&&s==0) return false;
        if(isFit(w-date[s],s-1)) return true;
        return isFit(w,s-1);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int w=sc.nextInt();
        int n=sc.nextInt();
        for(int i=1;i<=n;i++) {
            date[i]=sc.nextInt();
        }
        if(isFit(w,n)) System.out.println("yes");
        else System.out.println("no");
    }
}
