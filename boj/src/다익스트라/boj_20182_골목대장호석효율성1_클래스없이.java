package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class boj_20182_골목대장호석효율성1_클래스없이 {
    private static int n, m, a, b, c, maxCost, cost[];
    private static List[] v;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp[] = br.readLine().split(" ");

        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);
        a = Integer.parseInt(tmp[2]);
        b = Integer.parseInt(tmp[3]);
        c = Integer.parseInt(tmp[4]);

        v = new List[n + 1];
        cost = new int[n + 1];
        // 배열 초기화
        for (int i = 0; i <= n ; i++) {
            v[i] = new ArrayList<int[]>();
            cost[i] = 100000000;
        }

        // Input 값 넣기
        for (int i = 0; i < m; i++) {
            tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            int cost = Integer.parseInt(tmp[2]);
            v[a].add(new int[]{b, cost});
            v[b].add(new int[]{a, cost});
        }

        dijkstra();
        System.out.println(cost[b] == 100000000 ? -1 : cost[b]);
    }

    private static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        pq.add(new int[]{a, 0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int accCost = cur[1];
            int maxCost = cur[2];

            for (int i = 0; i < v[curNode].size(); i++) {
                int nextNode[] = (int[]) v[curNode].get(i);
                int nextCur = nextNode[0];
                int nextCost = nextNode[1];

                int nextAccCost = accCost + nextCost;

                if(nextAccCost > c) continue;
                int nextMaxCost = Math.max(maxCost, nextCost);
                if(cost[nextCur] > nextMaxCost){
                    cost[nextCur] = nextMaxCost;
                    pq.add(new int[]{nextCur, nextAccCost, nextMaxCost});
                }

            }

        }

    }
}

