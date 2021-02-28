/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapp3;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author psrib
 */
public class EncounterHistory {
    
    private ArrayList < Encounter > encounterHistory;

  public EncounterHistory() {

        this.encounterHistory = new ArrayList < Encounter > ();
    }

    public ArrayList < Encounter > getList() {
        return encounterHistory;
    }

    public void setList(ArrayList < Encounter > encounterHistory) {
        this.encounterHistory = encounterHistory;
    }

    public Encounter addNewEncounter() {
        Encounter encounter = new Encounter();
        encounterHistory.add(encounter);
        return encounter;
    }  
    
    
        
}
