/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.part2;

import assignment2.Patient;
import static assignment2.Patient.ageCalculate;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author psrib
 */
public class PatientHistory {

    private static VitalSignHistory history  = new VitalSignHistory();
    static String paitentName;
    private static int age;
    static int ageGroup = -1;
    private static boolean flag = false;

   
    PatientHistory(String pname) {
        this.paitentName = pname;
    }

    public static void main(String args[]) {

        displayOptions();
    }


    public static void createVitals() {

        Scanner sc = new Scanner(System.in);
        if (!flag) {
            System.out.println("Enter the patient Name");
            String name = sc.nextLine();
            PatientHistory paitent = new PatientHistory(name);
            flag = true;
            ageGroup = ageCalculate(ageGroup);
            while (ageGroup == -1) {
                System.out.println("Enter in correct format");
                ageGroup = ageCalculate(ageGroup);
            }
        } else
            System.out.println("Enter the vitals record for the patient " + paitentName);



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


        VitalSigns vs = history.addNewVitals();
        vs.setHeartRate(heartRate);
        vs.setRespiratoryRate(respRate);
        vs.setSystolicBloodPressure(sysBP);
        vs.setWeightKG(weightKg);
        vs.setWeightPounds(weightP);
        displayOptions();
    }

    public static void viewVitals() {
        System.out.println("The Vital record history for the patient " + paitentName);
        System.out.println("********************************************************************************************");
        System.out.println("No. | Patient Name |     Heart Rate |   Resp Rate  |  Sys Rate | Weight(KG) |  Weight(Pounds)");
        System.out.println("*********************************************************************************************");

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < history.getList().size(); i++) {
            System.out.print(i + 1 + "     ");
            System.out.print(paitentName + "                ");
            System.out.print(history.getList().get(i).getRespiratoryRate() + "       ");
            System.out.print(history.getList().get(i).getHeartRate() + "             ");
            System.out.print(history.getList().get(i).getSystolicBloodPressure() + "        ");
            System.out.print(history.getList().get(i).getWeightKG() + "           ");
            System.out.print(history.getList().get(i).getWeightPounds() + "         ");
            System.out.println();
        }
        displayOptions();
    }

    public static void displayOptions() {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose the option below");
        System.out.println("1. Create Vitals");
        System.out.println("2. View Vitals");
        System.out.println("3. Check vital sign");
        System.out.println("4. Exit");
        choice = sc.nextInt();
        // switch statement to check size
        switch (choice) {

            case 1:
                createVitals();
                break;

            case 2:
                viewVitals();
                break;

            case 3:
                if(history.getList().size()== 0){
                  System.out.println("First create a vital sign to check. There are no vitals signs found in the record");
                  displayOptions();
                  break;
                }
                System.out.println("Enter the attribute name to check(Ex. Heart rate or weight kg or weight pounds or Respiratory rate or Systolic blood pressure )");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                String s1;
                Set<String> set = new HashSet<>();
                set.add("heart rate");
                set.add("respiratory rate");
                set.add("systolic blood pressure");
                set.add("weight kg");
                set.add("heart rate");
                set.add("weight pounds");
                try {
                    s1 = br.readLine().toLowerCase().trim();
                    if(set.contains(s1)){

                    if (isThisVitalSignNormal(s1)) {
                        System.out.println("The attribute is within the range for this patient");
                    } else {
                        System.out.println("The attribute is Abnormal");
                    }
                    }else{
                        System.out.println("Attribute not found in the record");
                        System.out.println("Please Check for valid vital sign given below");
                        viewVitals();

                    }
                    displayOptions();
                } catch (IOException ex) {
                    Logger.getLogger(PatientHistory.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case 4:
                return;
        }

    }

    public static boolean isThisVitalSignNormal(String s) {

        VitalSigns vss = new VitalSigns(ageGroup);
        VitalSignHistory vsh = new VitalSignHistory();
        
        VitalSigns hh = history.getList().get(history.getList().size() - 1);
        if (s.equalsIgnoreCase("heart rate")) {
            if (hh.heartRate >= vss.getHeartRateLowerBound() && hh.heartRate < vss.getHeartRateUpperBound())
                return true;
            else
                return false;
        } else if (s.equalsIgnoreCase("respiratory rate")) {
            if (hh.respiratoryRate >= vss.getRespiratoryRateLowerBound() && hh.respiratoryRate < vss.getRespiratoryRateUpperBound())
                return true;
            else
                return false;
        } else if (s.equalsIgnoreCase("systolic blood pressure")) {
            if (hh.systolicBloodPressure >= vss.getSysBloodPressureLB() && hh.systolicBloodPressure < vss.getSysBloodPressureUB())
                return true;
            else
                return false;
        } else if (s.equalsIgnoreCase("weight kg")) {
            if (hh.weightKG >= vss.getWeightKgLB() && hh.weightKG < vss.getWeightKgUB())
                return true;
            else
                return false;
        } else if (s.equalsIgnoreCase("weight pounds")) {
            if (hh.weightPounds >= vss.getWeightPLB() && hh.weightPounds < vss.getWeightPUB())
                return true;
            else
                return false;
        } else {
            System.out.println("Attribute not found in the record");
            
        }

        return false;
    }
}