package com.tie.fantasyking.ui.SportNews;

import java.util.List;

public class CricketSeriesInfoModel {
    private String apikey;
    private Data data;
    private String status;
    private Info info;

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public static class Data {
        private Info info;
        private List<MatchList> matchList;

        public Info getInfo() {
            return info;
        }

        public void setInfo(Info info) {
            this.info = info;
        }

        public List<MatchList> getMatchList() {
            return matchList;
        }

        public void setMatchList(List<MatchList> matchList) {
            this.matchList = matchList;
        }
    }

    public static class Info {
        private int hitsToday;
        private int hitsUsed;
        private int hitsLimit;
        private int credits;
        private int server;
        private double queryTime;
        private int s;
        private int cache;

        public int getHitsToday() {
            return hitsToday;
        }

        public void setHitsToday(int hitsToday) {
            this.hitsToday = hitsToday;
        }

        public int getHitsUsed() {
            return hitsUsed;
        }

        public void setHitsUsed(int hitsUsed) {
            this.hitsUsed = hitsUsed;
        }

        public int getHitsLimit() {
            return hitsLimit;
        }

        public void setHitsLimit(int hitsLimit) {
            this.hitsLimit = hitsLimit;
        }

        public int getCredits() {
            return credits;
        }

        public void setCredits(int credits) {
            this.credits = credits;
        }

        public int getServer() {
            return server;
        }

        public void setServer(int server) {
            this.server = server;
        }

        public double getQueryTime() {
            return queryTime;
        }

        public void setQueryTime(double queryTime) {
            this.queryTime = queryTime;
        }

        public int getS() {
            return s;
        }

        public void setS(int s) {
            this.s = s;
        }

        public int getCache() {
            return cache;
        }

        public void setCache(int cache) {
            this.cache = cache;
        }
    }

    public static class MatchList {
        private String id;
        private String name;
        private String matchType;
        private String status;
        private String venue;
        private String date;
        private String dateTimeGMT;
        private List<String> teams;
        private List<TeamInfo> teamInfo;
        private boolean fantasyEnabled;
        private boolean bbbEnabled;
        private boolean hasSquad;
        private boolean matchStarted;
        private boolean matchEnded;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMatchType() {
            return matchType;
        }

        public void setMatchType(String matchType) {
            this.matchType = matchType;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getVenue() {
            return venue;
        }

        public void setVenue(String venue) {
            this.venue = venue;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDateTimeGMT() {
            return dateTimeGMT;
        }

        public void setDateTimeGMT(String dateTimeGMT) {
            this.dateTimeGMT = dateTimeGMT;
        }

        public List<String> getTeams() {
            return teams;
        }

        public void setTeams(List<String> teams) {
            this.teams = teams;
        }

        public List<TeamInfo> getTeamInfo() {
            return teamInfo;
        }

        public void setTeamInfo(List<TeamInfo> teamInfo) {
            this.teamInfo = teamInfo;
        }

        public boolean isFantasyEnabled() {
            return fantasyEnabled;
        }

        public void setFantasyEnabled(boolean fantasyEnabled) {
            this.fantasyEnabled = fantasyEnabled;
        }

        public boolean isBbbEnabled() {
            return bbbEnabled;
        }

        public void setBbbEnabled(boolean bbbEnabled) {
            this.bbbEnabled = bbbEnabled;
        }

        public boolean isHasSquad() {
            return hasSquad;
        }

        public void setHasSquad(boolean hasSquad) {
            this.hasSquad = hasSquad;
        }

        public boolean isMatchStarted() {
            return matchStarted;
        }

        public void setMatchStarted(boolean matchStarted) {
            this.matchStarted = matchStarted;
        }

        public boolean isMatchEnded() {
            return matchEnded;
        }

        public void setMatchEnded(boolean matchEnded) {
            this.matchEnded = matchEnded;
        }
    }

    public static class TeamInfo {
        private String name;
        private String shortname;
        private String img;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getShortname() {
            return shortname;
        }

        public void setShortname(String shortname) {
            this.shortname = shortname;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }
    }
}
