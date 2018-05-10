package com.test.Models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "dreamers", schema = "dreamloudPROD", catalog = "")
public class DreamersEntity {
    private int acctId;
    private int acctId2;
    private Timestamp drmrReqDatetime;
    private int acctAcctId;

    @Id
    @Column(name = "ACCT_ID", nullable = false)
    public int getAcctId() {
        return acctId;
    }

    public void setAcctId(int acctId) {
        this.acctId = acctId;
    }

    @Id
    @Column(name = "ACCT_ID_2", nullable = false)
    public int getAcctId2() {
        return acctId2;
    }

    public void setAcctId2(int acctId2) {
        this.acctId2 = acctId2;
    }

    @Basic
    @Column(name = "DRMR_REQ_DATETIME", nullable = false)
    public Timestamp getDrmrReqDatetime() {
        return drmrReqDatetime;
    }

    public void setDrmrReqDatetime(Timestamp drmrReqDatetime) {
        this.drmrReqDatetime = drmrReqDatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DreamersEntity that = (DreamersEntity) o;

        if (acctId != that.acctId) return false;
        if (acctId2 != that.acctId2) return false;
        if (drmrReqDatetime != null ? !drmrReqDatetime.equals(that.drmrReqDatetime) : that.drmrReqDatetime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = acctId;
        result = 31 * result + acctId2;
        result = 31 * result + (drmrReqDatetime != null ? drmrReqDatetime.hashCode() : 0);
        return result;
    }

    @Id
    @Column(name = "ACCT_ACCT_ID", nullable = false)
    public int getAcctAcctId() {
        return acctAcctId;
    }

    public void setAcctAcctId(int acctAcctId) {
        this.acctAcctId = acctAcctId;
    }
}
