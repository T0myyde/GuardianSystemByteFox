package ch.tom.bytefox.guardiansystembytefox.mysql.report;

import dev.brokenstudio.cloud.cloudplugin.CloudPlugin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReportRepositoryImp implements ReportRepository{



    @Override
    public void create(Report report) {
        try {
            Connection connection = CloudPlugin.api().getDeveloperDatabase().getMariaDBHandler().getSQLConnection().getDriverConnection();

            String sql = "INSERT INTO `reports` (uuid, open, reason) VALUES(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, report.getUuid());
            preparedStatement.setBoolean(2, report.isOpen());
            preparedStatement.setString(3, report.getReason());
            preparedStatement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Report report) {

    }

    @Override
    public void delete(Report report) {
        try {
            Connection connection = CloudPlugin.api().getDeveloperDatabase().getMariaDBHandler().getSQLConnection().getDriverConnection();
            String sql = "DELETE from `reports` WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, report.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Report get(int id) {
        Report user = new Report();
        try {
            Connection con = CloudPlugin.api().getDeveloperDatabase().getMariaDBHandler().getSQLConnection().getDriverConnection();
            String sql = "SELECT * FROM `reports` WHERE id=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUuid(rs.getString("uuid"));
                user.setOpen(rs.getBoolean("open"));
                user.setReason(rs.getString("reason"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Report get(String uuid) {
        Report user = new Report();
        try {
            Connection con = CloudPlugin.api().getDeveloperDatabase().getMariaDBHandler().getSQLConnection().getDriverConnection();
            String sql = "SELECT * FROM `reports` WHERE uuid=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, uuid);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUuid(rs.getString("uuid"));
                user.setOpen(rs.getBoolean("open"));
                user.setReason(rs.getString("reason"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public ArrayList<Report> getList() {
        ArrayList<Report> reports = new ArrayList<>();
        try {
            Connection connection = CloudPlugin.api().getDeveloperDatabase().getMariaDBHandler().getSQLConnection().getDriverConnection();
            String sql = "SELECT * FROM `reports`";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                reports.add(new Report(
                        rs.getString("uuid"),
                        rs.getBoolean("open"),
                        rs.getString("reason")
                        ));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return reports;
    }
}
