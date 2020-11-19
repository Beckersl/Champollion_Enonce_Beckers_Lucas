package champollion;

import java.util.ArrayList;
import java.util.List;

public class Enseignant extends Personne {
    
    private List<ServicePrevu> enseignements = new ArrayList();
    private List<Intervention> interventionsEffectue = new ArrayList();
    // TODO : rajouter les autres méthodes présentes dans le diagramme UML

    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        int heuresTotal = 0;
        for (ServicePrevu n : enseignements){
            heuresTotal += (int)Math.round(n.getVolumeCM() * 1.5f + n.getVolumeTD() + n.getVolumeTP()* 0.75);
        }
        return heuresTotal;
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        int heuresTotal = 0;
        for (ServicePrevu n : enseignements){
            if (n.getxUE() == ue){
                heuresTotal += (int)Math.round(n.getVolumeCM() * 1.5f + n.getVolumeTD() + n.getVolumeTP()* 0.75);
            }
        }
        return heuresTotal;
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        
        ServicePrevu s = new ServicePrevu(this, ue, volumeCM, volumeTD, volumeTP);
        enseignements.add(s);
    }
    
    
     // Ajoute un enseignement au service prévu pour cet enseignant
     
     public void ajouteIntervention(Intervention e){
         interventionsEffectue.add(e);
     }
     
     /**
     * Calcule le nombre total d'heures d'interventions plannifiées pour cet enseignant en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
     
     public int heuresPlannifiees(){
        int heuresTotal = 0;
        for (Intervention n : interventionsEffectue){
            if (n.getTypeIntervention() == TypeIntervention.CM){
                heuresTotal += (int) Math.round(n.getDuree() * 1.5);
            }
            if (n.getTypeIntervention() == TypeIntervention.TD){
                heuresTotal += (int) Math.round(n.getDuree());
            }
            if (n.getTypeIntervention() == TypeIntervention.TP){
                heuresTotal += (int) Math.round(n.getDuree() * 0.75);
            }
        }
        return heuresTotal;
     }
     
     /**
     Vérifie que le nombre d'heures plannifiées est égal au nombres d'heures prévues
     *
     * @return true si heuresPlannifiées = heuresPrevues et false si ce n'est pas le cas
     *
     */
     
     public boolean enSousService(){
         if (this.heuresPlannifiees() == this.heuresPrevues()){
             return true;
         }
         else {
             return false;
         }
     }

}
