package ch.tom.bytefox.guardiansystembytefox.mysql.report;

import java.util.ArrayList;

public interface ReportRepository {

    void create(Report report);
    void update(Report report);
    void delete(Report report);
    Report get(int id);
    Report get(String uuid);
    ArrayList<Report> getList();
}
