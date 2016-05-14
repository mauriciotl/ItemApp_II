package entities.item;

import entities.author.Artist;
import entities.genre.MusicGenre;
import entities.mediaFile.MediaFile;
import entities.priceTag.PriceTag;
import interfaces.implement.RegisterPlayWeb;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table (name="t_song")

@NamedQueries({
    @NamedQuery(
        name="findAllSongs",
        query="select s from Song s"),

        //add another query
})


public class Song  extends MediaItem implements Serializable {
    
    
// ===================================== 
// = Attributes                        = 
// ===================================== 

    
    private static final long serialVersionUID = 1L;
    
    
    //BIDIRECTIONAL to artist
    @ManyToMany( mappedBy = "songs" ,cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Artist> artists;
    
    //Unidirectional to MusicGenre
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private List<MusicGenre> musicGenres;
    
    
// ===================================== 
// = Constructor(s)                    = 
// ===================================== 


    public Song() {
        
        //Se elige algún tipo de RegisterPlayBehavior.
        //Esta es una funcionalidad que tiene este objeto,
        //la cual se esta consolidando en otro modulo
        //por si otros objetos utilizan esta funcionalidad
        //y en algún momento se desea cambiar, solo se cambiará 
        //en un solo punto
        registerPlayBehavior = new RegisterPlayWeb(this);
        
    }


    public Song(List<Artist> artists, List<MusicGenre> musicGenres, String name, String description, 
            List<PriceTag> priceTags, List<MediaFile> mediaFiles) {
        
        super(name, description, priceTags, mediaFiles);
        this.artists = artists;
        this.musicGenres = musicGenres;
        
        //Se elige algún tipo de RegisterPlayBehavior.
        registerPlayBehavior = new RegisterPlayWeb(this);
        
    }
    
    
// =====================================
// = getters / setters                 =
// =====================================
    
    public List<Artist> getArtists(){
        
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<MusicGenre> getMusicGenres() {
        return musicGenres;
    }

    public void setMusicGenres(List<MusicGenre> musicGenres) {    
        this.musicGenres = musicGenres;
    }


// =====================================
// = Implemented methods =
// =====================================


// =====================================
// = other methods                     =
// =====================================
    public boolean containsXAuthorName(String authorName) {
        for(Artist artist: artists){
            if(artist.getArtistName().toLowerCase().contains(authorName.toLowerCase())){
                return true;
            }
        }
        return false;
    }
    
    
}//Song
