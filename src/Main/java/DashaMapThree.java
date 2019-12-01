public class DashaMapThree implements Hash{

    private Node[] buckets;

    public DashaMapThree (){
        this.buckets = new Node[26];
        String letters = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Node();
            buckets[i].setKey(String.valueOf(letters.charAt(i)));
        }
    }

    private String HashFunctionThree(String input) {
       // if (input.length() > 1) {
          //  return String.valueOf(input.charAt(0) + input.charAt(1)).toLowerCase();
      //  }else {
            return String.valueOf(input.charAt(0));

    }

    public Node firstLetter(String key){
        Node headNode;
        char firstLetter = HashFunctionThree(key).charAt(0);
        headNode = buckets[(firstLetter - 'a') % 26];

        return headNode;
    }
    @Override
    public void set(String key, String value) {
        Node head = firstLetter(key);
        Node newNode = new Node(key,value);

        add(head, newNode);
    }
    public void add(Node head, Node newNode){

        while (head.getNext() != null){
            head = head.getNext();
        }
        head.setNext(newNode);
    }

    @Override
    public String delete(String key) {
        Node currNode = firstLetter(key);


        while(currNode.getNext() != null){
            if(currNode.getNext().getKey().equals(key)){
                currNode.setNext(currNode.getNext().getNext());
                return "Node has been Deleted.";
            }
            currNode = currNode.getNext();
        }
        return "Node doesn't exist.";
    }

    @Override
    public String get(String key) {

        Node currNode = firstLetter(key);

        while(currNode.getNext() != null){
            currNode = currNode.getNext();
            if(currNode.getKey().equals(key)){
                return  currNode.getValue();
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public long size() {
        Integer size = 0;
        for (Node n : buckets){
            while (n.getNext() != null){
                n = n.getNext();
                size++;
            }
        }
        return size;

    }

    @Override
    public boolean bucketSize(String key) {
        Node currNode = firstLetter(key);
        return currNode.getNext() == null;
    }

}
