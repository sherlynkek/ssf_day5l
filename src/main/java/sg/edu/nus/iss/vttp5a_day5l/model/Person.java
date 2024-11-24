package sg.edu.nus.iss.vttp5a_day5l.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Person {
    
    // Put in necessary validations
    @Min(value = 1, message = "Please enter your id!")
    private Integer id;

    @NotBlank(message = "Please enter your name!")
    @Size(min = 2, message = "Your name must be longer than 2 characters!")
    private String fullName;

    @NotBlank(message = "Please enter your email!")
    @Email(message = "Please enter a VALID email!")
    private String email;
    
    public Person(Integer id, String fullName, String email) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
    }

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return id + "," + fullName + "," + email;
    }

    
}