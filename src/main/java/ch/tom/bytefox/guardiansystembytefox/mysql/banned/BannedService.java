package ch.tom.bytefox.guardiansystembytefox.mysql.banned;

import ch.tom.bytefox.guardiansystembytefox.mysql.report.Report;

import java.util.ArrayList;

public class BannedService implements BannedRepository {

    private BannedRepositoryImp repository = new BannedRepositoryImp();

    @Override
    public void create(Banned banned) {
        this.repository.create(banned);
    }

    @Override
    public void update(Banned banned) {
        this.repository.update(banned);
    }

    @Override
    public void delete(Banned banned) {
        this.repository.delete(banned);
    }

    @Override
    public Banned get(int id) {
        Banned banned = this.repository.get(id);
        if (banned.getId() != 0) {
            return banned;
        } else {
            return null;
        }
    }

    @Override
    public Banned get(String uuid) {
        Banned banned = this.repository.get(uuid);
        if (banned.getId() != 0) {
            return banned;
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Banned> getList() {
        return this.repository.getList();
    }
}
