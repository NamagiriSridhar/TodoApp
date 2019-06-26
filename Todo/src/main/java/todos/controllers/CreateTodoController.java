package todos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import todos.domain.Todo;
import todos.services.TodoService;

@Controller
@RequestMapping("/create")
public class CreateTodoController 
{
	
	private TodoService todoService;
	
	@Autowired //wouldn't work without this!!
	public CreateTodoController (TodoService todoService)
	{
		this.todoService = todoService;
	}
	
	@ModelAttribute(name="todo")
	public Todo todo()
	{
		return new Todo();
	}
	
	@GetMapping
	public String showCreateForm()
	{
		return "Create";
	}
	
	@PostMapping
	public String postCreateForm(Todo todo)
	{
		todoService.save(todo);
		return "info";
	}
}
