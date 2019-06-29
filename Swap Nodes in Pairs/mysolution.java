class Solution {
    public ListNode swapPairs(ListNode head) {
        // 当链表为空，或者是只有一个节点时，返回该链表
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode t = dummy;
        while(true) {
            // 对链表进行两两交换
            pairs(dummy, dummy.next, dummy.next.next, dummy.next.next.next);
            // 当这对节点交换完后，没有节点，则结束循环
            if(dummy.next.next.next == null) 
                break;
            else {//否则接着交换下一对节点
                dummy = dummy.next.next;
                // 当下一对节点只有一个节点时，则结束循环
                if(dummy.next.next == null)
                    break;
            }
                
        }
        return t.next;
    }
    // 将两个节点进行交换
    public void pairs(ListNode node1, ListNode node2, ListNode node3, ListNode node4) {
        node1.next = node3;
        ListNode temp = node3.next;
        node3.next = node2;
        node2.next = temp;
    }
}

// 一样的思路，但代码量少很多

public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    // 只需要标记一个current节点就好了
    ListNode current = dummy;
    // 对节点进行两两交换
    while (current.next != null && current.next.next != null) {
        ListNode first = current.next;
        ListNode second = current.next.next;
        first.next = second.next;
        current.next = second;
        current.next.next = first;
        current = current.next.next;
    }
    return dummy.next;
}

