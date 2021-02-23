/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.part1;

import assignment2.part2.PatientHistory;
import static assignment2.part2.PatientHistory.createVitals;
import static assignment2.part2.PatientHistory.isThisVitalSignNormal;
import static assignment2.part2.PatientHistory.viewVitals;
import assignment2.part2.VitalSigns;
import com.sun.javafx.css.CalculatedValue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author psrib
 */
public class Patient {

    String paitentName;
    int age;

    public static boolean isPatientNormal(VitalSigns v) {


        if (v.getHeartRate() >= v.getHeartRateLowerBound() && v.getHeartRate() < v.getHeartRateUpperBound() &&
            v.getRespiratoryRate() >= v.getRespiratoryRateLowerBound() && v.getRespiratoryRate() < v.getRespiratoryRateUpperBound() &&
            v.getSystolicBloodPressure() >= v.getSysBloodPressureLB() && v.getSystolicBloodPressure() < v.getSysBloodPressureUB() &&
            v.getWeightKG() >= v.getWeightKgLB() && v.getWeightKG() < v.getWeightKgUB() &&
            v.getWeightPounds() >= v.getWeightPLB() && v.getWeightPounds() < v.getWeightPUB())
            return true;

        return false;
    }

    public static void main(String[] args) {

        displayOptions();
    }

    public String getPaitentName() {
        return paitentName;
    }

    public void setPaitentName(String paitentName) {
        this.paitentName = paitentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int ageCalculate(int ageGroup) {

        System.out.println("Enter the patient Age.(Ex format. 12 years or 12 months or 12 days)");
        Scanner sc = new Scanner(System.in);
        String ageG = sc.nextLine().trim();
        String s[] = ageG.split(" ");
        if(s.length == 1)
            return -1;
        if (s[1].equals("days")) {
            ageGroup = 1;
        } else if (s[1].equals("months")) {
            ageGroup = 2;
        } else if (s[1].equals("years") && Integer.parseInt(s[0]) < 3) {
            ageGroup = 3;
        } else if (s[1].equals("years") && Integer.parseInt(s[0]) >= 3 && Integer.parseInt(s[0]) <= 5) {
            ageGroup = 4;
        } else if (s[1].equals("years") && Integer.parseInt(s[0]) >= 6 && Integer.parseInt(s[0]) <= 12) {
            ageGroup = 5;
        } else if (s[1].equals("years") && Integer.parseInt(s[0]) >= 13) {
            ageGroup = 6;
        }

        return ageGroup;
    }

    public static void displayOptions() {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose the option below");
        System.out.println("1. Create Vitals");
        System.out.println("2. Check patient vitals");
        System.out.println("3. Exit");
        choice = sc.nextInt();
        switch (choice) {

            case 1:
                new Patient().createVitalRecord();
                break;
            case 2:
                new Patient().checkVital();
                break;
            case 3:
                return;
        }

    }

    public void createVitalRecord() {

        Patient paitent = new Patient();
        System.out.println("Enter the patient Name");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        paitent.setPaitentName(name);
        int ageGroup = -1;
        ageGroup = ageCalculate(ageGroup);

        while (ageGroup == -1) {
            System.out.println("Enter in correct format");
            ageGroup = ageCalculate(ageGroup);
        }

        System.out.println("Respi Rate");
        int respRate = sc.nextInt();
        System.out.println("Heart Rate");
        int heartRate = sc.nextInt();
        System.out.println("Syst BP");
        int sysBP = sc.nextInt();
        System.out.println("Weight in KG");
        float weightKg = sc.nextFloat();
        System.out.println("Weight in Pounds");
        float weightP = sc.nextFloat();

        VitalSigns vitals = new VitalSigns(ageGroup);
        vitals.setHeartRate(heartRate);
        vitals.setRespiratoryRate(respRate);
        vitals.setSystolicBloodPressure(sysBP);
        vitals.setWeightKG(weightKg);
        vitals.setWeightPounds(weightP);

        displayOptions();
    }

    public void checkVital() {
        VitalSigns vitalSigns = new VitalSigns();
        if (isPatientNormal(vitalSigns))
            System.out.println("Your vitals are normal");
        else
            System.out.println("Your vitals are Abnormal");
    }
    
     //USed by only test case. Same logic
     public static String ageCalculateTestCase(String ageG) {

        int ageGroup = -1;
        String s[] = ageG.split(" ");
       
        if (s[1].equals("days")) {
            ageGroup = 1;
            return "Newborn";
        } else if (s[1].equals("months")) {
            ageGroup = 2;
            return "Infant";

        } else if (s[1].equals("years") && Integer.parseInt(s[0]) < 3) {
            ageGroup = 3;
            return "Toddler";
        } else if (s[1].equals("years") && Integer.parseInt(s[0]) >= 3 && Integer.parseInt(s[0]) <= 5) {
            ageGroup = 4;
            return "Preschooler";
        } else if (s[1].equals("years") && Integer.parseInt(s[0]) >= 6 && Integer.parseInt(s[0]) <= 12) {
            ageGroup = 5;
            return "School Age";
        } else if (s[1].equals("years") && Integer.parseInt(s[0]) >= 13) {
            ageGroup = 6;
            return "Adolescent";
        }

        return "";
    }
}