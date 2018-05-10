package com.test.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "meminterests", schema = "dreamloudPROD", catalog = "")
public class MeminterestsEntity {
    private int intrAcctId;

    @Id
    @Column(name = "INTR_ACCT_ID", nullable = false)
    public int getIntrAcctId() {
        return intrAcctId;
    }

    public void setIntrAcctId(int intrAcctId) {
        this.intrAcctId = intrAcctId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MeminterestsEntity that = (MeminterestsEntity) o;

        if (intrAcctId != that.intrAcctId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return intrAcctId;
    }
}
