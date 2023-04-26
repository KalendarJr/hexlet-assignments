package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    public String bodyTag;
    public List<Tag> children;

    public PairedTag(String nameTag, Map<String, String> attributeTag, String bodyTag, List<Tag> children) {
        super(nameTag, attributeTag);
        this.bodyTag = bodyTag;
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("<").append(nameTag).append(attributesToString()).append(">");
        if (!bodyTag.isEmpty()) {
            result.append(bodyTag);
        } else {
            for (Tag child : children) {
                result.append(child.toString());
            }
        }
        result.append("</").append(nameTag).append(">");
        return result.toString();
    }
}
// END
