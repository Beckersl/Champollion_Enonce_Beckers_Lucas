package champollion;

public class ServicePrevu {
	private int volumeCM = 0;
        private int volumeTD = 0;
        private int volumeTP = 0;
        private final Enseignant xEnseignant;
        private final UE xUE;

    public ServicePrevu(Enseignant xEnseignant, UE xUE,int volumeCM, int volumeTD, int volumeTP) {
        this.volumeCM = volumeCM;
        this.volumeTD = volumeTD;
        this.volumeTP = volumeTP;
        this.xEnseignant = xEnseignant;
        this.xUE = xUE;
        
    }

    public Enseignant getxEnseignant() {
        return xEnseignant;
    }

    public UE getxUE() {
        return xUE;
    }

    public int getVolumeCM() {
        return volumeCM;
    }

    public int getVolumeTD() {
        return volumeTD;
    }

    public int getVolumeTP() {
        return volumeTP;
    }
        
    

}
