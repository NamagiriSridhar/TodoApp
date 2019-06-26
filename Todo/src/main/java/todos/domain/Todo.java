package todos.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Entity
@Data
public class Todo 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String title;

	@Lob
	private String description;
	
	private String creator;
	
	private Status status;

	public static enum Status{
		NOT_STARTED, IN_PROGRESS, COMPLETED
	} 
	
}
