package CarRent.utils;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import CarRent.entity.CarData;

public class CarListDeserializer extends JsonDeserializer<ArrayList<CarData>> {
	
	private final ArrayList<CarData> carList=new ArrayList<CarData>();

	@Override
	public ArrayList<CarData> deserialize(JsonParser jsonParser, DeserializationContext arg1) throws IOException, JsonProcessingException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
        JsonNode nodeCarList=node.get("allInfo");
        System.out.println(nodeCarList);
        for (int i = 0; i < nodeCarList.size(); i++) 
        {
        	Integer id=nodeCarList.get(i).get("id").asInt();
        	String brand=nodeCarList.get(i).get("brand").asText();
        	String model=nodeCarList.get(i).get("model").asText();
        	boolean diesel=nodeCarList.get(i).get("diesel").asBoolean();
        	boolean petrol=nodeCarList.get(i).get("petrol").asBoolean();
        	boolean transmission=nodeCarList.get(i).get("transmission").asBoolean();
        	CarData car=new CarData(id,brand,model,diesel,petrol,transmission);
        	carList.add(car);
        }

		return carList;
	}

}
