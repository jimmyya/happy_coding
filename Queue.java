/**
 * Created by CHEN on 2017/3/17.
 * 八皇后就是不断地假设可能的未来，
 * 然后通过恢复现场，
 * 进行新的假设未来，
 * 可以用来解决有多种组合未来的题目
 */
public class Queue {
    int m[][]=new int[8][8];
    int num=0;
    boolean check(int row,int column) {
        if(row==1) return true;
        int i,j;
        //纵向只能有一枚皇后
        for(i=0;i<=row-2;i++) {
            if(m[i][column-1]==1) return false;
        }
        //左上到右下只能有一枚皇后
        i=row-2;
        j=i-(row-column);
        while(i>=0&&j>=0) {
            if(m[i][j]==1) return false;
            i--;
            j--;
        }
        //右上到左下只能有一枚皇后
        i=row-2;
        j=row+column-i-2;
        while(i>=0&&j<=7) {
            if(m[i][j]==1) return false;
            i--;
            j++;
        }
        return true;
    }

    private void output() {
        int i,j;
        num++;
        System.out.println("answer:"+num);
        for(i=0;i<8;i++) {
            for(j=0;j<8;j++) {
                System.out.print(m[i][j]);
            }
            System.out.print("\n");
        }
    }

    public void solve(int row) {
        int j;
        for(j=0;j<8;j++) {
            m[row-1][j]=1;//设置为一种可能
            if(check(row,j+1)==true) {//对这种未来进行演变
                if(row==8) output();
                else solve(row+1);
            }
            m[row-1][j]=0;//返回原来状态
        }
    }

    public static void main(String[] args) {
        new Main().solve(1);
    }
}
