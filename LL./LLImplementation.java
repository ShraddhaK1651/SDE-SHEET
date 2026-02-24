class SinglyLinkedList {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    // 1️⃣ Insert at Head
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // 2️⃣ Delete Head
    public void deleteHead() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    // 3️⃣ Find Length
    public int getLength() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // 4️⃣ Search in Linked List
    public boolean search(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // 5️⃣ Print List (helper)
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main Method
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtHead(10);
        list.insertAtHead(20);
        list.insertAtHead(30);

        System.out.println("Linked List:");
        list.printList();

        System.out.println("Length: " + list.getLength());

        System.out.println("Search 20: " + list.search(20));
        System.out.println("Search 50: " + list.search(50));

        list.deleteHead();
        System.out.println("After deleting head:");
        list.printList();
    }
}
