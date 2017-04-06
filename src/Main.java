import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Child child = new Child();
        child.setNum(15);
        child.setName("Mike");
        child.setNum2(22);
        Parent parent = new Parent();
        parent.setCount(40);
        parent.setSecond("Dave");
        parent.setChild(child);

        System.out.println("Before writing the parent file out \n\t " + parent);
        FileOutputStream fos = new FileOutputStream("parent.ser");
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.writeObject(parent);
        out.flush();
        out.close();

        FileInputStream fis = new FileInputStream("parent.ser");
        ObjectInputStream ins = new ObjectInputStream(fis);
        Parent parent2 = (Parent) ins.readObject();
        System.out.println("After reading the file\n\t " + parent2);
        ins.close();


    }

}

