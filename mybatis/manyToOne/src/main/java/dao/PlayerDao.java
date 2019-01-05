package dao;

import bean.Player;

import java.util.List;

interface PlayerDao {
    Player selectPlayerById(int id);
    List<Player> selectAllPlayers();
}
