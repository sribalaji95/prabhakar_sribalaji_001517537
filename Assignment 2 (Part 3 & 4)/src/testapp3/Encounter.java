/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapp3;

import java.util.Date;

/**
 *
 * @author psrib
 */
public class Encounter {

    Date visitedDate;
    String purposeOfVist;
    String doctorName;
    VitalSigns vs;

    public VitalSigns getVs() {
        return vs;
    }

    public void setVs(VitalSigns vs) {
        this.vs = vs;
    }
    
    public Date getVisitedDate() {
        return visitedDate;
    }

    public void setVisitedDate(Date visitedDate) {
        this.visitedDate = visitedDate;
    }

    public String getPurposeOfVist() {
        return purposeOfVist;
    }

    public void setPurposeOfVist(String purposeOfVist) {
        this.purposeOfVist = purposeOfVist;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
    
}
