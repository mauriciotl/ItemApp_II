package entities.user;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table (name="t_ErpUser")
public class ErpUser  extends UserX implements Serializable {
    

// ===================================== 
// = Attributes                        = 
// ===================================== 
    
    private static final long serialVersionUID = 1L;
    
    //Este generalmente será el mail de la compañia,
    //por ello se tiene este mismo campo en WebUser
    private String eMail;

   
// ===================================== 
// = Constructor(s)                    = 
// ===================================== 
    
     public ErpUser() {
    }

    public ErpUser(String name, String lastName, String eMail) {
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
