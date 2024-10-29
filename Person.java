import java.io.Serializable;

public class Person implements Serializable {

  private String firstName;
  private String lastName;
  private int age;

  public Person(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  public String toString() {
    return firstName + " " + lastName + " " + age;
  }
}
