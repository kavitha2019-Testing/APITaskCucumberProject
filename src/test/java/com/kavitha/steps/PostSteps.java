package com.kavitha.steps;

import com.kavitha.client.PostApiClient;
import com.kavitha.client.data.Post;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

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
}



