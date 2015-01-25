package hello;

import java.io.Serializable;

/**
 * Created by shannon on 15-1-25.
 */
public class BusinessMessage implements Serializable{
    private String name;
    private int index;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "BusinessMessage{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }
}
