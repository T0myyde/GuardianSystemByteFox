package ch.tom.bytefox.guardiansystembytefox.mysql.muted;

import dev.brokenstudio.cloud.cloudplugin.CloudPlugin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MutedRepositoryImp implements MutedRepository {



    @Override
    public void create(Muted muted) {
        try {
            Connection connection = CloudPlugin.api().getDeveloperDatabase().getMariaDBHandler().getSQLConnection().getDriverConnection();

            String sql = "INSERT INTO `muted` (uuid, muted_time, reason) VALUES(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, muted.getUuid());
            preparedStatement.setInt(2, muted.getMuted_time());
            preparedStatement.setString(3, muted.getReason());
            preparedStatement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Muted muted) {

    }

    @Override
    public void delete(Muted muted) {
        try {
            Connection connection = CloudPlugin.api().getDeveloperDatabase().getMariaDBHandler().getSQLConnection().getDriverConnection();
            String sql = "DELETE from `muted` WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, muted.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Muted get(int id) {
        Muted user = new Muted();
        try {
            Connection con = CloudPlugin.api().getDeveloperDatabase().getMariaDBHandler().getSQLConnection().getDriverConnection();
            String sql = "SELECT * FROM `muted` WHERE id=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUuid(rs.getString("uuid"));
                user.setMuted_time(rs.getInt("muted_time"));
                user.setReason(rs.getString("reason"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Muted get(String uuid) {
        Muted user = new Muted();
        try {
            Connection con = CloudPlugin.api().getDeveloperDatabase().getMariaDBHandler().getSQLConnection().getDriverConnection();
            String sql = "SELECT * FROM `muted` WHERE uuid=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, uuid);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUuid(rs.getString("uuid"));
                user.setMuted_time(rs.getInt("muted_time"));
                user.setReason(rs.getString("reason"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public ArrayList<Muted> getList() {
        ArrayList<Muted> reports = new ArrayList<>();
        try {
            Connection connection = CloudPlugin.api().getDeveloperDatabase().getMariaDBHandler().getSQLConnection().getDriverConnection();
            String sql = "SELECT * FROM `muted`";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                reports.add(new Muted(
                        rs.getInt("id"),
                        rs.getString("uuid"),
                        rs.getInt("muted_time"),
                        rs.getString("reason")
                        ));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return reports;
    }
}
