/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author psrib
 */
public class Main {
    
    City city ;
    Person person;
    PatientDirectory pd;
    HashMap<String, Patient> map = pd.map;
    
    public static void main(String args[]){
         
        new Main().displayMenu();
    }

    
         
    public void displayMenu(){
        
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose the option below");
        System.out.println("1. Create patient record");
        System.out.println("2. Enter encounter record for the existing patient");
        System.out.println("3. View Encounters");
        System.out.println("4. View patients");
        System.out.println("5. Check vital signs for a given patient");
        System.out.println("6. Analyze Results");
        choice = sc.nextInt();
        switch (choice) {

            case 1:
                createPatientRecord();
                break;

            case 2:
                System.out.println("Enter the patient name");
                String name = sc.next();
                if(map.containsKey(name)){
                    addEncounter(map.get(name));
                }else{
                   System.out.println("Patient name not found. Create a new record or check the name"); 
                   displayMenu();
                }
                break;

            case 3:
                System.out.println("Enter the patient name");
                String name1 = sc.next();
                if(PatientDirectory.map.containsKey(name1)){
                    viewEncounters(map.get(name1));
                }else{
                   System.err.println("Patient name not found. Create a new record or check the name"); 
                   displayMenu();
                }
                
                break;

            case 4:
                   getPatientDetails();
                   displayMenu();
                return;
            case 5:
                 System.out.println("Enter the patient name to check:");
                 String pname = sc.next();
                 if(map.containsKey(pname)){
                     if(checkVitals1(map.get(pname))){
                        System.out.println("The recent vitals are normal for the given patient");
                        displayMenu();
                     }else{
                        System.out.println("The recent vitals are abnormal for the given patient");
                        displayMenu();
                     }
                 }else{
                     System.out.println("Enterted patient does not exits in patient directory");
                     displayMenu();
                 }
                 break;
            case 6:
                 analyzeRecords();
                 break;
        }
    }
    
    
    public void createPatientRecord() throws InputMismatchException{
        
        Scanner sc = new Scanner(System.in);
        Patient patient = new Patient();
        Encounter encounter = new Encounter();
        EncounterHistory encounterHistory = new EncounterHistory();
        VitalSigns vitalSigns = new VitalSigns();
        Person person = new Person();
       // PatientDirectory pd = new PatientDirectory();
        Patient pp;
        System.out.println("Enter the Patient Name ");
        String perName = sc.nextLine();
        patient.setPersonName(perName);
        
        if(!map.containsKey(perName)){
            map.put(perName, patient);
            System.out.println("Enter the Patient Age (ex 25 years or 25 days)");
            String perAge = sc.nextLine();
            patient.setAge(perAge);
            String ag = ageCalculate(perAge);
            System.out.println("The patient belongs to "+ ag);
            patient.setAgeGroup(ag);
           
//            ArrayList<Person> ap = new ArrayList<>();
//            ap.add(patient);
//            
            House house = new House();
            System.out.println("Enter the City");
            String cityName = new Scanner(System.in).nextLine();
            house.setCityName(cityName);
            System.out.println("Enter the Community name");
            String cname = new Scanner(System.in).nextLine();
            house.setCommunityName(cname);
            System.out.println("Enter the House no");
            int address = new Scanner(System.in).nextInt();
            house.setHouseNo(address);
            house.setSetPerson(patient);
            house.setCommunityList(house);
            house.setHouseList(house);
            patient.setHouse(house);
            city = house;
            System.out.println("Purpose of visit  ");
            String pov = sc.nextLine();
            encounter.setPurposeOfVist(pov);
            System.out.println("Enter Doctors Name ");
            String doc = sc.nextLine();
            encounter.setDoctorName(doc);
            encounter.setVisitedDate(new Date());
            ArrayList<Encounter> al = new ArrayList();
            al.add(encounter);
            encounterHistory.setList(al);
            patient.setEncounterHistory(encounterHistory);

            System.out.println("Enter the vitals ");
            System.out.println("Respiratory Rate");
            int respRate = sc.nextInt();
            System.out.println("Heart Rate");
            int heartRate = sc.nextInt();
            System.out.println("Syst BP");
            int sysBP = sc.nextInt();
            System.out.println("Weight in KG");
            float weightKg = sc.nextFloat();
            System.out.println("Weight in Pounds");
            float weightP = sc.nextFloat();

            vitalSigns.setHeartRate(heartRate);
            vitalSigns.setRespiratoryRate(respRate);
            vitalSigns.setSystolicBloodPressure(sysBP);
            vitalSigns.setWeightKG(weightKg);
            vitalSigns.setWeightPounds(weightP);
            encounter.setVs(vitalSigns);
            
            displayMenu();
        }else{
            System.out.println("This patient record already exists. Press 1 to encounter or 0 to main menu");
            int n = sc.nextInt();
            if(n==1)
                addEncounter(map.get(perName));
            else if(n==0)
                displayMenu();
            else
                displayMenu();
            
        }
        
   
    }
    
    public void viewEncounters(Patient p){
        
        System.out.println("The previous encounters ");
        int len = p.getEncounterHistory().getList().size();
        for(int i =0; i < len ; i++){
            System.out.println("************************************************************");
            System.out.println(" Doctor name: "+ p.getEncounterHistory().getList().get(i).getDoctorName());
            System.out.println(" Purpose of Visit :"+ p.getEncounterHistory().getList().get(i).getPurposeOfVist());
            System.out.println(" Date :"+ p.getEncounterHistory().getList().get(i).getVisitedDate());
            System.out.println(" Heart rate :"+ p.getEncounterHistory().getList().get(i).getVs().getHeartRate());
            System.out.println(" Respiratory rate :"+ p.getEncounterHistory().getList().get(i).getVs().getRespiratoryRate());
            System.out.println(" Systolic BP rate :"+ p.getEncounterHistory().getList().get(i).getVs().getSystolicBloodPressure());
            System.out.println(" Weight KG :"+ p.getEncounterHistory().getList().get(i).getVs().getWeightKG());
            System.out.println(" Weight Pounds :"+ p.getEncounterHistory().getList().get(i).getVs().getWeightPounds());
            System.out.println("************************************************************");
        }
        displayMenu();
        
    }
    
    public void addEncounter(Patient p){
        
        viewEncounters(p);
        Scanner sc = new Scanner(System.in);
        Encounter encounter = new Encounter();
        EncounterHistory encounterHistory = new EncounterHistory();
        VitalSigns vitalSigns = new VitalSigns();
        System.out.println("Purpose of visit  ");
        String pov = sc.nextLine();
        encounter.setPurposeOfVist(pov);
        System.out.println("Enter Doctors Name ");

        String doc = sc.nextLine();

        encounter.setDoctorName(doc);
        encounter.setVisitedDate(new Date());
        ArrayList<Encounter> al = p.getEncounterHistory().getList();
        al.add(encounter);
        encounterHistory.setList(al);
        p.setEncounterHistory(encounterHistory);

        System.out.println("Enter the vitals ");
        System.out.println("Respiratory Rate");
        int respRate = sc.nextInt();
        System.out.println("Heart Rate");
        int heartRate = sc.nextInt();
        System.out.println("Syst BP");
        int sysBP = sc.nextInt();
        System.out.println("Weight in KG");
        float weightKg = sc.nextFloat();
        System.out.println("Weight in Pounds");
        float weightP = sc.nextFloat();

        vitalSigns.setHeartRate(heartRate);
        vitalSigns.setRespiratoryRate(respRate);
        vitalSigns.setSystolicBloodPressure(sysBP);
        vitalSigns.setWeightKG(weightKg);
        vitalSigns.setWeightPounds(weightP);
        encounter.setVs(vitalSigns);
        
        displayMenu();
    }
    
     public void getPatientDetails(){
        PatientDirectory patientDirectory = new PatientDirectory();
        ArrayList<Patient> as = patientDirectory.getPatientDirectory();
        for(int i =0; i < as.size()-1 ; i++){
            System.out.println("Patient Names  "+ as.get(i).getPersonName());
        }
        
    }
     
     public void analyzeRecords(){
         
        System.out.println("Enter Choose the city below to analyze");
        Scanner sc = new Scanner(System.in);
      
        System.out.println("Choose the city below ");
        System.out.println(City.getCitymap().keySet());
        String s1 = sc.nextLine();
        List<Community> list = City.getCitymap().get(s1);
        System.out.println("This city has "+list.size() +" communities ");
        int count=0; 
        int pc =0;
        for(int i =0 ; i < list.size(); i++ ){
            //System.out.println("COmmunity Names "+ City.getCitymap().get(s1).get(i).getCommunityName());
            Map<String, List<House>> list1 = list.get(i).getCommunitymap();
            List<House> h = list1.get(City.getCitymap().get(s1).get(i).getCommunityName());
            for(House h1: h){
                pc++;
                //System.out.println("SSS "+ h1.getSetPerson().getEncounterHistory().getList().get(0).getVs().getSystolicBloodPressure());
                for(int k =0 ; k < h1.getSetPerson().getEncounterHistory().getList().size(); k++){
                   if(checkVitals(h1.getSetPerson().getEncounterHistory().getList().get(k).getVs(), map.get(h1.getSetPerson().getPersonName()))){
                       System.out.println("Normal for "+ h1.getSetPerson().getPersonName());
              
                   }else{
                       System.out.println("Abnormal for "+ h1.getSetPerson().getPersonName());
                       count++;
                   }
                }    
                
           }
        }
        System.out.println("There are "+list.size()+ " communities in this city and of total of "+pc+ " patients. "+ count + " Paitient has abnormal vital ranges for a given city ");

        
     }
     
     public boolean checkVitals(VitalSigns v, Patient p){

         VitalSigns v1 = new VitalSigns(p.getAgeGroup());
                    
            if (v.getSystolicBloodPressure() >= v1.getSysBloodPressureLB()&& 
                    v.getSystolicBloodPressure() < v1.getSysBloodPressureUB())
                return true;
            else
                return false;
    }
     
      public static String ageCalculate(String ageGroup) {

        String s[] = ageGroup.split(" ");
        if (s[1].equals("days")) {
           return "NEWBORN";
        } else if (s[1].equals("months")) {
            return "INFANT";
        } else if (s[1].equals("years") && Integer.parseInt(s[0]) < 3) {
            return "TODDLER";
        } else if (s[1].equals("years") && Integer.parseInt(s[0]) >= 3 && Integer.parseInt(s[0]) <= 5) {
            return "PRESCHOOLER";
        } else if (s[1].equals("years") && Integer.parseInt(s[0]) >= 6 && Integer.parseInt(s[0]) <= 12) {
            return "SCHOOLAGE";
        } else if (s[1].equals("years") && Integer.parseInt(s[0]) >= 13) {
            return "ADOLESCENT";
        }

        return "";
    }
      
   public boolean checkVitals1(Patient p){
       
       VitalSigns v = new VitalSigns(p.getAgeGroup());
           
        if (v.getHeartRate() >= v.getHeartRateLowerBound() && v.getHeartRate() < v.getHeartRateUpperBound() &&
            v.getRespiratoryRate() >= v.getRespiratoryRateLowerBound() && v.getRespiratoryRate() < v.getRespiratoryRateUpperBound() &&
            v.getSystolicBloodPressure() >= v.getSysBloodPressureLB() && v.getSystolicBloodPressure() < v.getSysBloodPressureUB() &&
            v.getWeightKG() >= v.getWeightKgLB() && v.getWeightKG() < v.getWeightKgUB() &&
            v.getWeightPounds() >= v.getWeightPLB() && v.getWeightPounds() < v.getWeightPUB())
            return true;
       
       return false;
   }
    
}
