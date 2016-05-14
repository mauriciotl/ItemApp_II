package entities.author;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="t_author")
public abstract class Author implements Serializable {
    
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

    
// ===================================== 
// = getters / setters = 
// ===================================== 

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
// ===================================== 
// = implemeted methods = 
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
        if (!(object instanceof Author)) {
            return false;
        }
        Author other = (Author) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.genre.Author[ id=" + id + " ]";
    }
    
// ===================================== 
// = other methods                     = 
// ===================================== 
    

}//Author
