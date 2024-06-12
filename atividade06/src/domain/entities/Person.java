package domain.entities;

import domain.exceptions.InvalidAgeException;
import domain.exceptions.InvalidEmailException;

import java.util.UUID;

public class Person {
    private String email;
    private Integer age;

    public Person(String email, Integer age) {
        setEmail(email);
        setAge(age);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!(email.length() > 10 && email.contains("@"))) {
            throw new InvalidEmailException();
        }

        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if (age < 0 || age > 110) {
            throw new InvalidAgeException();
        }

        this.age = age;
    }
}
