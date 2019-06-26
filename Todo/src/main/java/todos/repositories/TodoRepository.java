package todos.repositories;

import org.springframework.data.repository.CrudRepository;

import todos.domain.Todo;

//@Repository
public interface TodoRepository extends CrudRepository<Todo , Long>
{

}
