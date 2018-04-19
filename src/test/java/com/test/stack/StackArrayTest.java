package com.test.stack;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.stack.test.StackArray;

public class StackArrayTest {

    private static final int STACK_SIZE = 5;
    private static final int FIRST_ELEMENT = 3;
    private static final int SECOND_ELEMENT = 5;
    private static final int THIRD_ELEMENT = 2;
    private static final int FOURTH_ELEMENT = 9;
    private static final int FIFTH_ELEMENT = 7;
    private static final String ITEM_EXIST = "Item Exist";
    private static final String ITEM_NOT_EXIST = "Item Not Exist";

    private StackArray stackArray;

    @Before
    public void setup() {
        this.stackArray = new StackArray(STACK_SIZE);

    }

    @Test
    public void shouldTestAdd() {
        pushAllElements();

        assertEquals(FIFTH_ELEMENT, this.stackArray.peek());
        assertEquals(STACK_SIZE, this.stackArray.getSize());

    }

    @Test
    public void shouldTestRemove() {
        pushAllElements();

        assertEquals(FIFTH_ELEMENT, this.stackArray.pop());
        assertEquals(STACK_SIZE - 1, this.stackArray.getSize());

    }

    @Test
    public void shouldTestSearchIfItemNotExist() {
        pushAllElements();

        assertEquals(ITEM_NOT_EXIST, this.stackArray.search(11));

    }

    @Test
    public void shouldTestSearchIfItemExist() {
        pushAllElements();

        assertEquals(ITEM_EXIST, this.stackArray.search(FIRST_ELEMENT));

    }

    @Test
    public void shouldTestSort() {
        pushAllElements();

        this.stackArray.sortStack();
        assertEquals(FOURTH_ELEMENT, this.stackArray.peek());
        assertEquals(ITEM_EXIST, this.stackArray.search(FIRST_ELEMENT));

    }

    public void pushAllElements() {
        this.stackArray.push(FIRST_ELEMENT);
        this.stackArray.push(SECOND_ELEMENT);
        this.stackArray.push(THIRD_ELEMENT);
        this.stackArray.push(FOURTH_ELEMENT);
        this.stackArray.push(FIFTH_ELEMENT);
    }

    @After
    public void popAllElements() {
        for (int i = 0; i < this.stackArray.getSize(); i++) {
            this.stackArray.pop();
        }

    }

}
