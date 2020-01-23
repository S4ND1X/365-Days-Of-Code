
public void insert(int data){
    if(head!=null){
        if(head.getNext() ==  null){
            Node temp = new Node(data);
            back = temp; 
            head.setNedatat(back); 
            count++; 
        }else {
            Node temp = new Node(data); 
            back.setNext(temp);
            back = temp; 
            count++;
        }
    }
    else { 
        head = new Node(data);
        count = 1;
    } 
} 