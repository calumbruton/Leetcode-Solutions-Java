// HASHMAP IMPLEMENTATION
class MyHashMap<K,V> {
    private final int SIZE = 16;
    private Entry<K,V> [] entries = new Entry [SIZE];

    class Entry<K,V>{

        public K key;
        public V val;

        Entry(K key, V val){
            this.key = key;
            this.val = val;
        }
    }

    public V getVal(K key)
    {
        int hashVal = key.hashCode() % SIZE;
        return entries[hashVal].val;
    }

    public void putVal(K key, V val){
        int hashVal = key.hashCode() % SIZE;
        Entry<K,V> entry = new Entry<>(key, val);
        if (entries[hashVal] != null){
            if (entries[hashVal].key.equals(key)){
                entries[hashVal].val = val;
            }
            System.out.println("Didn't add it: "+ key);
        }
        else {
            entries[hashVal] = entry;
        }
    }

    public static void main(String args[]){
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        myHashMap.putVal("hello", 69);
        myHashMap.putVal("hello", 100);
        myHashMap.putVal("yo", 51);
        System.out.println(myHashMap.getVal("hello"));

        MyHashMap<Integer, String> anotherHashMap = new MyHashMap<>();
        anotherHashMap.putVal(400, "Generics yay");
        System.out.println(anotherHashMap.getVal(400));
        

    }

}

// LINKED LIST IMPLEMENTATION W GENERIC 
class MyLinkedList<T> {

        Node head;

        public void add(T val){
            if (this.head != null){
                Node n = this.head;
                while (n.next != null){
                    n = n.next;
                }
                n.next = new Node<>(val);
            }
            else{
                this.head = new Node<>(val);
            }
        }

        public void prettyPrint(){
            Node n = this.head;
            while (n != null){
                System.out.println(n.val);
                n = n.next;
            }
        }

        class Node<T>{
            public T val;
            public Node next;
            Node(T val){
                this.val = val;
            }
        }

        public static void main(String args[]){
        MyLinkedList<Object> myLinkedList = new MyLinkedList<Object>();
        myLinkedList.add("hi");
        myLinkedList.add(5);
        myLinkedList.prettyPrint();

    }
}


// QUEUE IMPLEMENTATION
class Queue<T>{
    private 
    Queue(){

    }
}