package Final.Exam.Final.Exam.model.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "PERSON")
@NamedQueries({
    @NamedQuery(name = "kk.findAll", query ="SELECT b FROM kk b"),
    @NamedQuery(name = "kk.findById", query ="SELECT b FROM kk b WHERE b.id = :id"),
    @NamedQuery(name = "kk.findByNama", query = "SELECT b FROM kk b WHERE b.nama = :nama"),
    @NamedQuery(name = "kk.findBynik", query = "SELECT b FROM kk b WHERE b.nik = :nik"),
    @NamedQuery(name = "kk.findBytl", query = "SELECT b FROM kk b WHERE b.tl = :tl")
})


public class kk implements Serializable {
    
    private static final long serialVersionUID = 1L;
 
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nama")
    private String nama;
    @Column(name = "nik")
    private Integer nik;
    @Column(name = "tl")
    private Date tl;
    @Column(name = "pht")
    private Blob pht;

    public kk() {
    }

    public kk(Integer id) {
        this.id = id;
    }

    public kk(Integer id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getNIK() {
        return nik;
    }

    public void setnik(Integer nik) {
        this.nik = nik;
    }

    public String gettl(Date tl) {
        return tl.toString();
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof kk)) {
            return false;
        }
        kk other = (kk) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.Barang[ id=" + id + " ]";
    }
    
}

