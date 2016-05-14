package entities.priceTag;

import entities.user.ErpUser;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table (name="t_priceTag")
@Entity
public class PriceTag implements Serializable {


// ===================================== 
// = Attributes                        = 
// ===================================== 

    public enum StatusPrice{CURRENT, ARCHIVED, ON_HOLD}
     
    private static final long serialVersionUID = 1L;
           
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    //It's an enum from this same class
    private StatusPrice statusPrice;
    
    //Unidirectional to ErpUser
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private ErpUser erpUser;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    
    private double price;
    

   
    
// ===================================== 
// = Constructor(s)                    = 
// ===================================== 
    
     public PriceTag() {
    }

    public PriceTag(StatusPrice statusPrice, ErpUser erpUser, Date date, double price) {
        this.statusPrice = statusPrice;
        this.erpUser = erpUser;
        this.date = date;
        this.price = price;
    }
  
    
    
// ===================================== 
// = getters / setters                 = 
// ===================================== 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusPrice getStatusPrice() {
        return statusPrice;
    }

    public void setStatusPrice(StatusPrice statusPrice) {
        this.statusPrice = statusPrice;
    }

    public ErpUser getErpUser() {
        return erpUser;
    }

    public void setErpUser(ErpUser erpUser) {
        this.erpUser = erpUser;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
        if (!(object instanceof PriceTag)) {
            return false;
        }
        PriceTag other = (PriceTag) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.priceTag.PriceTag[ id=" + id + " ]";
    }

    

}//PriceTag
