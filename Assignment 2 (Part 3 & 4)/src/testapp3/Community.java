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
public class Community extends City {
    
    String communityName;
    static HashMap<String,List<House>> communitymap = new HashMap();

    public static HashMap<String, List<House>> getCommunitymap() {
        return communitymap;
    }
    @Override
    public void setHouseList(House house)
    {
        List<House> list = communitymap.getOrDefault(this.getCommunityName(), new ArrayList());
        list.add(house);
        communitymap.put(this.getCommunityName(), list);
        //System.out.println(" Map Size "+communitymap.size() +" "+ this.getCommunityName());
    }
  
    
   @Override
    public String getCommunityName() {
        return communityName;
    }
   @Override
    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

}
