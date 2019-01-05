package dao;

import bean.Player;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.MyBatisUtil;

import java.util.List;

import static org.junit.Assert.*;

public class PlayerDaoTest {

    private SqlSession sqlSession;
    private PlayerDao playerDao;

    @Before
    public void setUp() throws Exception {
        sqlSession = MyBatisUtil.getSqlSession();
        playerDao = sqlSession.getMapper(PlayerDao.class);
    }

    @After
    public void tearDown() throws Exception {
        sqlSession.close();
    }

    @Test
    public void selectPlayerById() {
        Player player = playerDao.selectPlayerById(1);
        System.out.println(player);
    }

    @Test
    public void selectAllPlayers() {
        List<Player> players = playerDao.selectAllPlayers();
        players.forEach(System.out::println);
    }
}