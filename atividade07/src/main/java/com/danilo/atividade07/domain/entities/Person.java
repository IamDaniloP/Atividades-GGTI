package com.danilo.atividade07.domain.entities;

import com.danilo.atividade07.domain.exceptions.InvalidAgeException;
import com.danilo.atividade07.domain.exceptions.InvalidEmailException;
import com.danilo.atividade07.domain.exceptions.InvalidNameException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
    private String fullName;
    private String email;
    private Integer age;

    public Person(String name, String lastName, String email, Integer age) {
        formatFullName(name, lastName);
        setEmail(email);
        setAge(age);
    }

    public String getFullName() {
        return fullName;
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
        if (age == null || age <= 17 || age >= 66) {
            throw new InvalidAgeException();
        }

        this.age = age;
    }

    private void formatFullName(String name, String lastName) {

        if (name.trim().isEmpty() || lastName.trim().isEmpty()) throw new InvalidNameException("Name or Last Name is empty!");

        String fullName = name.concat(" " + lastName);

        if (fullName.trim().length() < 3) throw new InvalidNameException("Invalid Name Exception!");

        if (fullNameWithNumber(fullName)) throw new InvalidNameException("Name or Last Name contains number!");

        String[] nameAndLastNameSeparate = fullName.toLowerCase().split(" ");
        for (int index = 0; index < nameAndLastNameSeparate.length; index++) {
            String nomeOuSobrenome = nameAndLastNameSeparate[index];

            if (!(nomeOuSobrenome.equalsIgnoreCase("da") ||
                    nomeOuSobrenome.equalsIgnoreCase("de") ||
                    nomeOuSobrenome.equalsIgnoreCase("do") ||
                    nomeOuSobrenome.equalsIgnoreCase("das") ||
                    nomeOuSobrenome.equalsIgnoreCase("dos")))
            {
                nameAndLastNameSeparate[index] = nomeOuSobrenome.replaceFirst(nomeOuSobrenome.substring(0,1), nomeOuSobrenome.substring(0,1).toUpperCase());
            }
        }

        this.fullName = String.join(" ", nameAndLastNameSeparate);
    }

    private boolean fullNameWithNumber(String fullName) {
        String regex = ".*\\d.*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fullName.trim());

        return matcher.matches();
    }
}
