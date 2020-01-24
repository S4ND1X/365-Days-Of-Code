@Override
public boolean delete(int x){
    Boolean t;
    if(x>0){ 
        for (int i = 0; i < x; i++){
            if(head != null){
                head=head.getNext();
                count--;
                test = true;
            } 
        } 
    } 
    return t;
   }
            
public void clearAll(){
    int index = count;
    for (int i = 0; i < index; i++){
        delete(1);
    }
}