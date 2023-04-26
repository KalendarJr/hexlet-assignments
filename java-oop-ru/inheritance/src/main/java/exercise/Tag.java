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

    public String getName() {
        return nameTag;
    }

    public Map<String, String> getAttributes() {
        return attributeTag;
    }

    public String attributesToString() {
        String attrs = attributeTag.entrySet().stream()
                .map(e -> e.getKey() + "=\"" + e.getValue() + "\"")
                .collect(Collectors.joining(" "));
        return "<" + nameTag + (attrs.isEmpty() ? "" : " " + attrs) + ">";
    }

    public abstract String toString();
}
// END
