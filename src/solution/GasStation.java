package solution;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i 
 * to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 *
 * Return the starting gas station's index if you can travel around the circuit once, otherwise 
 * return -1.
 *
 * Note:
 * The solution is guaranteed to be unique.
 * 
 * @author Dongliang Yu
 *
 */
public class GasStation {
    // start from i and end at j, try to modify i and j to satisfy requirements
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length)
            return -1;
        int len = gas.length;
        int i = 0;
        int j = 0;
        int tank = 0;
        while (i < len) {
            tank += (gas[j] - cost[j]);
            j++;
            if (j == len) j = 0;
            if (tank < 0) {
                while (i < len && tank < 0) {
                    tank -= (gas[i] - cost[i]);
                    i++;
                }
            } else {
                if (i == j) return i;
            }
        }
        return -1;
    }
    
    /**
    // try to extend the tail and head until they meet
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length != cost.length) return -1;
        int len = gas.length;
        //if (len == 1) {
        //    if (gas[0]-cost[0] >= 0) return 0;
        //    else return -1;
        //}
        int i = 0;
        int j = len;
        int net = 0;
        do {
            if (net < 0) {
                j--;
                net += (gas[j] - cost[j]);
            } else {
                net += (gas[i] - cost[i]);
                i++;
            }
        } while (i != j);
        if (net < 0) return -1;
        else return j % len;// for j == len case, return 0
    }
    */
    
    /**
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] A = new int[gas.length];
        for (int i = 0; i < A.length; i++)
            A[i] = gas[i] - cost[i];
        int i = 0;
        while (i < A.length) {
            if (A[i] < 0) i++;
            else {
                int sum = A[i];
                int j = (i+1) % A.length;
                while (j != i && sum >= 0) {
                    sum += A[j];
                    j = (j+1) % A.length;
                }
                if (sum < 0) i = j > i ? j : i+1;
                else return i;
            }
        }
        return -1;
    }
    */
    
    /**
    // 1. If start from A to B, B is first station can't be reached, then every station
    //    between A and B can't reach B.
    // 2. If total gas > total cost, there's a solution, otherwise not.
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length != cost.length) return -1;
        int start = 0;
        int net = 0;
        int left = 0;
        for (int i = 0; i < cost.length; i++) {
            int cur = gas[i] - cost[i];
            net += cur;
            left += cur;
            if (left < 0) {
                start = i+1;
                left = 0;
            }
        }
        if (net < 0) return -1;
        else return start;
    }
    */
    
    /*
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length != cost.length) return -1;
        int len = gas.length;
        int circleWalker = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            circleWalker += net(i, gas, cost);
            if (circleWalker < min) min = circleWalker;
        }
        if (circleWalker < 0) return -1;
        for (int i = 0; i < len; i++) {
            if (min >= 0) return i;
            min -= net(i, gas, cost);
        }
        return -1;
    }
    
    private int net(int index, int[] gas, int[] cost) {
        index %= gas.length;
        return gas[index] - cost[index];
    }
    */
}
