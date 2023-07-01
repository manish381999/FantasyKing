package com.tie.fantasyking.ui.Cricket;

import java.util.List;

public class MatchList_Model {

    private String status;
    private String message;
    List<HeavyDetails> data;

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

    public List<HeavyDetails> getData() {
        return data;
    }

    public void setData(List<HeavyDetails> data) {
        this.data = data;
    }

    public class HeavyDetails{
        private String id;
        private String img_team_a;
        private String img_team_b;
        private String name;
        private String tournament;
        private String date;
        private String time;
        private String quality;
        private String preview;
        private String statistics;
        private String team_a;
        private String team_b;
        private String team_a_playing_11;
        private String team_b_playing_11;
        private String captain;
        private String vc_captain;
        private String team_status;
        private String team_img;


        // Getter Methods

        public String getId() {
            return id;
        }

        public String getImg_team_a() {
            return img_team_a;
        }

        public String getImg_team_b() {
            return img_team_b;
        }

        public String getName() {
            return name;
        }

        public String getTournament() {
            return tournament;
        }

        public String getDate() {
            return date;
        }

        public String getTime() {
            return time;
        }

        public String getQuality() {
            return quality;
        }

        public String getPreview() {
            return preview;
        }

        public String getStatistics() {
            return statistics;
        }

        public String getTeam_a() {
            return team_a;
        }

        public String getTeam_b() {
            return team_b;
        }

        public String getTeam_a_playing_11() {
            return team_a_playing_11;
        }

        public String getTeam_b_playing_11() {
            return team_b_playing_11;
        }

        public String getCaptain() {
            return captain;
        }

        public String getVc_captain() {
            return vc_captain;
        }

        public String getTeam_status() {
            return team_status;
        }

        public String getTeam_img() {
            return team_img;
        }

        // Setter Methods

        public void setId(String id) {
            this.id = id;
        }

        public void setImg_team_a(String img_team_a) {
            this.img_team_a = img_team_a;
        }

        public void setImg_team_b(String img_team_b) {
            this.img_team_b = img_team_b;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setTournament(String tournament) {
            this.tournament = tournament;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public void setPreview(String preview) {
            this.preview = preview;
        }

        public void setStatistics(String statistics) {
            this.statistics = statistics;
        }

        public void setTeam_a(String team_a) {
            this.team_a = team_a;
        }

        public void setTeam_b(String team_b) {
            this.team_b = team_b;
        }

        public void setTeam_a_playing_11(String team_a_playing_11) {
            this.team_a_playing_11 = team_a_playing_11;
        }

        public void setTeam_b_playing_11(String team_b_playing_11) {
            this.team_b_playing_11 = team_b_playing_11;
        }

        public void setCaptain(String captain) {
            this.captain = captain;
        }

        public void setVc_captain(String vc_captain) {
            this.vc_captain = vc_captain;
        }

        public void setTeam_status(String team_status) {
            this.team_status = team_status;
        }

        public void setTeam_img(String team_img) {
            this.team_img = team_img;
        }
    }
}
