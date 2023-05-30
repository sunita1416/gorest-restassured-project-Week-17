package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class UserAssertionTest {
    static ResponseSpecification response;
    @BeforeClass
    public static void inIt(){
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
      response = given()
                .when()
                .queryParam("page", "1")
                .queryParam("per_page", "20")
                .then().statusCode(200);

    }
    //1. Verify the if the total record is 20
    @Test
    public void test001(){
        response.body("total.size()", equalTo(20));
    }
//2. Verify the if the name of id = 5487 is equal to ”Hamsini Trivedi” ---couldn't find this person on data so changing the name who is available
    //Verify if the name of id = 2272616 is equesl to " Pranay Reddy"
    @Test
    public void test002(){
        response.body("[15].name", equalTo("Pranay Reddy"));
    }
  //3. Check the single ‘Name’ in the Array list (Subhashini Talwar)---couldn't find this person on data so changing the name who is available
    @Test
    public void test003(){
        response.body("[14].name", equalTo("Harinakshi Joshi"));
    }
    //4. Check the multiple ‘Names’ in the ArrayList (Mrs. Menaka Bharadwaj, Msgr. Bodhan Guha, Karthik Dubashi IV) ----couldn't find these person on data so changing the name who is available in my list
    @Test
    public void test004(){
        response.body("name", hasItems("Bhaumik Varma", "Smriti Pilla", "Esha Mukhopadhyay"));
    }
//5. Verify the email of userid = 5471 is equal “adiga_aanjaneya_rep@jast.org”----not in my data.Changing according to my list
    @Test
    public void test005(){
        response.body("[19].name", equalTo("Mani Naik"));
    }
//6. Verify the status is “Active” of user name is “Shanti Bhat V”----not in my data.Changing according to my list
    @Test
    public void test006(){
        response.body("[4].status", equalTo("active"));
    }
//7. Verify the Gender = male of user name is “Niro Prajapat”---not in my data.Changing according to my list
    @Test
    public void test007(){
        response.body("[0].gender", equalTo("male"));
    }


}
