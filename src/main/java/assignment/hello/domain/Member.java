package assignment.hello.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Member {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "MEMBER_NAME")
    private String name;
    @Column(name = "MEMBER_AGE")
    private Integer age;
    @Column(name = "MEMBER_ADDRESS")
    private String address;

    public Member(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public Member(){}
}
