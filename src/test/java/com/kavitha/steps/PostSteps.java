package com.kavitha.steps;

import com.kavitha.client.PostApiClient;
import com.kavitha.client.data.Post;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import org.junit.Assert;

import java.util.Arrays;

public class PostSteps {

    private Post post;
    private Response response;

    @Given("I have details of a Post")
    public void i_have_details_of_a_Post() {
        post = new Post();
        post.setUserId(200);
        post.setTitle("Foo1");
        post.setBody("Bar1");
    }


    @When("I create a Post")
    public void i_create_a_Post() {
        PostApiClient postApiClient = new PostApiClient();
        response = postApiClient.createPost(post);
//
//        response =  given().log().all()
//                .contentType("application/json; charset=utf-8")
//                .body(post)
//                .when()
//                .post("http://jsonplaceholder.typicode.com/posts")
//                .then()
//                .extract().response();
    }

    @Then("Post should be created")
    public void post_should_be_created() {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(201, actualStatusCode);
        Post actualPost = response.as(Post.class);
        Assert.assertEquals(post.getUserId(), actualPost.getUserId());
        Assert.assertEquals(post.getTitle(), actualPost.getTitle());
        Assert.assertEquals(post.getBody(), actualPost.getBody());
    }


    @When("I request details of all Posts")
    public void i_request_details_of_a_Post() {
        PostApiClient postApiClient = new PostApiClient();
        response = postApiClient.getPosts();

    }

    @Then("the details of all Posts should be returned")
    public void post_details_should_be_returned() {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(200, actualStatusCode);
        Post[] postArray = response.as(Post[].class);
//        Arrays.stream(postArray).forEach(System.out::println);
        Assert.assertTrue(postArray.length > 0);
    }
}



