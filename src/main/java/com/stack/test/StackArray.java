package com.stack.test;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class StackArray
{
    protected int stackArrays[];
    protected int top, size, len;

    // Constructor for StackArray
    public StackArray(final int n)
    {
        this.size = n;
        this.len = 0;
        this.stackArrays = new int[this.size];
        this.top = -1;
    }

    // Function to check if stack is empty
    public boolean isEmpty()
    {
        return this.top == -1;
    }

    // Function to check if stack is full
    public boolean isFull()
    {
        return this.top == this.size - 1;
    }

    // Function to get the size of the stack
    public int getSize()
    {
        return this.len;
    }

    // Function to peek top most element
    public int peek()
    {
        if (isEmpty()) {
            throw new NoSuchElementException("Underflow Exception");
        }
        return this.stackArrays[this.top];
    }

    // Function to add an element to the stack
    public synchronized void push(final int element)
    {
        if (this.top + 1 >= this.size) {
            throw new IndexOutOfBoundsException("Overflow Exception");
        }
        if (this.top + 1 < this.size) {
            this.stackArrays[++this.top] = element;
        }
        this.len++;
    }

    // Function to delete an element from the stack
    public synchronized int pop()
    {
        if (isEmpty()) {
            throw new NoSuchElementException("Underflow Exception");
        }
        this.len--;
        return this.stackArrays[this.top--];
    }

    // Function to search element
    public String search(final int element) {
        for (int i = 0; i < getSize(); i++) {
            if (this.stackArrays[i] == element) {
                return "Item Exist";
            }

        }
        return "Item Not Exist";
    }

    // Fuction to sort element
    public void sortStack() {
        Arrays.sort(this.stackArrays);
    }

    // Function to display the status of the stack
    public void display()
    {
        System.out.print("\nStack = ");
        if (this.len == 0)
        {
            System.out.print("Empty\n");
            return;
        }
        for (int i = this.top; i >= 0; i--) {
            System.out.print(this.stackArrays[i] + " ");
        }
        System.out.println();
    }
}
