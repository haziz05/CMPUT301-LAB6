package com.example.listycity6proper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class holds our City type objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This method adds a City type object to the cities list
     * @param c: the object to add
     * //@throws : IllegalArgumentException if c already exists in the Cities list
     *
     */
    public void add(City c){
        if (cities.contains(c)){
            throw new IllegalArgumentException();
        }

        cities.add(c);
    }


    public List<City> getCities(){
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This method returns true if the city object being passed into the method is in the cities list
     * @param city: the city object being checked
     * @return a boolean value
     */

    public boolean hasCity(City city) {

        for(City inList : cities){
            if( inList.compareTo(city) == 0){
                return true;
            }
        }

        return false;
    }

    /**
     * This method deletes the city being passed into the method from the cities list
     * @param city: The city object being deleted
     */
    public void delete(City city){

        if (hasCity(city)){
            cities.remove(city);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This method returns the number of cities in the list
     * @return an integer of the number of cities list
     */
    public int countCities(){
        return cities.size();
    }




}
