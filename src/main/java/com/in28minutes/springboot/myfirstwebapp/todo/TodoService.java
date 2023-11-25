package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	static {
		todos.add(new Todo(1, "in29Minutes", "Learn AWS", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(2, "in29Minutes", "Learn devops", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(3, "in29Minutes", "Learn full stack development", LocalDate.now().plusYears(3), false));
	}

	public List<Todo> findByUsername(String username) {
		// todo
		return todos;
	}

}
