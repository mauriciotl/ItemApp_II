package entities.ArrayBytes;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="t_mediaBytes")
public class MediaBytes extends ArrayBytes implements Serializable {
    
    
// ===================================== 
// = Attributes = 
// ===================================== 

    
    private static final long serialVersionUID = 1L;
    
    private byte [] bytes;

   
    
    
// ===================================== 
// = Constructor(s)                    = 
// ===================================== 
    
    
     public MediaBytes() {
    }

    public MediaBytes(byte[] bytes) {
        this.bytes = bytes;
    }
  
    
    
// ===================================== 
// = getters / setters                 = 
// ===================================== 

    
    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
    
    
    
// ===================================== 
// = other methods                     = 
// ===================================== 


}//MediaBytes
