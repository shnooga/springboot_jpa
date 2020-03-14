package com.example.hellospringboot.jpa.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "billionaires")
@IdClass(BillionaireEntityPK.class)
public class BillionaireEntity {
    private int id;
    private String firstName;
    private String lastName;
    private String career;

    @Id
    @Column(name = "ID")
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @Basic
    @Column(name = "FIRST_NAME")
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    @Basic
    @Column(name = "LAST_NAME")
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    @Basic
    @Column(name = "CAREER")
    public String getCareer() { return career; }
    public void setCareer(String career) { this.career = career; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillionaireEntity that = (BillionaireEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(career, that.career);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, career);
    }
}
