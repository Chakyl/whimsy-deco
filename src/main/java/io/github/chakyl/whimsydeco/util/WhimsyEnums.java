package io.github.chakyl.whimsydeco.util;

import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import org.jetbrains.annotations.NotNull;

public class WhimsyEnums {
    public enum SofaType implements StringRepresentable {
        DISLAY("display"),
        MIDDLE("middle"),
        LEFT("left"),
        RIGHT("right");

        private final String name;

        SofaType(String type) {
            this.name = type;
        }

        @Override
        public @NotNull String getSerializedName() {
            return this.name;
        }
    }

    public static final EnumProperty<SofaType> SOFA_TYPE;

    static {
        SOFA_TYPE = EnumProperty.create("type", SofaType.class);
    }
}