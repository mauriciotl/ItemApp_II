package entities.item;

import entities.mediaFile.MediaFile;
import entities.priceTag.PriceTag;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table (name="t_item")

@NamedQueries({ 
    @NamedQuery(
        name="findAllItems",
        query="select b from Item b order by b.id"
    ),
    //Other Query
    }
)

public abstract class Item implements Serializable {
    
    
// ===================================== 
// = Attributes                        = 
// ===================================== 

    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    private String description;
    
    //Unidirectional to PriceTag
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private List<PriceTag> priceTags;
    
    //Unidirectional to MediaFile
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private List<MediaFile> mediaFiles;

    
// ===================================== 
// = Constructor(s)                    = 
// ===================================== 

    public Item() {
    }
    
    

    public Item(String name, String description, List<PriceTag> priceTags, List<MediaFile> mediaFiles) {
        this.name = name;
        this.description = description;
        this.priceTags = priceTags;
        this.mediaFiles = mediaFiles;
    }
    
// =====================================
// = getters / setters =
// =====================================

    public Long getId() {
        return id;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PriceTag> getPriceTags() {
        return priceTags;
    }

    public void setPriceTags(List<PriceTag> priceTags) {
        this.priceTags = priceTags;
    }

    public List<MediaFile> getMediaFiles() {
        return mediaFiles;
    }


    public void setMediaFiles(List<MediaFile> mediaFiles) {
        this.mediaFiles = mediaFiles;
    }

// =====================================
// = other methods                     =
// =====================================
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.abstractClasses.Item[ id=" + id + " ]";
    }



    

}//Item
