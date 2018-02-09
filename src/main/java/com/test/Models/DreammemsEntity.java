package com.test.Models;

import javax.persistence.*;

/**
 * Created by Aaron on 2/9/2018.
 */
@Entity
@Table(name = "dreammems", schema = "dreamloudPROD", catalog = "")
public class DreammemsEntity {
    private byte drmmemIsAdmin;
    private int drmMemId;
    private int drmId;
    private int acctId;

    public int getAcctId() {
        return acctId;
    }

    public void setAcctId(int acctId) {
        this.acctId = acctId;
    }

    public int getDrmId() {
        return drmId;
    }

    public void setDrmId(int drmId) {
        this.drmId = drmId;
    }

    @Basic
    @Column(name = "DRMMEM_IS_ADMIN", nullable = false)
    public byte getDrmmemIsAdmin() {
        return drmmemIsAdmin;
    }

    public void setDrmmemIsAdmin(byte drmmemIsAdmin) {
        this.drmmemIsAdmin = drmmemIsAdmin;
    }

    @Id
    @Column(name = "DRM_MEM_ID", nullable = false)
    public int getDrmMemId() {
        return drmMemId;
    }

    public void setDrmMemId(int drmMemId) {
        this.drmMemId = drmMemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DreammemsEntity that = (DreammemsEntity) o;

        if (drmmemIsAdmin != that.drmmemIsAdmin) return false;
        if (drmMemId != that.drmMemId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) drmmemIsAdmin;
        result = 31 * result + drmMemId;
        return result;
    }
}
