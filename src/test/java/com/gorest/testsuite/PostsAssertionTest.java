package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class PostsAssertionTest {
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

    // 1. Verify the if the total record is 25
    @Test
    public void test001() {
        response.body("total.size()", equalTo(25));
    }

    //2. Verify the if the title of id = 2730 is equal to ”Ad ipsa coruscus ipsam eos demitto centum." ---changing according to my data
    @Test
    public void test002() {
        response.body("[12].title", equalTo("Coma stultus substantia accedo tutis."));
    }

    //3. Check the single user_id in the Array list (5522)---Changing as per my data
    @Test
    public void test003() {
        response.body("[1].user_id", equalTo(2272684));
    }
    //4. Check the multiple ids in the ArrayList (2693, 2684,2681) ---Changing as per my data
    @Test
    public void test004(){
        response.body("id",hasItems(39264,39276,39280));
    }
    //5. Verify the body of userid = 2678 is equal “Carus eaque voluptatem. Calcar
    //spectaculum coniuratio. Abstergo consequatur deleo. Amiculum advenio dolorem.
    //Sollers conservo adiuvo. Concedo campana capitulus. Adfectus tibi truculenter.
    //Canto temptatio adimpleo. Ter degenero animus. Adeo optio crapula. Abduco et
    //antiquus. Chirographum baiulus spoliatio. Suscipit fuga deleo. Comburo aequus
    //cuppedia. Crur cuppedia voluptates. Argentum adduco vindico. Denique undique
    //adflicto. Assentator umquam pel."”-----Changing as per my data
    @Test
    public void test005(){
        response.body("[3].body", equalTo("Caterva adsuesco crepusculum. Aestus ea tantillus. Aggero demo summopere. Benevolentia strues timidus. Cena absens trans. Adfero iure curis. Ut vulnero cum. Dolorem cogito ut. Cupiditas acquiro benevolentia. Color armo terebro. Aqua defero cernuus. Asperiores explicabo aegre. Commodi caste curia. Blanditiis constans velit. Expedita laborum vaco. Dens anser attollo. Cerno quis quis. Eum armarium consequatur."));
    }

}