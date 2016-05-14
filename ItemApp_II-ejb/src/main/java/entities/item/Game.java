package entities.item;

import entities.mediaFile.MediaFile;
import entities.priceTag.PriceTag;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_game")
public class Game extends Software implements Serializable {

// ===================================== 
// = Attributes                        = 
// =====================================
    
    public enum PlatformType { PSP, WII, PC, WIN, MAC, ANDROID }

    
    
    private static final long serialVersionUID = 1L;

    private PlatformType platformType;

  


// ===================================== 
// = Constructor(s)                    = 
// ===================================== 
    
      public Game() {
    }
      
    public Game(PlatformType platformType, String version, String name, String description, List<PriceTag> priceTags, List<MediaFile> mediaFiles) {
        super(version, name, description, priceTags, mediaFiles);
        this.platformType = platformType;
    }

// ===================================== 
// = getters / setters                 = 
// ===================================== 
    public PlatformType getPlatformType() {
        return platformType;
    }

    public void setPlatformType(PlatformType platformType) {
        this.platformType = platformType;
    }

// ===================================== 
// = other methods                     = 
// ===================================== 
}//Game
