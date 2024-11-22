package sg.edu.nus.iss.vttp5a_day5l.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Person {

    // put in the necessary validations
    @NotNull(message = "id must be auto generated")
    private Integer id;

    @NotEmpty(message = "Name is mandatory")
    private String name;

    @Email(message = "Email input does not conform to email format")
    private String email;

    public Person(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", email=" + email + "]";
    }
    
}
