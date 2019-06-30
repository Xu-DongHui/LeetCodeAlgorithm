
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 自己写的递归方法
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode point = head;
        // 当节点少于K个时直接返回
        for(int i = 0; i < k; i++) {
            if(head == null)
                return point;
            head = head.next;
        }
        
        ListNode Kelement = point;

        // point标记为第k+1个结点
        for(int i = 1; i < k; i++) {
            point = point.next;
        }
        ListNode temp = point.next;
        point.next = null;
        point = temp;

        // 将截断出来的k个结点逆序排列
        ListNode dummy = reverseK(Kelement, k);
        ListNode start = dummy;
        // 存在到逆序排列的k个结点的末节点
        while(start.next != null) {
            start = start.next;
        }
        // 末节点连接上递归得到的值
        start.next = reverseKGroup(point, k);
        // 返回头节点
        return dummy;
    }
    
    // 将k个结点逆序
    public ListNode reverseK(ListNode l, int k) {
        // 将节点值存储到数组中，在逆序生成节点
        int[] nums = new int[k];
        for(int i = 0; i < k; i++) {
            nums[i] = l.val;
            l = l.next;
        }
        ListNode first = new ListNode(0);
        ListNode t = first;
        // 逆序生成一个链表
        for(int i = k-1; i >-1; i--) {
            first.next = new ListNode(nums[i]);
            first = first.next;
        }
        
        return t.next;
    }
}


// 使用了较少的代码实现了递归操作
public ListNode reverseKGroup(ListNode head, int k) {
    ListNode curr = head;
    int count = 0;
    // curr定位到第k+1个结点
    while (curr != null && count != k) { 
        curr = curr.next;
        count++;
    }
    // 存在k+1个结点
    if (count == k) { 
        // 递归该操作
        curr = reverseKGroup(curr, k); 
        // head - head-pointer to direct part, 
        // curr - head-pointer to reversed part;
        // 将该k个结点逆序
        while (count-- > 0) {  
            // tmp存储下一个头节点
            ListNode tmp = head.next; 
            // 将当前头节点连接上其他节点
            head.next = curr; 
            // 更新头节点和其他节点
            curr = head; // move head of reversed part to a new node
            head = tmp; // move "direct" head to the next node in direct part
        }
        head = curr;
    }
    return head;
}
