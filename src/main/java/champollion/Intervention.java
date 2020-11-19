/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package champollion;

import java.util.Date;

/**
 *
 * @author becke
 */
public class Intervention {
    private Date debut;
    private int duree;
    private boolean annulee = false;
    private TypeIntervention typeIntervention;
    private Salle s;
    private UE u;
    private Enseignant e;
    

    public Intervention(Salle s, UE u,Enseignant e, Date debut, int duree, TypeIntervention TypeIntervention) {
        this.s = s;
        this.u = u;
        this.e = e;
        this.debut = debut;
        this.duree = duree;
        this.typeIntervention = TypeIntervention;
    }

    public Date getDebut() {
        return debut;
    }

    public int getDuree() {
        return duree;
    }

    public boolean isAnnulee() {
        return annulee;
    }

    public TypeIntervention getTypeIntervention() {
        return typeIntervention;
    }

    public Salle getS() {
        return s;
    }

    public UE getU() {
        return u;
    }

    public Enseignant getE() {
        return e;
    }

    
    
}
