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


        PrintWriter pw = new PrintWriter(new FileWriter("parent.json"));
        pw.println(json);
        pw.flush();
        pw.close();

        BufferedReader br = new BufferedReader(new FileReader("parent.json"));
        String jsonFromFile = br.readLine();
        System.out.println("\n\tjson from the file is" + jsonFromFile);
        br.close();

        Parent parent2 = mapper.readValue(jsonFromFile, Parent.class);
        System.out.println("\n\tparent2 json is: " + parent2);


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

