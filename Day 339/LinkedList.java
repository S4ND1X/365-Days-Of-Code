
    //Imprimir string de la linked list
    public String toString() {
        ListNode currentNode = this.firstNode;
        
        StringBuffer bf = new StringBuffer();
        
        bf.append("{");
        for (int i = 0; currentNode != null; i++) {
        	if (i > 0) { bf.append(","); }
        	Object dataObject = currentNode.getData();
        	
        	bf.append(dataObject == null ? "" : dataObject);
            currentNode = currentNode.getNext();
        }
        bf.append("}");
        return bf.toString();
    }
}