/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Node implements Comparable<Node>
{
    int val;
    ListNode node;
    public Node(int v,ListNode p)
    {
        val = v;
        node = p;
    }
    public int compareTo(Node ob)
    {
        if(this.val < ob.val)
            return -1;
        else if(this.val > ob.val)
            return 1;
        else
            return 0;
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<Node> queue = new PriorityQueue<>();
        
        for(int i = 0; i < lists.length ; i++)
        {
            if(lists[i] != null)
            {
                queue.add(new Node(lists[i].val,lists[i]));
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while(!queue.isEmpty())
        {
            Node temp = queue.poll();
            curr.next = new ListNode(temp.val);
            curr = curr.next;
            
            if(temp.node.next != null)
            {
                queue.add(new Node(temp.node.next.val,temp.node.next));
            }
        }
        return dummy.next;       
    }
}
