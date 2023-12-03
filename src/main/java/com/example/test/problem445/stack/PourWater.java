package com.example.test.problem445.stack;

public class PourWater {
    public int[] pourWater(int[] heights, int V, int K) {
        // brute solution
        if (heights == null || heights.length == 0 || V == 0) {
            return heights;
        }
        int index;
        while (V > 0) {
            index = K;
            // Try to move left
            for (int i = K - 1; i >= 0; i--) {
                if (heights[i] > heights[index]) {
                    break;
                } else if (heights[i] < heights[index]) {
                    index = i;
                }
            }
            if (index != K) {
                heights[index]++;
                V--;
                continue;
            }
            // Try to move right
            for (int i = K + 1; i < heights.length; i++) {
                if (heights[i] > heights[index]) {
                    break;
                } else if (heights[i] < heights[index]) {
                    index = i;
                }
            }
            heights[index]++;
            V--;
        }
        return heights;
    }


//	----------------------
//    Water drops at index K.
//    It moves left or right until it finds a position where it would eventually fall.
//    If it can't move left or right to a lower level, it rises at its current position.
//    The simulation continues until all units of water (V) are poured. The heights array
//    is then returned, representing the final state of the elevation map after pouring water.
//
//    public int[] pourWater(int[] heights, int V, int K) {
//        if (heights == null || heights.length == 0 || V == 0) {
//            return heights;
//        }
//
//        final int LEFT = -1;
//        final int RIGHT = 1;
//
//        while (V > 0) {
//            int dropPosition = findDropPosition(heights, K, LEFT);
//            if (dropPosition != K) {
//                heights[dropPosition]++;
//                V--;
//                continue;
//            }
//
//            dropPosition = findDropPosition(heights, K, RIGHT);
//            heights[dropPosition]++;
//            V--;
//        }
//
//        return heights;
//    }
//
//    private int findDropPosition(int[] heights, int start, int direction) {
//        int dropPosition = start;
//        for (int i = start + direction; i >= 0 && i < heights.length; i += direction) {
//            if (heights[i] > heights[dropPosition]) {
//                break;
//            } else if (heights[i] < heights[dropPosition]) {
//                dropPosition = i;
//            }
//        }
//        return dropPosition;
//    }

}
