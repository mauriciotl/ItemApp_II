package entities.mediaFile;

import entities.ArrayBytes.MediaBytes;
import entities.status.MediaStatus;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table (name="t_mediaFile")
public class MediaFile  implements Serializable {
    
// ===================================== 
// = Attributes = 
// ===================================== 

    
    public enum TypeMediaFile {AUDIO, VIDEO, IMAGE};
    
    
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private TypeMediaFile typeMediaFile;
    
    //Unidirectional to MediaStatus
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private MediaStatus mediaStatus;
    
     //Unidirectional to MediaBytes
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private MediaBytes mediaBytes;
    
    
    
// ===================================== 
// = Constructors = 
// ===================================== 

    public MediaFile() {
    }

    public MediaFile(TypeMediaFile typeMediaFile, MediaStatus mediaStatus, MediaBytes mediaBytes) {
        this.typeMediaFile = typeMediaFile;
        this.mediaStatus = mediaStatus;
        this.mediaBytes = mediaBytes;
    }
    
// ===================================== 
// = getters / setters = 
// ===================================== 

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeMediaFile getTypeMediaFile() {
        return typeMediaFile;
    }

    public void setTypeMediaFile(TypeMediaFile typeMediaFile) {
        this.typeMediaFile = typeMediaFile;
    }

    public MediaStatus getMediaStatus() {
        return mediaStatus;
    }

    public void setMediaStatus(MediaStatus mediaStatus) {
        this.mediaStatus = mediaStatus;
    }

    public MediaBytes getMediaBytes() {
        return mediaBytes;
    }

    public void setMediaBytes(MediaBytes mediaBytes) {
        this.mediaBytes = mediaBytes;
    }


// ===================================== 
// = other methods                     = 
// ===================================== 


}//Media
