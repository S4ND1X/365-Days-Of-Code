public class LinkedList {
    
    private ListNode firstNode;
    private ListNode lastNode;
    private int size;
    
 
    public LinkedList() {
        this.firstNode = new ListNode();
        this.lastNode = this.firstNode;
        this.size = 0;
    }
    
    public LinkedList(Object inputData) {
    	this();
    	this.add(inputData);
    }

}