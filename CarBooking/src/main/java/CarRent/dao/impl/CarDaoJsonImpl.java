package CarRent.dao.impl;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import CarRent.dao.CarRentDao;
import CarRent.entity.BookingData;


public class CarDaoJsonImpl implements CarRentDao {
	
	String carListFilePath="d:/carList.js";
    public void saveCarList(BookingData carList){
    	ObjectMapper mapperCarList = new ObjectMapper();
        File saveJson=new File(carListFilePath);
        if(!saveJson.exists()) { 
            try {
                saveJson.createNewFile();
            } catch (IOException ex) {
             	throw new RuntimeException("Cannot create file "+saveJson.getAbsolutePath(), ex);
            }
        }
        
        try {
            mapperCarList.writeValue(saveJson, carList);
        	System.out.println("Serialized Json data is saved in "+carListFilePath+"\n");
        } catch (Exception e) {
        	throw new RuntimeException(e);
		}
    }
	
	public BookingData readCarList(){
    	ObjectMapper mapperCarList = new ObjectMapper();
        try {
            return mapperCarList.readValue(new File(carListFilePath), BookingData.class);
        } catch (IOException ex) {
            throw new RuntimeException("I/O error "+ex);
        }
	}
}