package com.example.integradora.service;

import org.springframework.stereotype.Service;

import com.example.integradora.model.HistoryAction;
import com.example.integradora.structures.ArrayStack;

@Service
public class HistoryService {

    private ArrayStack<HistoryAction> stack = new ArrayStack<>(100);

    public ArrayStack<HistoryAction> getStack() {
        return stack;
    }

    public void push(HistoryAction action) {
        stack.push(action);
    }

    public HistoryAction pop() {
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}