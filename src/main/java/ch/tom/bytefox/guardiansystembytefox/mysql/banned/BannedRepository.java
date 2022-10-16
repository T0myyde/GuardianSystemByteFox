package ch.tom.bytefox.guardiansystembytefox.mysql.banned;

import ch.tom.bytefox.guardiansystembytefox.mysql.report.Report;

import java.util.ArrayList;

public interface BannedRepository {

    void create(Banned banned);
    void update(Banned banned);
    void delete(Banned banned);
    Banned get(int id);
    Banned get(String uuid);
    ArrayList<Banned> getList();
}
