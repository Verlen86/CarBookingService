package CarRent.entity;

import java.util.ArrayList;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import CarRent.utils.CarListDeserializer;
import CarRent.utils.CarListSerializer;


public class BookingData {
	@JsonProperty
	private String name;
	@JsonProperty
	@JsonSerialize(using = CarListSerializer.class)
	@JsonDeserialize(using = CarListDeserializer.class)
	private ArrayList<CarData> carList=new ArrayList<CarData>();
	
	public BookingData(){};
	
	public BookingData(String name) {
		this.name=name;
	}
	
	public void addCarToList(CarData car){
		carList.add(car);
	}
	public ArrayList<CarData> showCarList(){
		return carList; 
	}

	public String getName() {
		return name;
	}

	public ArrayList<CarData> getCarList() {
		return carList;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCarList(ArrayList<CarData> carList) {
		this.carList = carList;
	}
	

}
