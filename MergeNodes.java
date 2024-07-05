class ListNode{
    int val;
    ListNode next;
    ListNode(){};
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}
class Solution {
    public ListNode mergeNodes(ListNode head) {
        if(head==null) return null;
        if(head.next == null && head.val == 0) return null;
        if(head.next == null && head.val !=0) return head;
        ListNode ML = new ListNode(0);
        ListNode MLHead = ML;
        ListNode start = head,end = head.next;
        int ans = 0;
        while(start!=null && end!=null){
            if(start.val == 0 && end.val == 0){
                ListNode temp = new ListNode(ans);
                ML.next = temp;
                ML = ML.next;
                ans=0;
                start = end;
                end = end.next;
            }else if(start.val == 0 && end.val!=0){
                ans+=end.val;
                end = end.next;
            }else if(start.val!=0 && end.val == 0){
                ans+=start.val;
                start = start.next;
            }else{
                start = start.next;
                end = end.next;
            }
        }
        return MLHead.next;
    }
}