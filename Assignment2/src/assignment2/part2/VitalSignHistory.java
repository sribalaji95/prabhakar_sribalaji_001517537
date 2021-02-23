/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.part2;

import java.util.ArrayList;

/**
 *
 * @author psrib
 */
public class VitalSignHistory {

    private ArrayList < VitalSigns > history;

    public VitalSignHistory() {

        this.history = new ArrayList < VitalSigns > ();
    }

    public ArrayList < VitalSigns > getList() {
        return history;
    }

    public void setList(ArrayList < VitalSigns > history) {
        this.history = history;
    }

    public VitalSigns newVitalSign() {
        VitalSigns newVitals = new VitalSigns();
        history.add(newVitals);
        return newVitals;
    }
}