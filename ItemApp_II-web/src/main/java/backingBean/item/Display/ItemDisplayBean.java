package backingBean.item.Display;

import ejbs.ItemAppDisplay;
import entities.item.Item;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

@Named(value = "itemDisplayBean")
@SessionScoped
public class ItemDisplayBean implements Serializable {

// ===================================== 
// = Attributes = 
// ===================================== 

    @EJB
    ItemAppDisplay itemAppDisplay;
    
    
// ===================================== 
// = Constructors = 
// ===================================== 

    
    
    public ItemDisplayBean() {
    }
    
    
    
// ===================================== 
// = g / s = 
// ===================================== 
    
    
    
// ===================================== 
// = Other methods = 
// ===================================== 

    
    public List<Item> getAllItems(){
        return this.itemAppDisplay.getAllItems();
    }
    
    
    public List<String> getAllItemsSubClasses(){
        
        List<String> itemsClass = new ArrayList<>();
        
        //Obtiene lista actualizada de items
        List<Item> items = this.getAllItems();
        
        for(Item item: items){
            String className = item.getClass().toString();
            itemsClass.add(className);
        }
        return itemsClass;
    }

}
