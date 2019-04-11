package ca.sheridancollege.beans;

import java.io.Serializable;
import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedQuery(name="User.byUserFirstLastName",query="from User where firstName=:fname or lastName=:lname")
public class User implements Serializable {
	
	private String firstName;
	private String lastName;
	@Id
	private String phone;
	private String email;
	
	

}
