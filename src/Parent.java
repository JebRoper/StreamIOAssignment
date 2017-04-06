import java.io.Serializable;

/**
 * Created by admin on 4/6/17.
 */
public class Parent implements Serializable {
    private int count;
    private String second;
    private Child child;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "count=" + count +
                ", second='" + second + '\'' +
                ", child=" + child +
                '}';
    }
}

