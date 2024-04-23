/*
 * @Author: uyrance uyrance@hotmal.com
 * @Date: 2024-04-22 16:47:13
 * @LastEditors: uyrance uyrance@hotmal.com
 * @LastEditTime: 2024-04-22 16:53:28
 * @FilePath: \INFO6205\Finalterm\Solution2.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package Finalterm;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        second.next = second.next.next;
        return dummy.next;
    }
    
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        
        // Test Example 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        
        head1 = solution.removeNthFromEnd(head1, 2);
        printList(head1); 
      
    }
    
  
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print("->");
            node = node.next;
        }
        System.out.println();
    }
}
