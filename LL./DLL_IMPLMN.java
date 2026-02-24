class DoublyLinkedList {

    // Node class
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;

    // 1️⃣ Insert node before head
    public void insertBeforeHead(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // 2️⃣ Delete head
    public void deleteHead() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        head = head.next;
        head.prev = null;
    }

    // 3️⃣ Reverse Doubly Linked List
    public void reverse() {
        Node temp = null;
        Node current = head;

        while (current != null) {
            // Swap next and prev
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            current = current.prev;  // move forward (because swapped)
        }

        if (temp != null) {
            head = temp.prev;
        }
    }

    // Print list forward
    public void printForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertBeforeHead(10);
        dll.insertBeforeHead(20);
        dll.insertBeforeHead(30);

        System.out.println("Doubly Linked List:");
        dll.printForward();

        dll.deleteHead();
        System.out.println("After deleting head:");
        dll.printForward();

        dll.reverse();
        System.out.println("After reversing:");
        dll.printForward();
    }
}
