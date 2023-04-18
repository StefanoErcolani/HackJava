package it.aulab.springthymeleaf.dto;

public class CommentDTO {
    
    private Long id;

    private String email;

    private String postDate;

    private String postTitle;

    private String postPublishDate;

    public CommentDTO() {
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
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
