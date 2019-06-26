package todos.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import todos.domain.Todo;
import todos.services.TodoService;

@Controller
@RequestMapping("/steps")
public class UpdateTodoController
{
	private TodoService todoService;
	
	@Autowired 
	public UpdateTodoController (TodoService todoService)
	{
		this.todoService = todoService;
	}
	
	@ModelAttribute(name="todos")
	public Iterable<Todo> todobunch()
	{
		return todoService.findAll();
	}
	
	@ModelAttribute(name="todo")
	public Todo todo()
	{
		return new Todo();
	}
	@GetMapping("/intermediate")
	public String showIntermediateForm(Todo todo)
	{
		return "Intermediate"; //get mapping is not called. If we do redirect ,get mapping is called, I think so
	}
	
	@GetMapping("/update")
	public String showUpdateForm(Todo todo,Model model)
	{
		todo = todoService.getTodoById(todo.getId());
		model.addAttribute(todo); // Why not working without it?
		return "Update";
	}
	@PostMapping("/update")
	public String postUpdateForm(Todo todo)
	{
		todoService.save(todo);
		return "info";//redirect
	}
	
}
