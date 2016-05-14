package entities.status;

public class EnumMediaStatus {

// ===================================== 
// = Attributes                        = 
// ===================================== 
    
    /*
    
    MTL NOTE this class is not already use, since
    haven't been able to figure it out how to use it in MediaStatus
    
    */
    
    
    enum Proceso {

        MAIN("Main media object"),
        NEW_RELEASE("New release object"),
        MOST_WANTED("Most wanted object"),
        TOP_TEN("Top ten object"),
        ADITIONAL_INFO("Gives aditional information");

        private String procesoStatus;

        Proceso(String processoStatus) {
            this.procesoStatus = processoStatus;
        }

        public String getprocesoStatus(){
            return this.procesoStatus;
        }
        
        
    }//Process
    
    enum Control {
        
        ACTIVE("Active object"),
        DEPRECATED ("Deprecated object");
        
        private String controlStatus;
        
        Control(String controlStatus){
            this.controlStatus = controlStatus;
        }
        
        public String getControlStatus(){

            return this.controlStatus;
        }
        
    }//Control

    
    
    
    
    
}//EnumerationStatus
