import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by CHEN on 2017/3/25.
 */
public class Mofabang {

    public static void main(String[] args) {

        String a="";
        String b="";
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int k=sc.nextInt();
        if(n<2||n>50) return;
        if(k<1||k>2000000000) return;
        int[] sum=new int[52];

        for(int i=0;i<n;i++) {
            sum[i]=sc.nextInt();
            if(sum[i]<0||sum[i]>99) return;
        }
        for(int j=0;j<k;j++) {
            int temp=sum[1];
            for (int i = 0; i < n; i++) {
                sum[i] = (sum[i] + sum[(i+1) % n]) % 100;
            }
            sum[n-1]=(sum[n-1]-temp+100)%100;
//            if(j==0) {
//                for(int jj=0;jj<n;jj++) {
//                    a+=sum[jj];
//                }
//            } else {
//                for(int jj=0;jj<n;jj++) {
//                    b+=sum[jj];
//                }
//                if(a.equals(b)) {
//                    k=k%j;
//                }
//            }
            System.out.print(sum[0]);
            for(int i=1;i<n;i++) {
                System.out.print(" "+sum[i]);
            }
            System.out.println();

        }
        System.out.print(sum[0]);
        for(int i=1;i<n;i++) {
            System.out.print(" "+sum[i]);
        }
    }

}
