package entities.user;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="t_userX")
public abstract class UserX implements Serializable {
    
// ===================================== 
// = Attributes                        = 
// ===================================== 

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    private String lastName;

   
            
// ===================================== 
// = Constructor(s)                    = 
// ===================================== 
    
     public UserX() {
    }

    public UserX(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
    
    
    
// ===================================== 
// = implemented methods                     = 
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
        if (!(object instanceof UserX)) {
            return false;
        }
        UserX other = (UserX) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.user.User[ id=" + id + " ]";
    }

    
    
}//User
