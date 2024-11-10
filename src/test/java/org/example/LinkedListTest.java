package org.example;

import org.example.custom_data_structures.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListTest {

    LinkedList<String> list;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
        list.add("Harry");
        list.add("Hermione");
        list.add("Ron");
    }

    @Test
    void addLinkedList_Should_ReturnSuccess() {
        LinkedList<String> list1 = new LinkedList<>();
        var result = list1.add("Harry");
        assertEquals("Harry", result.get());
    }

}
