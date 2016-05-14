package entities.author;

import entities.item.Song;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="t_artist")
public class Artist extends Author implements Serializable {
    
// ===================================== 
// = Attributes = 
// ===================================== 

    private static final long serialVersionUID = 1L;
    
    private String artistName;
    
    //BIDIRECTIONAL to Song
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Song> songs;

   
    
    
// ===================================== 
// = Constructor = 
// ===================================== 
    
    
     public Artist() {
    }

    public Artist(String artistName, List<Song> songs) {
        this.artistName = artistName;
        this.songs = songs;
    }

    
// ===================================== 
// = getters / setters = 
// ===================================== 

    

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
    
     public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    
// ===================================== 
// = other methods                     = 
// ===================================== 

   

}//Artist
