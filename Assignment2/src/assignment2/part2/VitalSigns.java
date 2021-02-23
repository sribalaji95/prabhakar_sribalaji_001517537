/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.part2;

import java.util.Date;

/**
 *
 * @author psribt
 */
public class VitalSigns {


    private int respiratoryRateUpperBound;
    private int respiratoryRateLowerBound;
    private int heartRateUpperBound;
    private int heartRateLowerBound;
    private int sysBloodPressureLB;
    private int sysBloodPressureUB;
    private int weightKgLB;
    private int weightKgUB;
    private int weightPLB;
    private int weightPUB;

    public int getRespiratoryRateUpperBound() {
        return respiratoryRateUpperBound;
    }

    public int getRespiratoryRateLowerBound() {
        return respiratoryRateLowerBound;
    }

    public int getHeartRateUpperBound() {
        return heartRateUpperBound;
    }

    public int getHeartRateLowerBound() {
        return heartRateLowerBound;
    }

    public int getSysBloodPressureLB() {
        return sysBloodPressureLB;
    }

    public int getSysBloodPressureUB() {
        return sysBloodPressureUB;
    }

    public float getWeightKgLB() {
        return weightKgLB;
    }

    public float getWeightKgUB() {
        return weightKgUB;
    }

    public float getWeightPLB() {
        return weightPLB;
    }

    public float getWeightPUB() {
        return weightPUB;
    }

    public VitalSigns() {

    }
    public VitalSigns(int age) {

        if (age == 1) {
            this.respiratoryRateLowerBound = 30;
            this.respiratoryRateUpperBound = 50;
            this.heartRateLowerBound = 120;
            this.heartRateUpperBound = 160;
            this.sysBloodPressureLB = 50;
            this.sysBloodPressureUB = 70;
            this.weightKgLB = 2;
            this.weightKgUB = 3;
            this.weightPLB = 4; // Change this to double
            this.weightPUB = 7;
        } else if (age == 2) {
            this.respiratoryRateLowerBound = 20;
            this.respiratoryRateUpperBound = 30;
            this.heartRateLowerBound = 80;
            this.heartRateUpperBound = 140;
            this.sysBloodPressureLB = 70;
            this.sysBloodPressureUB = 100;
            this.weightKgLB = 4;
            this.weightKgUB = 10;
            this.weightPLB = 9; // Change this to double
            this.weightPUB = 22;
        } else if (age == 3) {
            this.respiratoryRateLowerBound = 20;
            this.respiratoryRateUpperBound = 30;
            this.heartRateLowerBound = 80;
            this.heartRateUpperBound = 130;
            this.sysBloodPressureLB = 80;
            this.sysBloodPressureUB = 110;
            this.weightKgLB = 10;
            this.weightKgUB = 14;
            this.weightPLB = 22; // Change this to double
            this.weightPUB = 31;
        } else if (age == 4) {
            this.respiratoryRateLowerBound = 20;
            this.respiratoryRateUpperBound = 30;
            this.heartRateLowerBound = 80;
            this.heartRateUpperBound = 120;
            this.sysBloodPressureLB = 80;
            this.sysBloodPressureUB = 110;
            this.weightKgLB = 14;
            this.weightKgUB = 18;
            this.weightPLB = 31; // Change this to double
            this.weightPUB = 40;
        } else if (age == 5) {
            this.respiratoryRateLowerBound = 20;
            this.respiratoryRateUpperBound = 30;
            this.heartRateLowerBound = 70;
            this.heartRateUpperBound = 110;
            this.sysBloodPressureLB = 80;
            this.sysBloodPressureUB = 120;
            this.weightKgLB = 20;
            this.weightKgUB = 42;
            this.weightPLB = 41; // Change this to double
            this.weightPUB = 92;
        } else if (age == 6) {
            this.respiratoryRateLowerBound = 12;
            this.respiratoryRateUpperBound = 20;
            this.heartRateLowerBound = 55;
            this.heartRateUpperBound = 105;
            this.sysBloodPressureLB = 50;
            this.sysBloodPressureUB = 120;
            this.weightKgLB = 50;
            this.weightKgUB = Integer.MAX_VALUE;
            this.weightPLB = 110; // Change this to double
            this.weightPUB = Integer.MAX_VALUE;
        }
    }
    int respiratoryRate;
    int heartRate;
    int systolicBloodPressure;
    float weightKG;
    float weightPounds;
    Date createdDate;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getRespiratoryRate() {
        return respiratoryRate;
    }

    public void setRespiratoryRate(int respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getSystolicBloodPressure() {
        return systolicBloodPressure;
    }

    public void setSystolicBloodPressure(int systolicBloodPressure) {
        this.systolicBloodPressure = systolicBloodPressure;
    }

    public float getWeightKG() {
        return weightKG;
    }

    public void setWeightKG(float weightKG) {
        this.weightKG = weightKG;
    }

    public float getWeightPounds() {
        return weightPounds;
    }

    public void setWeightPounds(float weightPounds) {
        this.weightPounds = weightPounds;
    }
}