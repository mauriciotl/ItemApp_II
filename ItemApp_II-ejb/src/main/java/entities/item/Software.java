package entities.item;

import entities.mediaFile.MediaFile;
import entities.priceTag.PriceTag;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table (name="t_software")
public abstract class Software extends Item implements Serializable {
    
// ===================================== 
// = Attributes = 
// ===================================== 

    
    private static final long serialVersionUID = 1L;
    
    private String version;

   

    
// ===================================== 
// = Constructor = 
// ===================================== 
    
     public Software() {
    }

    public Software(String version, String name, String description, List<PriceTag> priceTags, List<MediaFile> mediaFiles) {
        super(name, description, priceTags, mediaFiles);
        this.version = version;
    }

    
    
// ===================================== 
// = g / s = 
// ===================================== 

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


    
    

}//Software
