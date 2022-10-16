package ch.tom.bytefox.guardiansystembytefox.mysql.report;

import java.util.ArrayList;

public class ReportService implements ReportRepository{

    private ReportRepositoryImp repository = new ReportRepositoryImp();

    @Override
    public void create(Report report) {
        this.repository.create(report);
    }

    @Override
    public void update(Report report) {
        this.repository.update(report);
    }

    @Override
    public void delete(Report report) {
        this.repository.delete(report);
    }

    @Override
    public Report get(int id) {
        Report report = this.repository.get(id);
        if (report.getId() != 0) {
            return report;
        } else {
            return null;
        }
    }

    @Override
    public Report get(String uuid) {
        Report report = this.repository.get(uuid);
        if (report.getId() != 0) {
            return report;
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Report> getList() {
        return this.repository.getList();
    }
}
