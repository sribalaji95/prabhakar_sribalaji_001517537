/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapp3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author psrib
 */
public class City {
    
    String cityName;
    static HashMap<String, List<Community>> citymap = new HashMap();

    public static HashMap<String, List<Community>> getCitymap() {
        return citymap;
    }

    public static void setCitymap(HashMap<String, List<Community>> citymap) {
        City.citymap = citymap;
    }


   
   public  void  setCommunityList(Community community)
   {
       List<Community> list = citymap.getOrDefault(this.getCityName(), new ArrayList());
//       System.out.println("SEE "+ list.size());
//       System.out.println("comm "+ community.communityName);
       boolean result = true;
       for(Community c : list){
           if(c.getCommunityName().equals(community.getCommunityName()))
           {
               result = false;
               break;
           }
       }
       
       if(result)
       {
           list.add(community);
       }
       
       citymap.put(this.getCityName(), list);
       
   }
    public int getPincode() {
        return 0;
    }

    public void setPincode(int pincode) {
        
    }

    public String getCommunityName() {
        return "";
    }

    public void setCommunityName(String communityName) {
        
    }
   
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    
    
     public Person getSetPerson() {
        return null;
    }

    public void setSetPerson(Person setPerson) {
        
    }
    
    
    public int getHouseNo() {
        return 0;
    }

    public void setHouseNo(int houseNo) {
        
    }

    public void setHouseList(House house)
    {
     
    }
    
    
}
