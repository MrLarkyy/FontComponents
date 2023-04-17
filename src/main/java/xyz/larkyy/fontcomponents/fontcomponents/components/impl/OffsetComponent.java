package xyz.larkyy.fontcomponents.fontcomponents.components.impl;

import org.bukkit.entity.Player;
import xyz.larkyy.fontcomponents.fontcomponents.Utils;
import xyz.larkyy.fontcomponents.fontcomponents.components.FontComponent;
import xyz.larkyy.fontcomponents.fontcomponents.components.HolderWidth;

public class OffsetComponent extends FontComponent {

    private final int offset;
    private final String text;
    private final String font;

    public OffsetComponent(String text, String font, int offset) {
        this.offset = offset;
        this.font = font;
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
        return Utils.toJson(text,font);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private int offset;
        private String text;
        private String font;

        private Builder() {

        }

        public Builder setFont(String font) {
            this.font = font;
            return this;
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
            return new OffsetComponent(text,font,offset);
        }
    }
}
