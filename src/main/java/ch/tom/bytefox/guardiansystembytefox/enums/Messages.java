package ch.tom.bytefox.guardiansystembytefox.enums;

public enum Messages {
    PREFIX("§c§lGuardian §8§l| §r§7"),
    NO_PERMISSIONS_MESSAGE(PREFIX + "§cDu hast keine Berechtigung für diesen Befehl.");

    private String messages;

    Messages(String message) {
        this.messages = message;
    }

    public String getMessages() {
        return messages;
    }
}
