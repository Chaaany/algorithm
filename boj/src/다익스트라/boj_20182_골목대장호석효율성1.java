package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class boj_20182_골목대장호석효율성1 {
    private static int n, m, a, b, c, maxCost, cost[];
    private static List<Node>[] v;

    static class Node implements Comparable<Node>{
        int node;
        int cost;
        int shy;

        Node (int node, int cost){
            this.node = node;
            this.cost = cost;
        }

        Node (int node, int cost, int shy){
            this.node = node;
            this.cost = cost;
            this.shy = shy;
        }

        @Override
        public int compareTo(Node o) {
            return this.shy - o.shy;
        }
    }


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
            v[i] = new ArrayList<Node>();
            cost[i] = 100000000;
        }

        // Input 값 넣기
        for (int i = 0; i < m; i++) {
            tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            int cost = Integer.parseInt(tmp[2]);
            v[a].add(new Node(b, cost));
            v[b].add(new Node(a, cost));
        }

        System.out.println(dijkstra());
    }

    private static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(a, 0, 0));
        cost[a] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            int curNode = cur.node;

            if(curNode == b) return cost[curNode];

            int curCost = cur.cost;
            int curShy = cur.shy;

            // 이미 방문했으면서 동시에 수치심이 이미 최소로 갱신되어 있을 경우
            if(cost[curNode] < curShy) continue;

            for (Node next: v[curNode]) {
                int nextNode = next.node;
                int nextCost = next.cost;

                // 누적 지불 금액 보다 소지한 금액이 더 크면 continue
                if(curCost + nextCost > c) continue;

                // 기존에 갱신된 수치심 보다 갱실될 수치심이 더 낮을 경우
                if(cost[nextNode] <= Math.max(cost[curNode], nextCost)) continue;

                    cost[nextNode] = Math.max(cost[curNode], nextCost);
                    pq.add(new Node(nextNode, nextCost + curCost, cost[nextNode]));
                }

        }
        return -1;
    }
}
