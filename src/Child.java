import java.io.Serializable;

/**
 * Created by admin on 4/6/17.
 */
public class Child implements Serializable {
    private int num;
    private String name;
    private transient int num2;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    @Override
    public String toString() {
        return "Child{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", num2=" + num2 +
                '}';
    }
}

