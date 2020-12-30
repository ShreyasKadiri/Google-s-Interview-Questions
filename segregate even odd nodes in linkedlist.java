class Solution{
    public ListNode segregateEvenOddList(ListNode head){
        if(head == null){
            return null;
        }
        
        if(head.next==null){
            return head;
        }
        
        if(head.next.next==null){
            return head;
        }
        
        ListNode evenHead=head.next;
        ListNode oddHead = head;
        ListNode odd=head;
        ListNode even = head.next;
        
        while(odd.next!=null || even.next!=null || odd!=null || even!=null){
            odd.next = odd.next.next;
            even.next= even.next.next;
            odd= odd.next;
            even=even.next;
        }
        odd.next = evenHead;
        return oddHead;
    }
}
