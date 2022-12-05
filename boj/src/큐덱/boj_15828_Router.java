package 큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_15828_Router {
    private static Queue<Integer> router;
    public static void main(String[] args) throws IOException {
        router = new LinkedList<>();
        int routerSize, packetCount = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        routerSize = Integer.parseInt(br.readLine());
        int InputValue = -2;

        while(InputValue != -1){
            InputValue = Integer.parseInt(br.readLine());

            // -1 입력의 끝
            if(InputValue == -1) break;

            // 0 패킷 처리
            if(InputValue == 0){
                handlePacket();
                packetCount = packetCount == 0 ? 0 : packetCount - 1;
                continue;
            }

            // 패킷 적재 or 버리기
            if(packetCount == routerSize) continue;
            router.offer(InputValue);
            packetCount++;
        }

        StringBuilder sb = new StringBuilder();

        if(packetCount == 0) {
            sb.append("empty ");
        }

        while (!router.isEmpty()) {
            sb.append(router.poll() +" ");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb.toString());

    }

    private static void handlePacket() {
        if(!router.isEmpty()) router.poll();
    }
}
