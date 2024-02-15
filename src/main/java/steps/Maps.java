package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Maps {
	public static Response response;
	public static String placeid;
	
	@Given("Enter the end point url")
		public void endPointCreate() {
			RestAssured.baseURI="https://rahulshettyacademy.com/";			
		}
	@And("Send the body")
	public void bodyCreate() {
		
	RequestSpecification input = RestAssured.given().contentType("application/json").when().body("{\r\n"
			+ "    \"location\": {\r\n"
			+ "        \"lat\": -38.383494,\r\n"
			+ "        \"lng\": 33.427362\r\n"
			+ "    },\r\n"
			+ "    \"accuracy\": 50,\r\n"
			+ "    \"name\": \"Frontline house\",\r\n"
			+ "    \"phone_number\": \"(+91) 983 893 3937\",\r\n"
			+ "    \"address\": \"59, side layout, cohen 09\",\r\n"
			+ "    \"types\": [\r\n"
			+ "        \"shoe park\",\r\n"
			+ "        \"shop\"\r\n"
			+ "    ],\r\n"
			+ "    \"website\": \"http://google.com\",\r\n"
			+ "    \"language\": \"French-IN\"\r\n"
			+ "}").queryParam("key", "qaclick123");
	//String key="key=qaclick123";
	 response = input.post("maps/api/place/add/json");
	 placeid = response.jsonPath().get("place_id");
	 System.out.println("The placeid is"+placeid);
	 System.out.println(input);
	 response.prettyPrint();	
	}
	@Then("validate the statuscode as {int}")
	public void statusCodeValidate(int statusCode) {
		statusCode = response.getStatusCode();
		System.out.println("The statuscode is" + statusCode);
	}
	@Given("Send the body for update")
	public void updateMap(){
		
		RequestSpecification input = RestAssured.given().contentType("application/json").when().given().body("{\r\n"
				+ "    \"place_id\": \""+placeid+"\",\r\n"
				+ "    \"address\": \"99, side layout, cohen 09\",\r\n"
				+ "    \"key\": \"qaclick123\"\r\n"
				+ "}");
		System.out.println("update"+placeid);
		Response putresponse = input.put("maps/api/place/update/json"+placeid);
		
		putresponse.prettyPrint();
	}
	@Given("Send the body for get locations")
	public void getLocations() {
		Response responseGet = RestAssured.given().queryParam("key","qaclick123").queryParam("place_id", placeid)
				.get("maps/api/place/get/json/"+placeid);
		
		responseGet.prettyPrint();
		System.out.println("get");
	}
	
	@Given("Send the body for delete")
	public void deleteMaps() {
	RestAssured.delete("maps/api/place/get/json/"+placeid);
	System.out.println("Deleted");
	}
	
	
}