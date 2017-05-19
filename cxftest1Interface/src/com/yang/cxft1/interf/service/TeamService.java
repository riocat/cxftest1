package com.yang.cxft1.interf.service;

import com.yang.cxft1.interf.entry.team.Team;
import com.yang.cxft1.interf.entry.team.TeamInfo;

import javax.jws.WebService;
import java.util.List;
import java.util.Map;

/**
 * Created by ASUS on 2017/5/19.
 */
@WebService
public interface TeamService {

    public Team getTeam();
    public TeamInfo getTeams();
    public TeamInfo getTeamList();
    public TeamInfo getTeamMap();
}
