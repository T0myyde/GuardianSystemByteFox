package ch.tom.bytefox.guardiansystembytefox.mysql.report;

public class Report {

    private int id;
    private String uuid;
    private String target_uuid;
    private boolean open;
    private String reason;

    public Report(String uuid, String target_uuid, boolean open, String reason) {
        this.uuid = uuid;
        this.target_uuid = target_uuid;
        this.open = open;
        this.reason = reason;
    }

    public Report() {
    }

    public String getTarget_uuid() {
        return target_uuid;
    }

    public void setTarget_uuid(String target_uuid) {
        this.target_uuid = target_uuid;
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
