package entities.genre;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table (name="t_musicGenre")
public class MusicGenre extends Genre implements Serializable {
    
// ===================================== 
// = Attributes = 
// ===================================== 
    
    private String genreName;
    private String genreDescription;

   
    
// ===================================== 
// = Constructor(s)                    = 
// ===================================== 
  
     public MusicGenre() {
    }
    
    
    public MusicGenre(String genreName, String genreDescription) {
        this.genreName = genreName;
        this.genreDescription = genreDescription;
    }
    
// ===================================== 
// = getters / setters                 = 
// ===================================== 

    
    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getGenreDescription() {
        return genreDescription;
    }

    public void setGenreDescription(String genreDescription) {
        this.genreDescription = genreDescription;
    }

    
// ===================================== 
// = other methods                     = 
// ===================================== 

    

}//MusicGenre
