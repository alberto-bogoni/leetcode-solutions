import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Meeting {
  int start;
  int end;

  public Meeting(int start, int end) {
    this.start = start;
    this.end = end;
  }
};
public class Solution {
    public int findMinimumMeetingRooms(List<Meeting> meetings) {
        if (meetings == null || meetings.size() == 0)
            return 0;

        Collections.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));

        int minRooms = 0;
        PriorityQueue<Meeting> minHeap = new PriorityQueue<>(meetings.size(), (a, b) -> Integer.compare(a.end, b.end));
        for (Meeting meeting : meetings) {
            while (!minHeap.isEmpty() && meeting.start >= minHeap.peek().end)
                minHeap.poll();
            minHeap.offer(meeting);
            minRooms = Math.max(minRooms, minHeap.size());
        }
        return minRooms;
    }

    public int findMinimumMeetingRoomsSecondApproach(List<Meeting> meetings) {
        if (meetings == null || meetings.size() == 0)
            return 0;

        List<Integer> starts = meetings.stream().map(m -> m.start).sorted().toList();
        List<Integer> ends = meetings.stream().map(m -> m.end).sorted().toList();

        int minRooms = 0;
        int count = 0;
        int first = 0;
        int second = 0;
        while (first < starts.size() && second < ends.size()) {
            if (starts.get(first) < ends.get(second)) {
                count++;
                first++;
            } else {
                count--;
                second++;
            }

            minRooms = Math.max(count, minRooms);
        }

        return minRooms;
    }

}
