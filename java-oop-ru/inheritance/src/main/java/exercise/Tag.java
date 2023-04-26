package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public abstract class Tag {
    public String nameTag;
    public Map<String, String> attributeTag;

    public Tag(String nameTag, Map<String, String> attributeTag) {
        this.nameTag = nameTag;
        this.attributeTag = attributeTag;
    }

    protected String attributesToString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> attribute : attributeTag.entrySet()) {
            result.append(" ").append(attribute.getKey()).append("=\"").append(attribute.getValue()).append("\"");
        }
        return result.toString();
    }

    public abstract String toString();
}
// END
