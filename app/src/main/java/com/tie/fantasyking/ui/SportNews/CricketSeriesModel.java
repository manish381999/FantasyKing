package com.tie.fantasyking.ui.SportNews;

import java.util.List;

public class CricketSeriesModel {

    private String apikey;
    List<LightDetails> data;

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public List<LightDetails> getData() {
        return data;
    }

    public void setData(List<LightDetails> data) {
        this.data = data;
    }

    public class LightDetails{
        private String id;
        private String name;
        private String startDate;
        private String endDate;
        private float odi;
        private float t20;
        private float test;
        private float squads;
        private float matches;


        // Getter Methods

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getStartDate() {
            return startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public float getOdi() {
            return odi;
        }

        public float getT20() {
            return t20;
        }

        public float getTest() {
            return test;
        }

        public float getSquads() {
            return squads;
        }

        public float getMatches() {
            return matches;
        }

        // Setter Methods

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public void setOdi(float odi) {
            this.odi = odi;
        }

        public void setT20(float t20) {
            this.t20 = t20;
        }

        public void setTest(float test) {
            this.test = test;
        }

        public void setSquads(float squads) {
            this.squads = squads;
        }

        public void setMatches(float matches) {
            this.matches = matches;
        }
    }
}
