package com.example.integradora.service;
import org.springframework.stereotype.Service;

import com.example.integradora.dto.UserRequest;
import com.example.integradora.model.User;
import com.example.integradora.structures.Node;
import com.example.integradora.structures.SinglyLinkedList;

@Service
public class UserService {

    private SinglyLinkedList<User> userList = new SinglyLinkedList<>();

    public String addUser(UserRequest request) {
        User newUser = new User(request.getId(), request.getName());
        userList.add(newUser);
        return "Usuario registrado  correctamente: " + newUser.getName();
    }

   
    public User[] getAllUsers() {
        int count = 0;
        Node<User> temp = userList.head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        User[] users = new User[count];
        temp = userList.head;
        for (int i = 0; i < count; i++) {
            users[i] = temp.data;
            temp = temp.next;
        }
        return users;
    }

   
    public User getUserById(int id) {
        Node<User> temp = userList.head;
        while (temp != null) {
            if (temp.data.getId() == id) {
                return temp.data;
            }
            temp = temp.next;
        }
        return null; 
    }
    
}
