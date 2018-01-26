package com.test.Models;

import javax.persistence.*;

@Entity
@Table(name = "dreams", schema = "dreamloudPROD", catalog = "")
public class DreamsEntity {
    private int drmId;
    private String drmName;
    private String drmBio;

    @Id
    @Column(name = "DRM_ID", nullable = false)
    public int getDrmId() {
        return drmId;
    }

    public void setDrmId(int drmId) {
        this.drmId = drmId;
    }

    @Basic
    @Column(name = "DRM_NAME", nullable = false, length = 40)
    public String getDrmName() {
        return drmName;
    }

    public void setDrmName(String drmName) {
        this.drmName = drmName;
    }

    @Basic
    @Column(name = "DRM_BIO", nullable = false, length = 500)
    public String getDrmBio() {
        return drmBio;
    }

    public void setDrmBio(String drmBio) {
        this.drmBio = drmBio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DreamsEntity that = (DreamsEntity) o;

        if (drmId != that.drmId) return false;
        if (drmName != null ? !drmName.equals(that.drmName) : that.drmName != null) return false;
        if (drmBio != null ? !drmBio.equals(that.drmBio) : that.drmBio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = drmId;
        result = 31 * result + (drmName != null ? drmName.hashCode() : 0);
        result = 31 * result + (drmBio != null ? drmBio.hashCode() : 0);
        return result;
    }
}
