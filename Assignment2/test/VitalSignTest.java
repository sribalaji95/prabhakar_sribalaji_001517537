/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import assignment2.Patient;
import assignment2.part2.VitalSigns;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author psrib
 */
public class VitalSignTest {
    
    public VitalSignTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    
    /**
     * 
     * 1 means newborn 2 means Infant 3 means Toddler 
     * 4 means preschooler 5 means School age 6 means Adolescent 
     */
    @Test
    public void test1(){
        
         VitalSigns v;
         v = new VitalSigns(1);
         v.setHeartRate(135);
         v.setRespiratoryRate(40);
         v.setSystolicBloodPressure(60);
         v.setWeightKG(2);
         v.setWeightPounds(6);
         assertTrue(Patient.isPatientNormal(v));
         
    }
    
     @Test
    public void test2(){
        
        VitalSigns v;
        v = new VitalSigns(2);
        v.setHeartRate(120);
        v.setRespiratoryRate(25);
        v.setSystolicBloodPressure(99);
        v.setWeightKG((float)9.5);
        v.setWeightPounds((float)20.2);
        assertTrue(Patient.isPatientNormal(v));
         
    }
    
    @Test
    public void test3(){
        
        VitalSigns v;
        v = new VitalSigns(3);
        v.setHeartRate(120);
        v.setRespiratoryRate(25);
        v.setSystolicBloodPressure(99);
        v.setWeightKG((float)13.5);
        v.setWeightPounds((float)30.1);
        assertTrue(Patient.isPatientNormal(v));
         
    }
    
    @Test
    public void test4(){
        
        VitalSigns v;
        v = new VitalSigns(4);
        v.setHeartRate(110);
        v.setRespiratoryRate(25);
        v.setSystolicBloodPressure(109);
        v.setWeightKG((float)17.5);
        v.setWeightPounds((float)39);
        assertTrue(Patient.isPatientNormal(v));
         
    }
    
    @Test
    public void test5(){
        
        VitalSigns v;
        v = new VitalSigns(5);
        v.setHeartRate(109);
        v.setRespiratoryRate(25);
        v.setSystolicBloodPressure(109);
        v.setWeightKG((float)40.5);
        v.setWeightPounds((float)43);
        assertTrue(Patient.isPatientNormal(v));
         
    }
    
    @Test
    public void test6(){
        
        VitalSigns v;
        v = new VitalSigns(6);
        v.setHeartRate(100);
        v.setRespiratoryRate(19);
        v.setSystolicBloodPressure(111);
        v.setWeightKG((float)60.1);
        v.setWeightPounds((float)111.1);
        assertTrue(Patient.isPatientNormal(v));
         
    }
    
    @Test
    public void test7(){
        
        VitalSigns v;
        v = new VitalSigns(6);
        v.setHeartRate(106);
        v.setRespiratoryRate(19);
        v.setSystolicBloodPressure(111);
        v.setWeightKG((float)60.1);
        v.setWeightPounds((float)111.1);
        assertFalse(Patient.isPatientNormal(v));
         
    }
    
     @Test
    public void test8(){
        
        VitalSigns v;
        v = new VitalSigns(1);
        v.setHeartRate(100);
        v.setRespiratoryRate(19);
        v.setSystolicBloodPressure(111);
        v.setWeightKG((float)60.1);
        v.setWeightPounds((float)111.1);
        assertFalse(Patient.isPatientNormal(v));
         
    } 
    
    @Test
    public void test9(){
        
        VitalSigns v;
        v = new VitalSigns(3);
        v.setHeartRate(79);
        v.setRespiratoryRate(19);
        v.setSystolicBloodPressure(111);
        v.setWeightKG((float)60.1);
        v.setWeightPounds((float)111.1);
        assertFalse(Patient.isPatientNormal(v));
         
    }
    
    @Test
    public void test10(){
        
        Patient p = new Patient();
        assertEquals(p.ageCalculateTestCase("22 years"),"Adolescent");
        assertEquals(p.ageCalculateTestCase("22 days"),"Newborn");
        assertEquals(p.ageCalculateTestCase("11 months"),"Infant");
        assertEquals(p.ageCalculateTestCase("11 years"),"School Age");
        assertEquals(p.ageCalculateTestCase("4 years"),"Preschooler");
                
                
    }
    
    
    
}
