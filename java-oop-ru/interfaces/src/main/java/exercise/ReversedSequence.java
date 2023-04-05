package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String string;

    public ReversedSequence(String string) {
        this.string = new StringBuilder(string).reverse().toString();
    }

    @Override
    public int length() {
        return string.length();
    }

    @Override
    public char charAt(int i) {
        return string.charAt(i);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return string.subSequence(i, i1);
    }

    public String toString() {
        return string;
    }
}
// END
