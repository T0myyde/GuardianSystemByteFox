package ch.tom.bytefox.guardiansystembytefox.enums;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

public enum Reasons{

    HACKING(1),
    BUGUSING(2),
    TEAMING(3),
    SPAMING(4),
    TEST(5),
    JANSTINKT(6);
    private Integer id;
    private static Reasons[] list = Reasons.values();
    Reasons(Integer value) {
        this.id = value;
    }
    public Integer getId() {
        return id;
    }
    public static int listGetLastIndex() {
        return list.length - 1;
    }

    public static String getById(int id) {
        String reason = null;

        for(Reasons e : values()) {
            if(e.id.equals(id)){
                reason = e.toString();
            }
        }
        return reason;
    }
    public static int getId(String enumName) {
        return Reasons.valueOf(enumName).getId();
    }
}
