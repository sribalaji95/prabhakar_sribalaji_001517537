/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapp3;

/**
 *
 * @author psrib
 */
public class Person{

    String personName;
    String age;
    House house;
   
    
    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
    
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public void setPid(String pid) {
       
    }
    
   
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    
    
    public void setPersonName(Person pName){
        
    }
    
    
    
    public EncounterHistory getEncounterHistory() {
      return null;
    }

    public void setEncounterHistory(EncounterHistory encounterHistory) {
        
    }
   
  
    public String getPid() {
       return "";
    }
}
