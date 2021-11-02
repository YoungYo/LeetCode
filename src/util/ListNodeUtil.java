package util;

import java.util.Objects;

/**
 * @author 王浩
 * @date 2021/11/2 1:37 下午
 */
public class ListNodeUtil {
    public static String listToString(ListNode head) {
        ListNode p = head;
        if (Objects.isNull(p)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(p.val);
        p = p.next;
        while (Objects.nonNull(p)) {
            sb.append(", ").append(p.val);
            p = p.next;
        }
        sb.append("]");
        return sb.toString();

    }
}
