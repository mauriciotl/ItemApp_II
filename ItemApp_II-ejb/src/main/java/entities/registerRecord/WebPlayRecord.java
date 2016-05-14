package entities.registerRecord;

import entities.item.MediaItem;
import entities.user.WebUser;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_webPlayRecord")
public class WebPlayRecord extends RegisterRecord implements Serializable {

// ===================================== 
// = Attributes                        = 
// ===================================== 
    private static final long serialVersionUID = 1L;

    @OneToOne(cascade={CascadeType.PERSIST, CascadeType.REFRESH})
    private WebUser webUser;

    //Following is an abstract class
    //The objetive is to be able to use Song, Movie, or any other
    //MediaItem sub class
    @OneToOne(cascade={CascadeType.PERSIST, CascadeType.REFRESH})
    private MediaItem mediaItem;

// ===================================== 
// = Constructor(s)                    = 
// ===================================== 
    
    
    public WebPlayRecord() {
    }


    public WebPlayRecord(WebUser webUser, MediaItem mediaItem, Date date) {
        super(date);
        this.webUser = webUser;
        this.mediaItem = mediaItem;
    }
    
    
// ===================================== 
// = getters / setters                 = 
// ===================================== 
    
    
    public WebUser getWebUser() {
        return webUser;
    }

    public void setWebUser(WebUser webUser) {
        this.webUser = webUser;
    }

    public MediaItem getMediaItem() {
        return mediaItem;
    }

    public void setMediaItem(MediaItem mediaItem) {
        this.mediaItem = mediaItem;
    }
    
    
    
// ===================================== 
// = other methods                     = 
// ===================================== 

    
    
    
}//WebPlayRecord
