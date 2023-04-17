package xyz.larkyy.fontcomponents.fontcomponents.components.impl;

import org.bukkit.entity.Player;
import xyz.larkyy.fontcomponents.fontcomponents.components.FontComponent;
import xyz.larkyy.fontcomponents.fontcomponents.components.HolderWidth;

public class OffsetComponent extends FontComponent {

    private final int offset;
    private final String text;

    public OffsetComponent(String text, int offset) {
        this.offset = offset;
        this.text = text;
    }

    public int getOffset() {
        return offset;
    }

    public String getText() {
        return text;
    }

    @Override
    public String generate(Player player, HolderWidth width) {
        width.add(offset);
        return null;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private int offset;
        private String text;

        private Builder() {

        }

        public Builder setOffset(int offset) {
            this.offset = offset;
            return this;
        }
        public Builder setText(String text) {
            this.text = text;
            return this;
        }
        public OffsetComponent build() {
            return new OffsetComponent(text,offset);
        }
    }
}
