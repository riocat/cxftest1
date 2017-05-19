package com.yang.cxft1.cxf.service.impl;

import com.yang.cxft1.interf.entry.team.Team;
import com.yang.cxft1.interf.entry.team.TeamInfo;
import com.yang.cxft1.interf.service.TeamService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.*;

/**
 * Created by ASUS on 2017/5/19.
 */
@WebService(targetNamespace = "http://service.interf.cxft1.yang.com/", portName = "TeamServicePort",
        endpointInterface = "com.yang.cxft1.interf.service.TeamService")
@Component
public class TeamServiceImpl implements TeamService {

    @Override
    public Team getTeam() {
        Team team = new Team();
        team.setId(0);
        team.setTname("patriots");
        team.setCreateDate(new Date());
        return team;
    }

    @Override
    public TeamInfo getTeams() {
        TeamInfo ti = new TeamInfo();
        Team team1 = new Team();
        team1.setId(1);
        team1.setTname("seahawks");
        Team team2 = new Team();
        team2.setId(2);
        team2.setTname("eagles");

        Team[] teams = new Team[]{team1, team2};
        ti.setTeams(teams);
        return ti;
    }

    @Override
    public TeamInfo getTeamList() {
        TeamInfo ti = new TeamInfo();

        List<Team> list = new ArrayList<Team>();
        Team team1 = new Team();
        team1.setId(3);
        team1.setTname("ravens");
        list.add(team1);
        Team team2 = new Team();
        team2.setId(4);
        team2.setTname("packers");
        list.add(team2);

        ti.setTeamList(list);
        return ti;
    }

    @Override
    public TeamInfo getTeamMap() {
        TeamInfo ti = new TeamInfo();

        Map<String,Team> map = new HashMap<String,Team>();
        Team team1 = new Team();
        team1.setId(5);
        team1.setTname("ravens");
        team1.setCreateDate(new Date());
        map.put("a",team1);
        Team team2 = new Team();
        team2.setId(6);
        team2.setTname("packers");
        team2.setCreateDate(new Date());
        map.put("b",team2);

        ti.setTeamMap(map);
        return ti;
    }
}
