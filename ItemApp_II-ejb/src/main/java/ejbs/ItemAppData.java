/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entities.ArrayBytes.MediaBytes;
import entities.item.Game;
import entities.item.Song;
import entities.author.Artist;
import entities.genre.MusicGenre;
import entities.mediaFile.MediaFile;
import entities.priceTag.PriceTag;
import entities.priceTag.PriceTag.StatusPrice;
import entities.registerRecord.WebPlayRecord;
import entities.status.MediaStatus;
import entities.user.ErpUser;
import entities.user.WebUser;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Singleton
@Startup //To start activity at deployment time
public class ItemAppData {

// ===================================== 
// = Attributes = 
// ===================================== 
    //Se inyecta la configuración de la persistencia
    @PersistenceContext
    private EntityManager em;

    //Creates and ErpUser
    private ErpUser erpUser;

// ===================================== 
// = @PostConstruct Methods (on Deploy time) = 
// ===================================== 
    @PostConstruct

    public void persistData() {

        //Persist songs
        List<Song> songs = this.getInitialSongs();
        for (Song song : songs) {
            em.persist(song);

            //Aqui utilizamos el metodo de registerPlayWeb
            //No es que se deba de utilizar cuando se persiste un song,
            //aqui solo se demuestra su funcionamiento.
            //De hecho este modulo esta disponible y ready to go, pero no lo uso
            song.performRegisterPlayBehavior();

        }

        //Persist games
        List<Game> games = this.getGames();
        for (Game game : games) {
            em.persist(game);
        }

        //Persist WebPlayRecord 10 registers
        for (WebPlayRecord wpRecord : this.registerSomeRecords()) {
            em.persist(wpRecord);
        }

    }

// ===================================== 
// = Other methods = 
// ===================================== 
    //Create some Artists, Songs and return them
    private List<Song> getInitialSongs() {

        //Creates some music genres
        MusicGenre musicGenreRock = new MusicGenre("Rock", "4/4 notation, loudy and powerfull");
        MusicGenre musicGenrePop = new MusicGenre("Pop", "The music every one likes at least one song");
        MusicGenre musicGenreElec = new MusicGenre("Electronic", "About high tech music");
        MusicGenre musicGenreClassical = new MusicGenre("Classical", "The highest slavon in music, just for lions");

        List<MusicGenre> musicGenres = new ArrayList<>();

        musicGenres.add(musicGenreRock);
        musicGenres.add(musicGenrePop);

        //Creates artist
        Artist artist = new Artist();
        artist.setArtistName("Soda Stereo 04");
        artist.setSongs(null); //Artists without songs **********************************  1A Artist has-a Items/songs

        //Creates list and artist
        List<Artist> artists = new ArrayList<>();
        artists.add(artist);

        //Creates and ErpUser
        erpUser = new ErpUser("Mauricio", "Torres", "mauriciotl77@mauriciotl.com");

        //Creates PriceTag
        Date date = new Date();

        PriceTag pricetag = new PriceTag();
        pricetag.setDate(date);
        pricetag.setErpUser(erpUser);
        pricetag.setPrice(23.99);
        pricetag.setStatusPrice(StatusPrice.CURRENT);

        //Creates MediaStatus available in that class
        MediaStatus mediaStatus = new MediaStatus();
        //Se guardan como números del enum (el enum comienza de cero)
        mediaStatus.setStatusControl(MediaStatus.StatusControl.ACTIVE);
        mediaStatus.setStatusProceso(MediaStatus.StatusProceso.MAIN);

        //Creates MediaBytes
        byte[] bytes = null;
        MediaBytes mediaBytes = new MediaBytes(bytes);

        //Creates MediaFile list
        List<MediaFile> mediafiles = new ArrayList<>();

        MediaFile mediaFile = new MediaFile();
        mediaFile.setMediaBytes(mediaBytes);
        mediaFile.setMediaStatus(mediaStatus);
        mediaFile.setTypeMediaFile(MediaFile.TypeMediaFile.IMAGE);

        mediafiles.add(mediaFile);

        //Creates some songs (just one in this case)
        Song song = new Song();


        //Creates list PriceTag
        List<PriceTag> priceTags = new ArrayList<>();
        priceTags.add(pricetag);

        song.setArtists(artists); // Item/Song has-a Artist  ****************** 1A

        song.setDescription("Imagenes retrogadas IV, from homonim album. Year 1984");
        song.setMediaFiles(mediafiles);
        song.setMusicGenres(musicGenres);
        song.setName("Imagenes retro");
        song.setPriceTags(priceTags);  

        List<Song> songs = new ArrayList<>();

        artist.setSongs(songs); //Artists with songs **********************************  1A Artist has-a Items/songs

        songs.add(song);

        return songs;
    }

    //Create some games, return list of games
    private List<Game> getGames() {

        //Creates priceTag
        Date date = new Date();
        PriceTag pricetag = new PriceTag();
        pricetag.setDate(date);
        pricetag.setErpUser(erpUser);
        pricetag.setPrice(22.15);
        pricetag.setStatusPrice(StatusPrice.CURRENT);

        //Creates list PriceTag
        List<PriceTag> priceTags = new ArrayList<>();
        priceTags.add(pricetag);

        Game game = new Game();
        game.setVersion("1_A01");
        game.setDescription("A game of action in the outskirts");
        game.setMediaFiles(null);
        game.setName("Centempide");
        game.setPlatformType(Game.PlatformType.PSP);
        game.setPriceTags(priceTags);  

        List<Game> games = new ArrayList<>();
        games.add(game);

        return games;
    }

    //Simulates some webRecords 
    private List<WebPlayRecord> registerSomeRecords() {

        //creates webUser
        WebUser webUser = new WebUser("Alfredo", "Rosas", "alfro@gmail.com");

        //Retrives a song
        Query query = em.createNamedQuery("findAllSongs");
        List<Song> songs = query.getResultList();

        String songRequested = "Imagenes retro";

        Song songFounded = null;

        for (Song song : songs) {
            if (song.getName().equalsIgnoreCase(songRequested)) {
                songFounded = song;
            }
        }

        Date date;

        //Creates webPlayrecord s
        List<WebPlayRecord> WebPlayRecords = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            WebPlayRecord wpRecord = new WebPlayRecord(webUser, songFounded, date = new Date());
            WebPlayRecords.add(wpRecord);
        }

        return WebPlayRecords;

    }

}
