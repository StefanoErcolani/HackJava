package it.aulab.springtransactionmapping.dto;

// import it.aulab.springtransactionmapping.model.Post;

public class PostDTO {
    private String title;
    private String body;
    private String authorFirstname;
    private String authorLastname;

    public PostDTO () {}

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthorFirstname() {
        return authorFirstname;
    }

    public void setAuthorFirstname(String authorFirstname) {
        this.authorFirstname = authorFirstname;
    }

    public String getAuthorLastname() {
        return authorLastname;
    }

    public void setAuthorLastname(String authorLastname) {
        this.authorLastname = authorLastname;
    }
}
