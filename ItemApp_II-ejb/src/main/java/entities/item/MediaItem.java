package entities.item;

import entities.mediaFile.MediaFile;
import entities.priceTag.PriceTag;
import interfaces.RegisterPlayBehavior;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table (name="t_mediaItem")
public abstract class MediaItem extends Item implements Serializable {
    
// ===================================== 
// = Attributes                        = 
// ===================================== 
    
    private static final long serialVersionUID = 1L;
    
    //Este nombre se persiste para poder 
    //identificar este nivel de articulo en la db,
    //por lo que será el mismo para todos los articulos
    //de un nivel abajo que extiendan esta clase
//    private final String mediaItemName;
    
    
    
    //Esta anotación es para que no se persista en la DB.
    @Transient
    public RegisterPlayBehavior registerPlayBehavior;
    
// ===================================== 
// = Constructor(s)                    = 
// ===================================== 

    public MediaItem() {
    }

    public MediaItem(String name, String description, List<PriceTag> priceTags, List<MediaFile> mediaFiles) {
        super(name, description, priceTags, mediaFiles);
    }
    
    
// ===================================== 
// = getters / setters                 = 
// ===================================== 
    


    
// ===================================== 
// = Implemented methods = 
// ===================================== 

    


// ===================================== 
// = other methods                     = 
// ===================================== 
    

    public void performRegisterPlayBehavior(){
        
        registerPlayBehavior.registerPlay();
        
    }
    
    

}//MediaItem
