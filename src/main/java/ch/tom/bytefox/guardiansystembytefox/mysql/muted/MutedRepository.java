package ch.tom.bytefox.guardiansystembytefox.mysql.muted;

import java.util.ArrayList;

public interface MutedRepository {

    void create(Muted banned);
    void update(Muted banned);
    void delete(Muted banned);
    Muted get(int id);
    Muted get(String uuid);
    ArrayList<Muted> getList();
}
