package entities.user;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table (name="t_webUser")
public class WebUser  extends UserX implements Serializable {
    

// ===================================== 
// = Attributes                        = 
// ===================================== 
    
    private static final long serialVersionUID = 1L;
    
    private String eMail;

   
// ===================================== 
// = Constructor(s)                    = 
// ===================================== 
    
     public WebUser() {
    }

    

    public WebUser(String name, String lastName, String eMail) {
        super(name, lastName);
        this.eMail = eMail;
    }

// ===================================== 
// = getters / setters                 = 
// ===================================== 

      public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    
    
    
// ===================================== 
// = other methods                     = 
// ===================================== 

  
    

}//WebUser
