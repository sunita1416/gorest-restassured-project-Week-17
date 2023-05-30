package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PostsExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";

        response = given()
                .when()
                .queryParam("page", "1")
                .queryParam("per_page", "20")
                .get("/posts?page=1&per_page=25")
                .then().statusCode(200);
    }

    //1. Extract the title
    @Test
    public void ExtractTheTitle() {
        List<Object> title = response.extract().path("title");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Title are : " + title);
        System.out.println("------------------End of Test---------------------------");
    }
    //2. Extract the total number of record
    @Test
    public void ExtractTotalNumberOfRecord(){
        List<Object> totalRecord = response.extract().path("record");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total records are : " + totalRecord.size());
        System.out.println("------------------End of Test---------------------------");
    }
    //3. Extract the body of 15th record
    @Test
    public void ExtractBodyOf15thRecord(){
        String body = response.extract().path("[14].body");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Body of 15th Record : " + body);
        System.out.println("------------------End of Test---------------------------");
    }
    //4. Extract the user_id of all the records
    @Test
    public void ExtractUserIdOfAllRecords(){
        List<Object> userId = response.extract().path("user_id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total records are : " + userId);
        System.out.println("------------------End of Test---------------------------");
    }
    //5. Extract the title of all the records
    @Test
    public void ExtractTitleOFAllRecords(){
        List<Object> title = response.extract().path("title");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total Title are : " + title);
        System.out.println("------------------End of Test---------------------------");
    }
//6. Extract the title of all records whose user_id = 5456-------Changing as per my data
    @Test
    public void ExtractTitleOfAllRecordsWithUserId2272670(){
        List<?> allRecords = response.extract().path("findAll{it.user_id==2272663}.record");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("UserId Record : " + allRecords);
        System.out.println("------------------End of Test---------------------------");
    }
    //7. Extract the body of all records whose id = 2671-----------Changing as per my data
    @Test
    public void ExtractBodyOfAllRecordWhoseId2272653(){
        List<?> allRecordWhoseID2272653 = response.extract().path("findAll{it.id==2272653}.body");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("UserId Record Body : " + allRecordWhoseID2272653);
        System.out.println("------------------End of Test---------------------------");
    }
}
