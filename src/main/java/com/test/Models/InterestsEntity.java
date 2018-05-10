package com.test.Models;

import javax.persistence.*;

@Entity
@Table(name = "interests", schema = "dreamloudPROD", catalog = "")
public class InterestsEntity {
    private int intrId;
    private String intrName;

    @Id
    @Column(name = "INTR_ID", nullable = false)
    public int getIntrId() {
        return intrId;
    }

    public void setIntrId(int intrId) {
        this.intrId = intrId;
    }

    @Basic
    @Column(name = "INTR_NAME", nullable = false, length = 40)
    public String getIntrName() {
        return intrName;
    }

    public void setIntrName(String intrName) {
        this.intrName = intrName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InterestsEntity that = (InterestsEntity) o;

        if (intrId != that.intrId) return false;
        if (intrName != null ? !intrName.equals(that.intrName) : that.intrName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = intrId;
        result = 31 * result + (intrName != null ? intrName.hashCode() : 0);
        return result;
    }
}
