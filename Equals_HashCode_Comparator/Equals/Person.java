package HW_L5_T2_Equals;

import java.util.Objects;

public class Person {
    private String name;
    private String city;
    private int age;
    public Person(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public String getCity() {
        return city;
    }
    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        Person person = (Person) o;

        if(city == null || name == null || person.name == null || person.city == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        return age == person.age && name.equalsIgnoreCase(person.name) && city.equalsIgnoreCase(person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city, age);
    }

    @Override
    public String toString() {
        return name + " lives in " + city + " " + age + "y.o.";
    }
}
