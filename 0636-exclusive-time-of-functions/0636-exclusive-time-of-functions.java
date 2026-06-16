import java.util.*;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        // Stack stores the IDs of active function executions
        Stack<Integer> st = new Stack<>();
        int prevTime = 0;

        for (String log : logs) {
            String[] values = log.split(":");
            int id = Integer.parseInt(values[0]);
            String type = values[1];
            int timestamp = Integer.parseInt(values[2]);

            if (type.equals("start")) {
                // If there is a running function, add its execution time up to this point
                if (!st.isEmpty()) {
                    ans[st.peek()] += timestamp - prevTime;
                }
                st.push(id);
                prevTime = timestamp;
            } else {
                // "end" log represents an inclusive end of a unit time slot
                ans[st.pop()] += timestamp - prevTime + 1;
                // Move the time tracker to the start of the next possible tick
                prevTime = timestamp + 1;
            }
        }
        return ans;
    }
}
