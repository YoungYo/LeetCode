package util;

import java.util.Objects;

public class Array2List {
    public static ListNode[] buildList(int[] values) {
        if (Objects.isNull(values) || values.length == 0) {
            return new ListNode[]{};
        }
        ListNode[] nodeArray = new ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodeArray[i] = new ListNode(values[i]);
            if (i > 0) {
                nodeArray[i - 1].next = nodeArray[i];
            }
        }
        return nodeArray;
    }

    public static ListNode buildCycleList(int[] values, int pos) {
        ListNode[] nodeArray = buildList(values);
        if (pos >= 0 && pos < nodeArray.length) {
            nodeArray[nodeArray.length - 1].next = nodeArray[pos];
        }
        return nodeArray[0];
    }
}
