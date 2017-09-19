package edu.eci.cosw.pancomido.service;

import edu.eci.cosw.pancomido.model.Todo;

import java.util.List;

public interface TodoService {

    List<Todo> getTodoList();

    Todo addTodo( Todo todo );
}
