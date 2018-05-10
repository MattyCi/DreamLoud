package com.test.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dreaminterests", schema = "dreamloudPROD", catalog = "")
public class DreaminterestsEntity {
    private int drmIntrId;

    @Id
    @Column(name = "DRM_INTR_ID", nullable = false)
    public int getDrmIntrId() {
        return drmIntrId;
    }

    public void setDrmIntrId(int drmIntrId) {
        this.drmIntrId = drmIntrId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DreaminterestsEntity that = (DreaminterestsEntity) o;

        if (drmIntrId != that.drmIntrId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return drmIntrId;
    }
}
