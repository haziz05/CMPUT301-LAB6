package com.example.listycity6proper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class CityListTest {
    private CityList mockCityList(){
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd(){
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "SK");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testAddException(){
        CityList cityList = mockCityList();
        City c = new City("Yellowknife", "NW");
        cityList.add(c);
        assertThrows(IllegalArgumentException.class,()->{cityList.add(c);});
    }

    @Test
    public void testGetCities(){
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "PEI");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testHasCity(){
        CityList cityList = mockCityList();
        assertTrue(cityList.hasCity(mockCity()));
        City city = new City("Red Deer", "AB");
        assertFalse(cityList.hasCity(city));
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
    }

    @Test
    public void testDelete(){
        CityList cityList = mockCityList();
        City city = new City("Red Deer", "AB");
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
        cityList.delete(city);
        assertFalse(cityList.hasCity(city));
        assertThrows(IllegalArgumentException.class, ()->{cityList.delete(city);});
    }

    @Test
    public void testCountCities(){
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
        City city1 = new City("Red Deer", "AB");
        City city2 = new City("Calgary", "AB");
        City city3 = new City( "Vancouver", "BC");
        cityList.add(city1);
        cityList.add(city2);
        assertEquals(3, cityList.countCities());
        cityList.delete(city1);
        cityList.delete(city2);
        cityList.add(city3);
        assertEquals(2, cityList.countCities());
    }


}
