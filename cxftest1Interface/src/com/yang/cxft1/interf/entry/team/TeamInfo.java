package com.yang.cxft1.interf.entry.team;

import java.util.List;
import java.util.Map;

/**
 * Created by ASUS on 2017/5/19.
 */
public class TeamInfo {

    private Team[] teams;

    private List<Team> teamList;

    private Map<String, Team> teamMap;

    public Team[] getTeams() {
        return teams;
    }

    public void setTeams(Team[] teams) {
        this.teams = teams;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    public Map<String, Team> getTeamMap() {
        return teamMap;
    }

    public void setTeamMap(Map<String, Team> teamMap) {
        this.teamMap = teamMap;
    }
}
