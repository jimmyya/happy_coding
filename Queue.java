/**
 * Created by CHEN on 2017/3/17.
 * �˻ʺ���ǲ��ϵؼ�����ܵ�δ����
 * Ȼ��ͨ���ָ��ֳ���
 * �����µļ���δ����
 * ������������ж������δ������Ŀ
 */
public class Queue {
    int m[][]=new int[8][8];
    int num=0;
    boolean check(int row,int column) {
        if(row==1) return true;
        int i,j;
        //����ֻ����һö�ʺ�
        for(i=0;i<=row-2;i++) {
            if(m[i][column-1]==1) return false;
        }
        //���ϵ�����ֻ����һö�ʺ�
        i=row-2;
        j=i-(row-column);
        while(i>=0&&j>=0) {
            if(m[i][j]==1) return false;
            i--;
            j--;
        }
        //���ϵ�����ֻ����һö�ʺ�
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
            m[row-1][j]=1;//����Ϊһ�ֿ���
            if(check(row,j+1)==true) {//������δ�������ݱ�
                if(row==8) output();
                else solve(row+1);
            }
            m[row-1][j]=0;//����ԭ��״̬
        }
    }

    public static void main(String[] args) {
        new Main().solve(1);
    }
}
