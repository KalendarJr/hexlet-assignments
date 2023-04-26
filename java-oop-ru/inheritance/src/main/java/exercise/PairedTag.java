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
        String attrs = getAttributes().entrySet().stream()
                .map(e -> e.getKey() + "=\"" + e.getValue() + "\"")
                .collect(Collectors.joining(" "));
        String childrenStr = children.stream()
                .map(Tag::toString)
                .collect(Collectors.joining(""));
        return "<" + getName() + (attrs.isEmpty() ? "" : " " + attrs) + ">" + bodyTag + childrenStr + "</" + getName() + ">";
    }
}
// END
