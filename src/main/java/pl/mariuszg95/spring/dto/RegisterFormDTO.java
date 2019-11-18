package pl.mariuszg95.spring.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashMap;

public class RegisterFormDTO {

    @NotEmpty(message = "Pole nie może być puste!")
    @Size(min = 3, max = 20, message = "Długość powinna mieć od 3 do 20 znaków!")
    private String login;
    @Email(message = "Niepoprawny adres eMail!")
    @NotEmpty
    private String email;
    @Size(min = 3, max = 30, message = "Długość powinna mieć od 3 do 30 znaków!")
    private String firstName;
    @Size(min = 3, max = 30, message = "Długość powinna mieć od 3 do 30 znaków!")
    private String lastName;
    private Date birthDate;
    @NotEmpty(message = "Pole nie może być puste!")
    private String stringBirthDate;
    @NotEmpty(message = "Pole nie może być puste!")
    private String password;
    @NotEmpty(message = "Pole nie może być puste!")
    private String repeatedPassword;
    private HashMap<String, String> errors = new HashMap<>();

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        if (birthDate == null) {
            setBirthDate();
        }
        return birthDate;
    }

    public void setBirthDate() {
        this.birthDate = new Date(
                Integer.valueOf(stringBirthDate.substring(0, 2)),
                Integer.valueOf(stringBirthDate.substring(3, 5)),
                Integer.valueOf(stringBirthDate.substring(6, 10))
        );
    }

    public String getStringBirthDate() {
        return stringBirthDate;
    }

    public void setStringBirthDate(String stringBirthDate) {
        this.stringBirthDate = stringBirthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }
}
