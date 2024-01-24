import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;   
        
        ArrayDeque<Deliver> deliverQueue = new ArrayDeque<>();
        ArrayDeque<Pickup> pickupQueue = new ArrayDeque<>();
        
        for(int i = n - 1; i >= 0; i--) {
            if(deliveries[i] > 0) deliverQueue.offer(new Deliver(i, deliveries[i]));
            if(pickups[i] > 0) pickupQueue.offer(new Pickup(i, pickups[i]));
        }
        
        while(!deliverQueue.isEmpty() || !pickupQueue.isEmpty()) {
            int go = 0;
            int goWeight = 0;
            
            while(!deliverQueue.isEmpty()) {
                if(goWeight + deliverQueue.peek().count > cap) {
                    Deliver deliver = deliverQueue.poll();
                    if(go < deliver.distance) go = deliver.distance;
                    deliverQueue.addFirst(new Deliver(deliver.distance, deliver.count - (cap - goWeight)));
                    break;
                }
                Deliver deliver = deliverQueue.poll();
                if(go < deliver.distance) go = deliver.distance;
                goWeight += deliver.count;
            }
            
            int back = 0;
            int backWeight = 0;
            while(!pickupQueue.isEmpty()) {
                if(backWeight + pickupQueue.peek().count > cap) {
                    Pickup pickup = pickupQueue.poll();
                    if(back < pickup.distance) back = pickup.distance;
                    pickupQueue.addFirst(new Pickup(pickup.distance, pickup.count - (cap - backWeight)));
                    break;
                }
                Pickup pickup = pickupQueue.poll();
                if(back < pickup.distance) back = pickup.distance;
                backWeight += pickup.count;
            }
            
            answer += (Math.max(go, back) + 1) * 2;
        }
        
        return answer;
    }
}

class Deliver{
    int distance;
    int count;
    public Deliver(int distance, int count) {
        this.distance = distance;
        this.count = count;
    }
}

class Pickup{
    int distance;
    int count;
    public Pickup(int distance, int count) {
        this.distance = distance;
        this.count = count;
    }
}