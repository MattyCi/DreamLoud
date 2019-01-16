package com.test.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "account", schema = "dreamloudPROD", catalog = "")
@IdClass(AccountEntity.class)
public class AccountEntity implements Serializable {
    private int acctId;
    private String acctEmail;
    private String acctUsername;
    private String acctPw;
    private String acctFname;
    private String acctMi;
    private String acctLname;
    private Date acctDob;
    private Integer acctZip;
    private String acctCntry;
    private String acctPic;
    private String acctBio;
    private byte acctOnline;
    private byte acctFlgn;
    private String salt;

    @Id
    @Column(name = "ACCT_ID", nullable = false)
    public int getAcctId() {
        return acctId;
    }

    public void setAcctId(int acctId) {
        this.acctId = acctId;
    }

    @Basic
    @Column(name = "ACCT_EMAIL", nullable = false, length = 50)
    public String getAcctEmail() {
        return acctEmail;
    }

    public void setAcctEmail(String acctEmail) {
        this.acctEmail = acctEmail;
    }

    @Basic
    @Column(name = "ACCT_USERNAME", nullable = true, length = 30)
    public String getAcctUsername() {
        return acctUsername;
    }

    public void setAcctUsername(String acctUsername) {
        this.acctUsername = acctUsername;
    }

    @Basic
    @Column(name = "ACCT_PW", nullable = false, length = 16)
    public String getAcctPw() {
        return acctPw;
    }

    public void setAcctPw(String acctPw) {
        this.acctPw = acctPw;
    }

    @Basic
    @Column(name = "ACCT_FNAME", nullable = true, length = 25)
    public String getAcctFname() {
        return acctFname;
    }

    public void setAcctFname(String acctFname) {
        this.acctFname = acctFname;
    }

    @Basic
    @Column(name = "ACCT_MI", nullable = true, length = 1)
    public String getAcctMi() {
        return acctMi;
    }

    public void setAcctMi(String acctMi) {
        this.acctMi = acctMi;
    }

    @Basic
    @Column(name = "ACCT_LNAME", nullable = true, length = 30)
    public String getAcctLname() {
        return acctLname;
    }

    public void setAcctLname(String acctLname) {
        this.acctLname = acctLname;
    }

    @Basic
    @Column(name = "ACCT_DOB", nullable = true)
    public Date getAcctDob() {
        return acctDob;
    }

    public void setAcctDob(Date acctDob) {
        this.acctDob = acctDob;
    }

    @Basic
    @Column(name = "ACCT_ZIP", nullable = true)
    public Integer getAcctZip() {
        return acctZip;
    }

    public void setAcctZip(Integer acctZip) {
        this.acctZip = acctZip;
    }

    @Basic
    @Column(name = "ACCT_CNTRY", nullable = true, length = 45)
    public String getAcctCntry() {
        return acctCntry;
    }

    public void setAcctCntry(String acctCntry) {
        this.acctCntry = acctCntry;
    }

    @Basic
    @Column(name = "ACCT_PIC", nullable = true, length = 100)
    public String getAcctPic() {
        return acctPic;
    }

    public void setAcctPic(String acctPic) {
        this.acctPic = acctPic;
    }

    @Basic
    @Column(name = "ACCT_BIO", nullable = true, length = 250)
    public String getAcctBio() {
        return acctBio;
    }

    public void setAcctBio(String acctBio) {
        this.acctBio = acctBio;
    }

    @Basic
    @Column(name = "ACCT_ONLINE", nullable = false)
    public byte getAcctOnline() {
        return acctOnline;
    }

    public void setAcctOnline(byte acctOnline) {
        this.acctOnline = acctOnline;
    }

    @Basic
    @Column(name = "ACCT_FLGN", nullable = false)
    public byte getAcctFlgn() {
        return acctFlgn;
    }

    public void setAcctFlgn(byte acctFlgn) {
        this.acctFlgn = acctFlgn;
    }

    @Column(name = "SALT")
    public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountEntity that = (AccountEntity) o;

        if (acctId != that.acctId) return false;
        if (acctOnline != that.acctOnline) return false;
        if (acctFlgn != that.acctFlgn) return false;
        if (acctEmail != null ? !acctEmail.equals(that.acctEmail) : that.acctEmail != null) return false;
        if (acctUsername != null ? !acctUsername.equals(that.acctUsername) : that.acctUsername != null) return false;
        if (acctPw != null ? !acctPw.equals(that.acctPw) : that.acctPw != null) return false;
        if (acctFname != null ? !acctFname.equals(that.acctFname) : that.acctFname != null) return false;
        if (acctMi != null ? !acctMi.equals(that.acctMi) : that.acctMi != null) return false;
        if (acctLname != null ? !acctLname.equals(that.acctLname) : that.acctLname != null) return false;
        if (acctDob != null ? !acctDob.equals(that.acctDob) : that.acctDob != null) return false;
        if (acctZip != null ? !acctZip.equals(that.acctZip) : that.acctZip != null) return false;
        if (acctCntry != null ? !acctCntry.equals(that.acctCntry) : that.acctCntry != null) return false;
        if (acctPic != null ? !acctPic.equals(that.acctPic) : that.acctPic != null) return false;
        if (acctBio != null ? !acctBio.equals(that.acctBio) : that.acctBio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = acctId;
        result = 31 * result + (acctEmail != null ? acctEmail.hashCode() : 0);
        result = 31 * result + (acctUsername != null ? acctUsername.hashCode() : 0);
        result = 31 * result + (acctPw != null ? acctPw.hashCode() : 0);
        result = 31 * result + (acctFname != null ? acctFname.hashCode() : 0);
        result = 31 * result + (acctMi != null ? acctMi.hashCode() : 0);
        result = 31 * result + (acctLname != null ? acctLname.hashCode() : 0);
        result = 31 * result + (acctDob != null ? acctDob.hashCode() : 0);
        result = 31 * result + (acctZip != null ? acctZip.hashCode() : 0);
        result = 31 * result + (acctCntry != null ? acctCntry.hashCode() : 0);
        result = 31 * result + (acctPic != null ? acctPic.hashCode() : 0);
        result = 31 * result + (acctBio != null ? acctBio.hashCode() : 0);
        result = 31 * result + (int) acctOnline;
        result = 31 * result + (int) acctFlgn;
        return result;
    }
}
