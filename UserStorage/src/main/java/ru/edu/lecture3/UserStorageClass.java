package ru.edu.lecture3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.time.LocalDate;

public class UserStorageClass implements UserStorage{

    private HashMap<String, User> maleStorage = new HashMap<>();
    private HashMap<String, User> femaleStorage = new HashMap<>();

    @Override
    public User getUserByLogin(String login){
        if (login == null || login.isEmpty() || login.isBlank()) {
            throw new IllegalArgumentException("incorrect login");
        }

        login = login.toLowerCase();

        if(maleStorage.containsKey(login)) {
            return maleStorage.get(login);
        } else if(femaleStorage.containsKey(login)) {
            return femaleStorage.get(login);
        } else {
            throw new RuntimeException("user not found");
        }
    }

    @Override
    public User put(User user) {

        if (user.getBirthDate() == null || user.getBirthDate().isAfter(LocalDate.now())) {
            throw new RuntimeException("incorrect birthdate");
        } else if (user.getLogin() == null || user.getLogin().isEmpty() || user.getLogin().isBlank()){
            throw new RuntimeException("incorrect login");
        } else if (maleStorage.containsKey(user.getLogin()) || femaleStorage.containsKey(user.getLogin())) {
            throw new RuntimeException("login already exists");
        } else if(user.getFirstName() == null || user.getFirstName().isEmpty() || user.getFirstName().isBlank()){
            throw new RuntimeException("incorrect first name");
        } else if(user.getLastName() == null || user.getLastName().isEmpty() || user.getLastName().isBlank()){
            throw new RuntimeException("incorrect last name");
        } else if (user.getGender() == null){
            throw new RuntimeException("incorrect gender");
        }

        if(user.getGender() == Gender.MALE){
            maleStorage.put(user.getLogin().toLowerCase(), user);
        } else {
            femaleStorage.put(user.getLogin().toLowerCase(), user);
        }
        return user;
    }

    @Override
    public User remove(String login){
        if(login == null || login.isEmpty() || login.isBlank()){
        throw new IllegalArgumentException("login is null/empty/blank");
        }

        login = login.toLowerCase();
        if(maleStorage.containsKey(login)) {
            return maleStorage.remove(login);
        } else if(femaleStorage.containsKey(login)) {
            return femaleStorage.remove(login);
        } else {
            throw new RuntimeException("user not found");
        }
    }

    @Override
    public List<User> getAllUsers(){
        List<User> listOfUsers = new ArrayList<>();
        listOfUsers.addAll(maleStorage.values());
        listOfUsers.addAll(femaleStorage.values());
        return listOfUsers;
    }

    @Override
    public List<User> getAllUsersByGender(Gender gender){
        List<User> list;
        if(gender == Gender.MALE){
            list = new ArrayList<>(maleStorage.values());
            return list;
        } else if (gender == Gender.FEMALE) {
            list = new ArrayList<>(femaleStorage.values());
            return list;
        } else throw new IllegalArgumentException("incorrect gender");
    }

    @Override
    public int getUserAge(String login){

        if (login == null || login.isEmpty() || login.isBlank()) {
            throw new IllegalArgumentException("incorrect login");
        }

        login = login.toLowerCase();
        User user;
        if(maleStorage.containsKey(login)) {
            user = maleStorage.get(login);
        } else if(femaleStorage.containsKey(login)) {
            user = femaleStorage.get(login);
        } else {
            throw new RuntimeException("user not found");
        }
        int userAge;
        LocalDate birthDate = user.getBirthDate();
        LocalDate today = LocalDate.now();
        if(today.getDayOfMonth() > birthDate.getDayOfMonth() && today.getMonthValue() >= birthDate.getMonthValue()){
            userAge = today.getYear() - birthDate.getYear();
        } else if(today.getYear() - birthDate.getYear() == 0){
            userAge = 0;
        } else {
            userAge = today.getYear() - birthDate.getYear() - 1;
        }
        return userAge;
    }
}
