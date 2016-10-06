package CarRent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test")
public class CarData {
	 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	 
	@Column(name="Brand")
	private String brand;
 
	@Column(name="Model")
	private String model;
	 
	@Column(name="Diesel")
	private boolean diesel;
 
	@Column(name="Petrol")
	private boolean petrol;
 
	@Column(name="Transmission")
	private boolean avtomatedTransmission;
	
	public CarData(){}
	
	public CarData(int id,String brand,String model, boolean diesel, boolean petrol, boolean transmission){
		this.id=id;
        if (id <=0){ 
            throw new IllegalArgumentException("Id should be bigger than zero");
        }
        this.brand=brand;
        if (brand == null || brand.isEmpty()){ 
            throw new IllegalArgumentException("Brand cannot be null");
        }
        this.model=model;
        if (model == null || model.isEmpty()){ 
            throw new IllegalArgumentException("Model cannot be null");
        }
        this.diesel=diesel;
        this.petrol=petrol;
        if(diesel==petrol){
        	throw new IllegalArgumentException("Choose only one type of fuel");
        }
        this.avtomatedTransmission=transmission;
	}
	public CarData(String brand,String model, boolean diesel, boolean petrol, boolean transmission){

        this.brand=brand;
        if (brand == null || brand.isEmpty()){ 
            throw new IllegalArgumentException("Brand cannot be null");
        }
        this.model=model;
        if (model == null || model.isEmpty()){ 
            throw new IllegalArgumentException("Model cannot be null");
        }
        this.diesel=diesel;
        this.petrol=petrol;
        if(diesel==petrol){
        	throw new IllegalArgumentException("Choose only one type of fuel");
        }
        this.avtomatedTransmission=transmission;
	}
	@Override
	public String toString(){
		String fuelType="";
		if (petrol==true) 
			fuelType="Petrol";
		if (diesel==true)
			fuelType="Diesel";
		if (avtomatedTransmission==true)return "Id: "+id+" Brand: "+brand+" Model: "+model+" Fuel type: "+fuelType+" Transmission: avtomated";
		else return "Id: "+id+" Brand: "+brand+" Model: "+model+" Fuel type: "+fuelType+" Transmission: Non-avtomated ";
		
	}
	public Integer getId() {
		return id;
	}
	public String getBrand() {
		return brand;
	}
	public String getModel() {
		return model;
	}
	public boolean isDiesel() {
		return diesel;
	}
	public boolean isPetrol() {
		return petrol;
	}
	public boolean isAvtomatedTransmission() {
		return avtomatedTransmission;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setDiesel(boolean diesel) {
		this.diesel = diesel;
	}
	public void setPetrol(boolean petrol) {
		this.petrol = petrol;
	}
	public void setAvtomatedTransmission(boolean avtomatedTransmission) {
		this.avtomatedTransmission = avtomatedTransmission;
	}

}
