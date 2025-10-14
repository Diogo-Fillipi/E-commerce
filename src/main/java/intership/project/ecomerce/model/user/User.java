package intership.project.ecomerce.model.user;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class User {

    private long id;
    private String name;
    private String email;
    private String password;
    private UserType userType;

}
