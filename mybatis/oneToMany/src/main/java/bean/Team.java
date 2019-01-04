package bean;

import java.util.List;

public class Team {
    private int id;
    private String name;
    private List<Player> playerList;

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", playerList=" + playerList +
                '}';
    }

//    public Team(int id, String name, List<Player> playerList) {
//        this.id = id;
//        this.name = name;
//        this.playerList = playerList;
//    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
