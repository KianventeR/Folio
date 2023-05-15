public class IntegerEntry {
    private int key;
    private int value;

    IntegerEntry(int k, int v){
        key = k;
        value = v;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
    
}
