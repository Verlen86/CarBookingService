package CarRent.utils;

import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import CarRent.entity.CarData;



public class CarListSerializer extends JsonSerializer<ArrayList<CarData>>{

	@Override
	public void serialize(ArrayList<CarData> carListValue, JsonGenerator jsonGenCarList, SerializerProvider arg2) throws IOException, JsonProcessingException {
		jsonGenCarList.writeStartObject();
		jsonGenCarList.writeArrayFieldStart("allInfo");
		for (int i=0; i<carListValue.size();i++) {
			jsonGenCarList.writeStartObject();
			jsonGenCarList.writeNumberField("id",carListValue.get(i).getId());
			jsonGenCarList.writeStringField("brand",carListValue.get(i).getBrand());
			jsonGenCarList.writeStringField("model",carListValue.get(i).getModel());
			jsonGenCarList.writeBooleanField("diesel",carListValue.get(i).isDiesel());
			jsonGenCarList.writeBooleanField("petrol",carListValue.get(i).isPetrol());
			jsonGenCarList.writeBooleanField("transmission",carListValue.get(i).isAvtomatedTransmission());
			jsonGenCarList.writeEndObject();
        }
		jsonGenCarList.writeEndArray();
		jsonGenCarList.writeEndObject();
		
	}

}
