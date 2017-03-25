import java.util.Scanner;

/**
 * Created by CHEN on 2017/3/25.
 */
public class Gongsi {

    //计算时间
    private static int getLongTime(int x0, int y0, int x, int y, int time) {
        return (Math.abs(x - x0) + Math.abs(y - y0)) * time;
    }

    static int distanceTime = 0;//最快时间
    static int walkTime;
    static int taxiTime;

    /**
     * 背包递归 返回最快的时间
     *
     * @param x0 出发位置x0
     * @param y0 出发位置y0
     * @param x
     * @param y
     * @param x1
     * @param y1
     * @return
     */
    private static int getTime(int x0, int y0, int x, int y, int x1, int y1) {
        distanceTime += walkTime*(Math.abs(x-x0)+Math.abs(y-y0));
        distanceTime+= taxiTime*(Math.abs(x-x1)+Math.abs(y-y0));
        return distanceTime;
    }

    //这道题应该要用背包问题要解决 车有两种状态 乘或者不乘
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int carn = sc.nextInt();
        int[] carx = new int[carn];
        int[] cary = new int[carn];
        int[] room = new int[2];

        for (int i = 0; i < carn; i++) {
            carx[i] = sc.nextInt();
        }
        for (int i = 0; i < carn; i++) {
            cary[i] = sc.nextInt();
        }
        room[0] = sc.nextInt();
        room[1] = sc.nextInt();
        walkTime = sc.nextInt();
        taxiTime = sc.nextInt();

        //走路回公司
        int minTime = 0;
        minTime += Math.abs(room[0] - 0);
        minTime += Math.abs(room[1] - 0);
        minTime *= walkTime;


        //坐车
        for(int i=0;i<carn;i++) {
            int time=getTime(0,0,carx[i],cary[i],room[0],room[1]);
            if(time<minTime) minTime=time;
        }

        System.out.println(minTime);

    }



}
