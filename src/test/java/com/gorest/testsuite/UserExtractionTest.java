package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserExtractionTest {
    static ValidatableResponse response;
    @BeforeClass
    public static void inIt(){
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        response =given()
                .when()
                .queryParam("page","1")
                .queryParam("per_page","20")
                .get("/users?page=1&per_page=20")
                .then().statusCode(200);
    }
        //1. Extract the All Ids
    @Test
    public void ExtractAllIds(){
        List<Object> totalId = response.extract().path("id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total records are : " + totalId.size());
        System.out.println("------------------End of Test---------------------------");
    }
    //2. Extract the all Names
    @Test
    public void ExtractAllNames(){
        List<Integer> allName = response.extract().path("name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Name of the All store is : " + allName);
        System.out.println("------------------End of Test---------------------------");
    }
    //3. Extract the name of 5th object
    @Test
    public void ExtractNameOf5thObject(){
        String objectName = response.extract().path("[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Name of 5th store : " + objectName);
        System.out.println("------------------End of Test---------------------------");
    }
    //4. Extract the names of all object whose status = inactive
    @Test
    public void ExtractAllNamesWithStatusInactive(){
        List<?> allInactiveStatus = response.extract().path("findAll{it.status=='inactive'}.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Status of Inactive: " + allInactiveStatus);
        System.out.println("------------------End of Test---------------------------");
    }
    //5. Extract the gender of all the object whose status = active
    @Test
    public void ExtractAllGenderWithActiveStatus(){
        List<?> allActiveStatusGender = response.extract().path("findAll{it.status=='active'}.gender");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Status of Active: " + allActiveStatusGender);
        System.out.println("------------------End of Test---------------------------");
    }
    //6. Print the names of the object whose gender = female
    @Test
    public void PrintNamesOfFemaleGender(){
        List<?> allObjectWithGenderFemale = response.extract().path("findAll{it.gender=='female'}.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Gender is Female: " + allObjectWithGenderFemale);
        System.out.println("------------------End of Test---------------------------");
    }
    //7. Get all the emails of the object where status = inactive
    @Test
    public void GetAllEmailsOfInactiveStatus(){
        List<?> allEmailsOfStatusInactive = response.extract().path("findAll{it.status=='inactive'}.email");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Email Of Inactive : " + allEmailsOfStatusInactive);
        System.out.println("------------------End of Test---------------------------");
    }
    //8. Get the ids of the object where gender = male
    @Test
    public void GetIdsOfMaleGender(){
        List<?> allIdWithGenderMale = response.extract().path("findAll{it.gender=='male'}.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Gender is Female: " + allIdWithGenderMale);
        System.out.println("------------------End of Test---------------------------");
    }
    //9. Get all the status
    @Test
    public void GetAllStatus(){
        List<Integer> statusList = response.extract().path("status");
        statusList.size();
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All Status list : " + statusList.size());
        System.out.println("------------------End of Test---------------------------");
    }
    //10. Get email of the object where name = Karthik Dubashi IV---not in my data. Changing as per my data
    @Test
    public void GetEmail(){
        List<?> emailOfBhilanganaMehra = response.extract().path("findAll{it.name=='Bhilangana Mehra'}.email");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Email Of Bhilangana Mehra :" + emailOfBhilanganaMehra);
        System.out.println("------------------End of Test---------------------------");
    }
    //11. Get gender of id = 5471---not in my data. Changing as per my data
    @Test
    public void GetGenderOfId2272614(){
        List<?> getGenderOfId2272614 = response.extract().path("findAll{it.id==2272614}.gender");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Gender of ID 2272614 :" + getGenderOfId2272614);
        System.out.println("------------------End of Test---------------------------");
    }

}
