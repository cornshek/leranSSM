package dao;

import bean.Hero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroDAO {
    public HeroDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java" +
                        "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8",
                "root", "12345677");
    }

    public int getTotal() {
        int total = 0;
        try (
                Connection c = getConnection();
                Statement s = c.createStatement();
        ) {
            String sql = "select count(*) from hero";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;

    }

    public void add(Hero hero) {
        String sql = "insert into hero values(null,?,?,?)";
        try (
                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1, hero.getName());
            ps.setFloat(2, hero.getHp());
            ps.setInt(3, hero.getDamage());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                hero.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(Hero hero) {
        String sql = "update hero set name=?, hp=?, damage=? where id=?";
        try (
                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1, hero.getName());
            ps.setFloat(2, hero.getHp());
            ps.setInt(3, hero.getDamage());
            ps.setInt(4, hero.getId());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(int id) {
        try (
                Connection c = getConnection();
                Statement s = c.createStatement();
        ) {

            String sql = "delete from hero where id = " + id;
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Hero get(int id) {
        Hero hero = null;

        try (
                Connection c = getConnection();
                Statement s = c.createStatement();
        ) {
            String sql = "select * from hero where id = " + id;
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                hero = new Hero();
                hero.setName(rs.getString("name"));
                hero.setHp(rs.getFloat("hp"));
                hero.setDamage(rs.getInt("damage"));
                hero.setId(rs.getInt("id"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hero;
    }

    public List<Hero> list() {
        return list(0, Integer.MAX_VALUE);
    }


    //start or startPage
    public List<Hero> list(int start, int count) {
        List<Hero> heroes = new ArrayList<>();
        String sql = "select * from hero order by id desc limit ?,?";
        try (
                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Hero hero = new Hero();

                hero.setName(rs.getString("name"));
                hero.setHp(rs.getFloat("hp"));
                hero.setDamage(rs.getInt("damage"));
                hero.setId(rs.getInt("id"));

                heroes.add(hero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return heroes;
    }
}
