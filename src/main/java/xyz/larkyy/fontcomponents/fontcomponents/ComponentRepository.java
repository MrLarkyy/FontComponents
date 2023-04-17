package xyz.larkyy.fontcomponents.fontcomponents;

import org.bukkit.Bukkit;
import xyz.larkyy.fontcomponents.fontcomponents.components.FontComponent;
import xyz.larkyy.fontcomponents.fontcomponents.components.HolderWidth;
import xyz.larkyy.fontcomponents.fontcomponents.components.impl.OffsetComponent;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ComponentRepository {

    private final Map<String,FontComponent> components = new HashMap<>();
    private final TreeMap<Integer, OffsetComponent> offsetComponents = new TreeMap<>();

    public void addComponent(String id, FontComponent component) {
        this.components.put(id,component);
    }

    public void addOffset(int offset, OffsetComponent offsetComponent) {
        this.offsetComponents.put(offset,offsetComponent);
    }

    public FontComponent getComponent(String id) {
        return components.get(id);
    }

    public OffsetComponent getOffset(int offset) {
        return offsetComponents.get(offset);
    }

    public String generateNegativeOffset(int offset, HolderWidth width) {
        if (offsetComponents.isEmpty()) {
            return "";
        }
        Integer lowest = offsetComponents.firstKey();
        if (lowest == null) {
            return "";
        }
        if (lowest >= 0) {
            return "";
        }
        OffsetComponent offsetComponent = getOffset(offset);
        if (offsetComponent !=null) {
            return offsetComponent.generate(null,width);
        }
        int alreadyGenerated = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while(alreadyGenerated > offset) {
            stringBuilder.append(",");
            OffsetComponent nearestOffset;

            offsetComponent = getOffset(offset-alreadyGenerated);
            if (offsetComponent !=null) {
                nearestOffset = offsetComponent;
            } else {
                nearestOffset = getNearestOffset(offset-alreadyGenerated);
            }
            alreadyGenerated += nearestOffset.getOffset();
            stringBuilder.append(nearestOffset.generate(null,width));
        }
        return stringBuilder.toString();
    }

    public String generateOffset(int offset, HolderWidth width) {
        if (offset < 0) {
            return generateNegativeOffset(offset,width);
        }
        if (offsetComponents.isEmpty()) {
            return "";
        }
        OffsetComponent offsetComponent = getOffset(offset);
        if (offsetComponent !=null) {
            return offsetComponent.generate(null,width);
        }
        int alreadyGenerated = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while(alreadyGenerated < offset) {
            stringBuilder.append(",");
            OffsetComponent nearestOffset;

            offsetComponent = getOffset(offset-alreadyGenerated);
            if (offsetComponent !=null) {
                nearestOffset = offsetComponent;
            } else {
                nearestOffset = getNearestOffset(offset-alreadyGenerated);
            }
            alreadyGenerated += nearestOffset.getOffset();
            stringBuilder.append(nearestOffset.generate(null,width));
        }
        return stringBuilder.toString();
    }

    private OffsetComponent getNearestOffset(int offset) {
        Integer key = offsetComponents.lowerKey(offset);
        if (key == null) {
            key = offsetComponents.firstKey();
        }
        Bukkit.broadcastMessage("Nearest to "+offset+" is "+getOffset(key).getOffset());
        return getOffset(key);
    }

}
