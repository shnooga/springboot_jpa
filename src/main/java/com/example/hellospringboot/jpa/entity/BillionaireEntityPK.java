package com.example.hellospringboot.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class BillionaireEntityPK implements Serializable {
    private int id;

    @Id
    @Column(name = "ID")
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillionaireEntityPK that = (BillionaireEntityPK) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
