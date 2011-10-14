import sun.reflect.generics.tree.Tree;

public class LinkedListTest {

    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printList(head);
        printList(reverseList(head));
        findPrimes("abc2134kd31");

//        checkPrime(13);
//        checkPrime(4);
//        checkPrime(3);


    }



    private static void findPrimes(String s) {
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                String num = String.valueOf(c);
                checkPrime(Float.parseFloat(num));
                int peek = 1;
                while (i + peek < s.length() && Character.isDigit(s.charAt(i + peek))){
                    num += s.charAt(i + peek);
                    checkPrime(Float.parseFloat(num));
                    peek++;
                }

            }

        }

    }

    private static void checkPrime(float num) {
        if(num < 2 )
            return;
        for(float i = 2;i<num;i++){
            if(num / i % 1 == 0){
                //System.out.println(num + " is not prime");
                return;
            }

        }
        System.out.println(num + " is prime");
    }

    private static boolean isNum(char c){
        return Character.isDigit(c);
    }


    public static void printList(Node head){
      while (head != null){
          System.out.println(head.data);
          head = head.next;
      }
    }
    public static Node reverseList(Node head){
        Node current = head;
        Node next;
        Node previous = null;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }


}
