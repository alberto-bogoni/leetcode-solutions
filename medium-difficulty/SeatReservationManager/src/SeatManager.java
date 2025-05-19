import java.util.PriorityQueue;

class SeatManager {
    PriorityQueue<Integer> seats;

    public SeatManager(int n) {
        seats = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            seats.add(i + 1);
        }
    }

    public int reserve() {
        if (seats.isEmpty()) return -1;
        return seats.poll();
    }

    public void unreserve(int seatNumber) {
        seats.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */