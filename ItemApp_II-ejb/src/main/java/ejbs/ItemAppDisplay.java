package ejbs;

import entities.item.Item;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface ItemAppDisplay {
    
    
    
//===================================== 
// = CRUD Item = 
// ===================================== 
    
    //Read Item ********************************************************

    public List<Item> getAllItems();
    
    
    
    
    
    
    
    
    
}//ItemAppDisplay
