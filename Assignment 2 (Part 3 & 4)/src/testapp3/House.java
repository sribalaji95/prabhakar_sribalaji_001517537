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
public class House extends Community {
    
    int houseNo;
    Person setPerson;

    @Override
    public Person getSetPerson() {
        return setPerson;
    }
    @Override
    public void setSetPerson(Person setPerson) {
        this.setPerson = setPerson;
    }
    
    @Override
    public int getHouseNo() {
        return houseNo;
    }
    @Override
    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }
    
    
    public int getPincode() {
        return super.getPincode();
    }

    
    public void setPincode(int pincode) {
        super.setPincode(pincode);
    }
    
   
    public String getCommunityName() {
        return super.getCommunityName();
    }
   
    public void setCommunityName(String communityName) {
        super.setCommunityName(communityName);
    }
    
    
    public void setCityName(String cityName) {
     super.setCityName(cityName);;
    }
    
    public void setCommunityList(){
        super.setCommunityList(this);
    }

}
