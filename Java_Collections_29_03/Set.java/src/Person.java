public class Person {
    
    private String name;
    private String surname;
    private int age;

    public Person(String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String print(){
        return this.name + " " + this.surname + " " + Integer.toString(age);

    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Person){
            //cast di object in Person
            Person other = (Person) obj;
            return (name == other.name && surname == other.surname && age == other.age);
        } else{

            return false;
        }

    }

    @Override
    public int hashCode(){
        return (name == null ? 0 : name.hashCode()) + (surname == null ? 0 : surname.hashCode()) + age;
        // return Integer.parseInt(name) + Integer.parseInt(surname) + age;
    }
}

