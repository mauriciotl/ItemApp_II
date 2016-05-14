package ejbs;

import entities.item.Item;
import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Singleton
public class ItemAppDisplayImp implements ItemAppDisplay {
    
    
    
// ===================================== 
// = Attributes = 
// ===================================== 

    @PersistenceContext
    EntityManager em;
    
    
    
    
//===================================== 
// = CRUD Item = 
// ===================================== 
    
    //Read Item ********************************************************
    
    @Override
    public List<Item> getAllItems(){
        
        Query query = em.createNamedQuery("findAllItems");
        
        return query.getResultList();
    }
    
    
    
    

        

}
