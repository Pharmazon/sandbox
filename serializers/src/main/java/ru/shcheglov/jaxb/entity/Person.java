package ru.shcheglov.jaxb.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 22.01.2019
 */


@XmlRootElement(name = "person")
@XmlType(propOrder = {"name", "age" , "friends"})
public class Person {

    private String name;

    private Integer age;

    private List<Person> friends;

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(final String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    @XmlElement
    public void setAge(final Integer age) {
        this.age = age;
    }

    public List<Person> getFriends() {
        return friends;
    }

    @XmlElement(name = "friend")
    @XmlElementWrapper
    public void setFriends(final List<Person> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        final String str = "Person{" +
                "name='" + name + '\'' +
                ", age=" + age + ", friends{";
        final StringBuilder sb = new StringBuilder(str);
        if (friends != null)
            for (Person p : friends) {
                sb.append(p.toString());
                sb.append(", ");
            }
        sb.append("}}");
        return sb.toString();
    }
}
