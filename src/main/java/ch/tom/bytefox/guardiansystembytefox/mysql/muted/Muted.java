package ch.tom.bytefox.guardiansystembytefox.mysql.muted;

public class Muted {

    private int id;
    private String uuid;
    private int muted_time;

    private String reason;

    public Muted(int id, String uuid, int banned_time, String reason) {
        this.id = id;
        this.uuid = uuid;
        this.muted_time = banned_time;
        this.reason = reason;
    }

    public Muted(String uuid, int banned_time, String reason) {
        this.uuid = uuid;
        this.muted_time = banned_time;
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Muted() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getMuted_time() {
        return muted_time;
    }

    public void setMuted_time(int muted_time) {
        this.muted_time = muted_time;
    }
}
