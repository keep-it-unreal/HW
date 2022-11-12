package HW_L5_T1_Comparators;

public class Person implements Comparable<Person> {
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
    public int compareTo(Person person) {

        if(this.getCity() == null || this.getName() == null || person.getName() == null || person.getCity() == null){
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        if(this.getCity().compareToIgnoreCase(person.getCity()) > 0){
            return 1;
        } else if (this.getCity().compareToIgnoreCase(person.getCity()) < 0) {
            return -1;
        } else {
            if(this.getName().compareToIgnoreCase(person.getName()) > 0){
                return 1;
            } else if (this.getName().compareToIgnoreCase(person.getName()) < 0) {
                return -1;
            } else {
                return 0;
            }
        }

    }

    @Override
    public String toString() {
        return name + " lives in " + city + " " + age + "y.o.";
    }

}
