package poj;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class poj1022 {
    private static int n,q[]=new int[1000],inq[]=new int[1000],con[][]= new int[1000][9],move[][] = new int[1000][9],sta[] = new int[9];
    private static Map<Integer,Integer> pos = new TreeMap<Integer, Integer>();

    public static  void main (String args[]) {
        Scanner in = new Scanner(System.in);
        int T =in.nextInt();
        while (T-- != 0) {
            n = in.nextInt();
            pos.clear();
            pos.put(0,0);
            for (int i = 1; i <= n; i ++) {
                int o;
                o = in.nextInt();
                pos.put(o,i);
                for (int j = 1;j <= 8;j ++){
                    int t;
                    t = in.nextInt();
                    con[i][j] = t;
                }
            }
            for(int k = 0 ; k < inq.length ; k ++ ) inq[k] = 0 ;
            for(int k = 0 ; k < move.length ; k ++ )
                for (int v = 0 ; v < move[0].length ; v ++)
                    move[k][v] = 0 ;
            if (!solve()) {
                System.out.println("Inconsistent");
                continue;
            }
            for(int k = 0 ; k < sta.length ; k ++) {
                sta [k] = 0;
            }
            for (int i = 1;i <= n;i ++){
                for (int j = 1;j <= 8;j ++){
                    if (move[i][j] > sta[j]) sta[j] = move[i][j];
                }
            }
            System.out.println((sta[1] + sta[2] + 1) * (sta[3] + sta[4] + 1) * (sta[5] + sta[6] + 1) * (sta[7] + sta[8] + 1));
        }
        in.close();
    }

    static boolean solve () {
        int head = 0,tail = 0;
        //bfs
        inq[q[++tail] = 1] = 1;
        while (head < tail){
            int now = q[++head];
            for (int i = 1;i <= 8;i ++) {
                int next = (int)pos.get(con[now][i]);
                if (con[now][i]!=0 && pos.get(con[next][((i + 1) ^ 1) - 1]) != now) return false;
                if (con[now][i]!=0 && inq[pos.get(con[now][i])] == 0){
                    inq[q[++tail] = next] = 1;
                    for (int j = 1;j <= 8;j ++) move[next][j] = move[now][j];
                    move[next][i] = move[now][i] + 1;
                }
            }
        }

        for (int i = 1;i <= n;i ++) if (inq[i] == 0) return false;
        return true;

    }
}
