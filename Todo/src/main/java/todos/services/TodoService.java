package todos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todos.domain.Todo;
import todos.repositories.TodoRepository;

@Service
public class TodoService 
{
	/*
	 * I understand something now. Instead of injecting repository into controller. 
	 * we are injecting repository inside service and service inside controller.
	 * we have one service & one repository per entity
	 */
	private TodoRepository todoRepository;
	
	@Autowired
	public TodoService(TodoRepository todoRepository)
	{
		this.todoRepository =  todoRepository;
	}
	
	public void save(Todo todo) 
	{
		todoRepository.save(todo);
	}
	
	public Iterable<Todo> findAll()
	{
		Iterable<Todo> todos = todoRepository.findAll();
		return todos;
	}
	
	public Todo getTodoById(Long TodoId)
	{
		Todo todo = todoRepository.findById(TodoId).orElseThrow(RuntimeException::new);
		return todo;
	}
}
