package ch.tom.bytefox.guardiansystembytefox.mysql.banned;

import ch.tom.bytefox.guardiansystembytefox.mysql.report.Report;
import dev.brokenstudio.cloud.cloudplugin.CloudPlugin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BannedRepositoryImp implements BannedRepository {



    @Override
    public void create(Banned banned) {
        try {
            Connection connection = CloudPlugin.api().getDeveloperDatabase().getMariaDBHandler().getSQLConnection().getDriverConnection();

            String sql = "INSERT INTO `banned` (uuid, banned_time, reason) VALUES(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, banned.getUuid());
            preparedStatement.setInt(2, banned.getBanned_time());
            preparedStatement.setString(3, banned.getReason());
            preparedStatement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Banned banned) {

    }

    @Override
    public void delete(Banned banned) {
        try {
            Connection connection = CloudPlugin.api().getDeveloperDatabase().getMariaDBHandler().getSQLConnection().getDriverConnection();
            String sql = "DELETE from `banned` WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, banned.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Banned get(int id) {
        Banned user = new Banned();
        try {
            Connection con = CloudPlugin.api().getDeveloperDatabase().getMariaDBHandler().getSQLConnection().getDriverConnection();
            String sql = "SELECT * FROM `banned` WHERE id=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUuid(rs.getString("uuid"));
                user.setBanned_time(rs.getInt("banned_time"));
                user.setReason(rs.getString("reason"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Banned get(String uuid) {
        Banned user = new Banned();
        try {
            Connection con = CloudPlugin.api().getDeveloperDatabase().getMariaDBHandler().getSQLConnection().getDriverConnection();
            String sql = "SELECT * FROM `banned` WHERE uuid=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, uuid);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUuid(rs.getString("uuid"));
                user.setBanned_time(rs.getInt("banned_time"));
                user.setReason(rs.getString("reason"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public ArrayList<Banned> getList() {
        ArrayList<Banned> reports = new ArrayList<>();
        try {
            Connection connection = CloudPlugin.api().getDeveloperDatabase().getMariaDBHandler().getSQLConnection().getDriverConnection();
            String sql = "SELECT * FROM `banned`";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                reports.add(new Banned(
                        rs.getInt("id"),
                        rs.getString("uuid"),
                        rs.getInt("banned_time"),
                        rs.getString("reason")
                        ));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return reports;
    }
}
