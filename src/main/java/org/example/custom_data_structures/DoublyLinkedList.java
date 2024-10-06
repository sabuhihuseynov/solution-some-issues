package org.example.custom_data_structures;

public class DoublyLinkedList<E> {
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(E e) {
        addTail(e);
    }

    public void addHead(E element) {
        var newNode = new Node(element);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        size++;
    }

    public void addTail(E element) {
        var newNode = new Node(element);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void removeHead() {
        if (size == 0) return;
        if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
            head.previous = null;
        }
        size--;
    }

    public void removeTail() {
        if (size == 0) return;
        if (size == 1) {
            head = tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }
        size--;
    }

    public void insert(int index, E element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            addHead(element);
        } else if (index == size) {
            addTail(element);
        } else {
            var newNode = new Node(element);
            var current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            newNode.next = current;
            newNode.previous = current.previous;
            current.previous.next = newNode;
            current.previous = newNode;
            size++;
        }
    }

    public void update(int index, E element) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        var current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.element = element;
    }

    public void delete(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            removeHead();
        } else if (index == size - 1) {
            removeTail();
        } else {
            var current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.previous.next = current.next;
            current.next.previous = current.previous;
            size--;
        }
    }

    public void delete(E element) {
        if (size == 0) return;
        var current = head;
        while (current != null && !current.element.equals(element)) {
            current = current.next;
        }
        if (current != null) {
            if (current == head) {
                removeHead();
            } else if (current == tail) {
                removeTail();
            } else {
                current.previous.next = current.next;
                current.next.previous = current.previous;
                size--;
            }
        }
    }

    public void deleteAll() {
        head = tail = null;
        size = 0;
    }

    public Object[] toArray() {
        var array = new Object[size];
        var current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.element;
            current = current.next;
        }
        return array;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        var current = head;
        sb.append("[");
        while (current != null) {
            sb.append(current.element);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public int getSize() {
        return size;
    }

    private class Node {
        E element;
        Node next;
        Node previous;

        Node(E element) {
            this.element = element;
        }
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        LinkedList<?> that = (LinkedList<?>) o;
//        if (size != that.size) return false;
//
//        LinkedList.Node<?> thisCurrent = head;
//        LinkedList.Node<?> thatCurrent = that.head;
//        while (thisCurrent != null) {
//            if (!Objects.equals(thisCurrent.element, thatCurrent.element)) {
//                return false;
//            }
//            thisCurrent = thisCurrent.next;
//            thatCurrent = thatCurrent.next;
//        }
//        return true;
//    }


}
