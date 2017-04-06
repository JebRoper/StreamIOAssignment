import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;


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
        System.out.println("parent before\n\t" + parent);

        //json serialization
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(parent);
        System.out.println("\n\tparent json is: " + json);

        Parent parent2 = mapper.readValue(json, Parent.class);
        System.out.println("\n\tparent2 json is: " + parent2);

        FileReader in2 = new FileReader("parent.ser");
        FileWriter out2 = new FileWriter("parent.copy");

        out2.flush();
        out2.close();

        //object serialization
        System.out.println("\nBefore writing the parent file out \n\t " + parent);
        FileOutputStream fos = new FileOutputStream("parent.ser");
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.writeObject(parent);
        out.flush();
        out.close();

        FileInputStream fis = new FileInputStream("parent.ser");
        ObjectInputStream ins = new ObjectInputStream(fis);
        Parent parent3 = (Parent) ins.readObject();
        System.out.println("\nAfter reading the file\n\t " + parent3);
        ins.close();


    }

}

