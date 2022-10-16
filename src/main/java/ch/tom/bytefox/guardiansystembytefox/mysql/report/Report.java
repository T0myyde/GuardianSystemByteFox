package ch.tom.bytefox.guardiansystembytefox.mysql.report;

public class Report {

    private int id;
    private String uuid;
    private boolean open;
    private String reason;

    public Report(String uuid, boolean open, String reason) {
        this.uuid = uuid;
        this.open = open;
        this.reason = reason;
    }

    public Report() {
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

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
