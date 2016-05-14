package interfaces.implement;

import entities.item.MediaItem;
import entities.item.Song;
import interfaces.RegisterPlayBehavior;
import java.io.Serializable;


public class RegisterPlayWeb implements Serializable, RegisterPlayBehavior  {

    

// ===================================== 
// = Attributes                        = 
// ===================================== 

    //Se esta utilizando un MediaItem para que pueda ser utilizado
    //por todsas sus subclases
    /*
    El uso de esta variable de instancia es opcional,
    en este caso nos podría servir para saber que objeto solicita esta funcionalidad,
    esto claro si el objeto enviado es el mismo que llama ha esta funcionalidad.
    CREO QUE ES UNA BIZARRES pero en algún momento podría funcionar, creo : ) 
    */
    private MediaItem mediaItem;
    
    
// ===================================== 
// = Constructor(s)                    = 
// ===================================== 


    public RegisterPlayWeb(MediaItem mediaItem) {
        this.mediaItem = mediaItem;
    }
    
    
    //Aqui esta el constructor para que pueda ser utilizado
    //por un Song
    public RegisterPlayWeb(Song song) {
        this.mediaItem = song;
    }
    
    
// =====================================
// = getters / setters                 =
// =====================================

    public MediaItem getMediaItem() {
        return mediaItem;
    }

    public void setMediaItem(MediaItem mediaItem) {
        this.mediaItem = mediaItem;
    }
    
// =====================================
// = Implemented methods               =
// =====================================
    @Override
    public void registerPlay() {
        System.out.println("**********  MTL Comment: This is a register in a WEB PLAY action **********");
        System.out.println("**********  MTL Comment. The MediaItem id is: " + this.mediaItem.getId());
        
        //Esto solo es posible si se utiliza el constructor 
        //que recibe un song, sino se producirá error
        Song song = (Song) this.mediaItem;
        System.out.println("**********  MTL Comment. The name of the song is: " + song.getName());
    }
    
    
    

}//RegisterPlayWeb
