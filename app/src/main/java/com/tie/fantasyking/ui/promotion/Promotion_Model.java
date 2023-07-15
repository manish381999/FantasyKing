package com.tie.fantasyking.ui.promotion;


import java.util.List;

public class Promotion_Model {
    private String status;
    private String message;
    List<LightDetails> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<LightDetails> getData() {
        return data;
    }

    public void setData(List<LightDetails> data) {
        this.data = data;
    }

    public class LightDetails{
        private String id;
        private String img_promotion;
        private String link;


        // Getter Methods

        public String getId() {
            return id;
        }

        public String getImg_promotion() {
            return img_promotion;
        }

        public String getLink() {
            return link;
        }

        // Setter Methods

        public void setId(String id) {
            this.id = id;
        }

        public void setImg_promotion(String img_promotion) {
            this.img_promotion = img_promotion;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }
}

