1.给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:

输入: 1->1->2
输出: 1->2
示例 2:

输入: 1->1->2->3->3
输出: 1->2->3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre=new ListNode(-666);
        ListNode newhead=pre;
        pre.next=head;
        ListNode cur=head;
        while(cur!=null){
            if(cur.val==pre.val){
                cur=cur.next;
                
            }else{
                pre.next=cur;
                pre=cur;
                cur=cur.next;
            }
        }
        if(pre.next!=null){
            pre.next=null;
        }
        return newhead.next;
    }
}

2.给定一个带有头结点 head 的非空单链表，返回链表的中间结点。

如果有两个中间结点，则返回第二个中间结点。

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fastNode=head;
        ListNode slowNode=head;
        while(fastNode!=null&&fastNode.next!=null){
            fastNode=fastNode.next.next;
            slowNode=slowNode.next;
        }
        return slowNode;
    }
}

3.
给定一个正整数，检查他是否为交替位二进制数：换句话说，
就是他的二进制数相邻的两个位数永不相等。
class Solution {
    public boolean hasAlternatingBits(int n) {
       int tmp=n^(n>>1);
        return (tmp&(tmp+1))==0;
    }
}

4.每个非负整数 N 都有其二进制表示。例如， 5 可以被表示为二进制 "101"，11 可以用二进制 "1011" 表示，依此类推。注意，除 N = 0 外，任何二进制表示中都不含前导零。

二进制的反码表示是将每个 1 改为 0 且每个 0 变为 1。例如，二进制数 "101" 的二进制反码为 "010"。

给定十进制数 N，返回其二进制表示的反码所对应的十进制整数。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/complement-of-base-10-integer
class Solution {
    public int bitwiseComplement(int N) {
        int tmp=1;
        while(tmp<N){
            tmp=(tmp<<1)+1;
        }
        return tmp^N;
    }
}