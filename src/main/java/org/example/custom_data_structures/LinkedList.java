package org.example.custom_data_structures;

import java.util.Optional;

public class LinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public Optional<E> addHead(final E element) {
        if (size == 0) {
            initializeList(element);
        } else {
            final Node<E> newNode = createNode(element);
            newNode.next = head;
            head = newNode;
            size++;
        }
        return Optional.of(element);
    }

    public Optional<E> addTail(final E element) {
        if (size == 0) {
            initializeList(element);
        } else {
            final Node<E> newNode = createNode(element);
            tail.next = newNode;
            tail = newNode;
            size++;
        }
        return Optional.of(element);
    }

    private void initializeList(final E element) {
        final Node<E> newNode = createNode(element);
        head = tail = newNode;
        size++;
    }

    private Node<E> createNode(final E element) {
        return new Node<>(element);
    }

    public Optional<E> add(final E element) {
        return addTail(element);
    }

    public Optional<E> removeHead() {
        if (size == 0) return Optional.empty();
        Node<E> prevHead = head;
        if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
        }
        size--;
        return Optional.of(prevHead.element);
    }

    public Optional<E> removeTail() {
        if (size == 0) return Optional.empty();
        Node<E> prevTail = tail;
        if (size == 1) {
            head = tail = null;
        } else {
            var current = head;
            for (int i = 1; i < size - 1; i++) {
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
        size--;
        return Optional.of(prevTail.element);
    }

    public Optional<E> insert(final int index, final E element) {
        if (index < 0 || index > size) return Optional.empty();
        if (index == 0) {
            return addHead(element);
        } else if (index == size) {
            return addTail(element);
        } else {
            var newNode = new Node<>(element);
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
            return Optional.ofNullable(element);
        }
    }

    public Optional<E> update(final int index, final E element) {
        if (index < 0 || index >= size) return Optional.empty();
        Node<E> targetNode = head;
        for (int i = 0; i < index; i++) {
            targetNode = targetNode.next;
        }
        targetNode.element = element;
        return Optional.ofNullable(element);
    }

    public Optional<E> delete(final int index) {
        if (index < 0 || index >= size) return Optional.empty();
        if (index == 0) {
            return removeHead();
        } else if (index == size - 1) {
            return removeTail();
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node<E> nodeToRemove = current.next;
            current.next = nodeToRemove.next;
            size--;
            return Optional.of(nodeToRemove.element);
        }
    }

    public Optional<E> delete(final E element) {
        if (size == 0) return Optional.empty();
        if (head.element.equals(element)) {
            return removeHead();
        }
        Node<E> current = head;
        while (current.next != null && !current.next.element.equals(element)) {
            current = current.next;
        }
        if (current.next != null) {
            Node<E> nodeToRemove = current.next;
            current.next = nodeToRemove.next;
            if (current.next == null) {
                tail = current;
            }
            size--;
            return Optional.of(nodeToRemove.element);
        }
        return Optional.empty();
    }

    public void deleteAll() {
        head = tail = null;
        size = 0;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.element;
            current = current.next;
        }
        return array;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = head;
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

    private class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }
    }
}
