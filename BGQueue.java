package ss;

import java.util.Scanner;

/**
 * Created by CHEN on 2017/3/25.
 * 调整队形
 */
public class BGQueue {

    //计算多少个G在B后面
    public static int sortG(String s){
        char[] c=s.toCharArray();
        int count=0;
        for(int i=0;i<c.length;i++) {
            if(c[i]=='B') {
                for (int j = i+1; j < c.length; j++) {
                    if(c[j]=='G') count++;
                }
            }
        }
        return  count;
    }
    //计算多少个B在G后面
    public static int sortB(String s) {
        char[] c=s.toCharArray();
        int count=0;
        for(int i=0;i<c.length;i++) {
            if(c[i]=='G') {
                for (int j = i+1; j < c.length; j++) {
                    if(c[j]=='B') count++;
                }
            }
        }
        return  count;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String q=sc.next();//队列
        //男生在前的情况
        int g=sortG(q);
        //女生在前的情况
        int b=sortB(q);

        if(g>b) System.out.println(b);
        else System.out.println(g);

    }//GGBBG

}
