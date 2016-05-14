package entities.genre;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="t_genre")
public abstract class Genre implements Serializable {
    
// ===================================== 
// = Attributes = 
// ===================================== 

    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
// ===================================== 
// = Constructors = 
// ===================================== 

    public Genre() {
    }
    


// ===================================== 
// = Getters / setters = 
// ===================================== 



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
 // ===================================== 
// = Implemented methods = 
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
        if (!(object instanceof Genre)) {
            return false;
        }
        Genre other = (Genre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.genre.Genre[ id=" + id + " ]";
    }
  
    
// ===================================== 
// = other methods                     = 
// ===================================== 
    

}//Genre
