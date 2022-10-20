package ch.tom.bytefox.guardiansystembytefox.enums;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

public enum Reasons{

    HACKING(1),
    BUGUSING(2),
    TEAMING(3),
    SPAMING(4);
    private Integer id;
    Reasons(Integer value) {
        this.id = value;
    }
    public Integer getId() {
        return id;
    }
    @Nullable
    public static Reasons fromId(Integer id) {
        for (Reasons at : Reasons.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
    public static int getId(String enumCountryName) {
        return Reasons.valueOf(enumCountryName).getId();
    }
}
