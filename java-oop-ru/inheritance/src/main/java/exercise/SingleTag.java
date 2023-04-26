package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    public SingleTag(String nameTag, Map<String, String> attributeTag) {
        super(nameTag, attributeTag);
    }

    @Override
    public String toString() {
        return attributesToString();
    }
}
// END
