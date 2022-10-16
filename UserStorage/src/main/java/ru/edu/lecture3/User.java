package ru.edu.lecture3;

import java.time.LocalDate;

/**
 * Contains user info.
 */
public class User {

    private String login;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Gender gender;

    public User(String login, String firstName, String lastName, LocalDate birthDate, Gender gender){
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setBirthDate(LocalDate birthDate){
        this.birthDate = birthDate;
    }

    public void setGender(Gender gender){
        this.gender = gender;
    }

    public String getLogin(){
        return login;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public LocalDate getBirthDate(){
        return birthDate;
    }

    public Gender getGender(){
        return gender;
    }

    @Override
    public String toString(){
        return "User with login " + login + " info:\n" +
                "first name: " + firstName +
                "\nlast name: " + lastName +
                "\nbirthday: " + birthDate.toString() +
                "\ngender: " + gender;
    }
}
