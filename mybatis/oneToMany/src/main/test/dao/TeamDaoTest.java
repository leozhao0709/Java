package dao;

import bean.Team;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.MyBatisUtil;

public class TeamDaoTest {

    private SqlSession sqlSession;
    private TeamDao teamDao;

    @Before
    public void setUp() throws Exception {
        sqlSession = MyBatisUtil.getSqlSession();
        teamDao = sqlSession.getMapper(TeamDao.class);
    }

    @After
    public void tearDown() throws Exception {
        sqlSession.close();
    }

    @Test
    public void selectTeamById() {
        Team team = teamDao.selectTeamById(2);
        System.out.println(team);
    }
}