package entities.status;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table (name="t_mediaStatus")
public class MediaStatus extends Status implements Serializable {
    
// ===================================== 
// = Attributes                        = 
// ===================================== 
    
    //Media status puede contener dos valores,
    //con el contenido de su grupo, el cual puede ser el siguiente:
    public enum StatusProceso {MAIN, NEW_RELEASE, MOST_WANTED, TOP_TEN, ADITIONAL_INFO};
    public enum StatusControl {ACTIVE, DEPRECATED};
    
    
    
    private static final long serialVersionUID = 1L;
    
    private StatusProceso statusProceso;
    private StatusControl statusControl;
    
// ===================================== 
// = Constructor(s)                    = 
// ===================================== 
    
    public MediaStatus() {
    }
    
    
    
// ===================================== 
// = getters / setters                 = 
// ===================================== 

    public void setStatusProceso(StatusProceso statusProceso) {
        this.statusProceso = statusProceso;
    }

    public void setStatusControl(StatusControl statusControl) {
        this.statusControl = statusControl;
    }
    

    public StatusProceso getStatusProceso() {
        return statusProceso;
    }


    public StatusControl getStatusControl() {
        return statusControl;
    }

    
    
// ===================================== 
// = other methods                     = 
// ===================================== 

    



}//MediaStatus
