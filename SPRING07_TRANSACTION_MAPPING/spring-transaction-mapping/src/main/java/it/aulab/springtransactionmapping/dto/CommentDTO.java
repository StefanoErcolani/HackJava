package it.aulab.springtransactionmapping.dto;

public class CommentDTO {
    private String body;
    private String postDate;
    private String postTitle;
    private String postPublishDate;

    public CommentDTO() {
    }
    
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getPostDate() {
        return postDate;
    }
    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }
    public String getPostTitle() {
        return postTitle;
    }
    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }
    public String getPostPublishDate() {
        return postPublishDate;
    }
    public void setPostPublishDate(String postPublishDate) {
        this.postPublishDate = postPublishDate;
    }
    
}
