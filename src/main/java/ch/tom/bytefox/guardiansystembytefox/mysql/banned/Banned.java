package ch.tom.bytefox.guardiansystembytefox.mysql.banned;

public class Banned {

    private int id;
    private String uuid;
    private int banned_time;

    private String reason;

    public Banned(int id, String uuid, int banned_time, String reason) {
        this.id = id;
        this.uuid = uuid;
        this.banned_time = banned_time;
        this.reason = reason;
    }

    public Banned(String uuid, int banned_time, String reason) {
        this.uuid = uuid;
        this.banned_time = banned_time;
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Banned() {
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

    public int getBanned_time() {
        return banned_time;
    }

    public void setBanned_time(int banned_time) {
        this.banned_time = banned_time;
    }
}
