package it.aulab.springthymeleaf.dto;

public class CreateCommentDTO {
    
        private String email;
        private String body;
        private String postDate;
        private Long PostId;

        public CreateCommentDTO () {}

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
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

        public Long getPostId() {
            return PostId;
        }

        public void setPostId(Long postId) {
            PostId = postId;
        }
}
