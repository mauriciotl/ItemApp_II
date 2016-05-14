package entities.registerRecord;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table (name = "t_registerRecord")
public abstract class RegisterRecord implements Serializable {
    
// ===================================== 
// = Attributes                        = 
// ===================================== 

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    
// ===================================== 
// = Constructor(s)                    = 
// ===================================== 

    public RegisterRecord() {
    }
    
    
    public RegisterRecord(Date date) {
        this.date = date;
    }
  
    
    
// ===================================== 
// = getters / setters                 = 
// ===================================== 

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
    
// ===================================== 
// = other methods                     = 
// ===================================== 
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegisterRecord)) {
            return false;
        }
        RegisterRecord other = (RegisterRecord) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.registerRecord.RegisterRecord[ id=" + id + " ]";
    }

    
    

}//RegisterRecord
