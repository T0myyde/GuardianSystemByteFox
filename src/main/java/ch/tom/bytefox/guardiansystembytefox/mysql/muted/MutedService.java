package ch.tom.bytefox.guardiansystembytefox.mysql.muted;

import java.util.ArrayList;

public class MutedService implements MutedRepository {

    private MutedRepositoryImp repository = new MutedRepositoryImp();

    @Override
    public void create(Muted banned) {
        this.repository.create(banned);
    }

    @Override
    public void update(Muted banned) {
        this.repository.update(banned);
    }

    @Override
    public void delete(Muted banned) {
        this.repository.delete(banned);
    }

    @Override
    public Muted get(int id) {
        Muted banned = this.repository.get(id);
        if (banned.getId() != 0) {
            return banned;
        } else {
            return null;
        }
    }

    @Override
    public Muted get(String uuid) {
        Muted banned = this.repository.get(uuid);
        if (banned.getId() != 0) {
            return banned;
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Muted> getList() {
        return this.repository.getList();
    }
}
