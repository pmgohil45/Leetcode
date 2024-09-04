package com.fishercoder.solutions.secondthousand;

public class _1518 {
    public static class Solution1 {
        public int numWaterBottles(int numBottles, int numExchange) {
            int drank = numBottles;
            int emptyBottles = numBottles;
            while (emptyBottles >= numExchange) {
                int exchangedBottles = emptyBottles / numExchange;
                drank += exchangedBottles;
                int unUsedEmptyBottles = emptyBottles % numExchange;
                emptyBottles = exchangedBottles + unUsedEmptyBottles;
            }
            return drank;
        }
    }
}
