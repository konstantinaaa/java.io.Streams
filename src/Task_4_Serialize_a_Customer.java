// Customer Serialization

import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

class Customer implements Serializable
{
    String customerID;
    String name;
    String phone;

    static int count = 1;

    Customer() {}

    Customer(String name, String phone)
    {
        customerID = "C" + count;
        count++;
        this.name = name;
        this.phone = phone;
    }

    public String toString()
    {
        return "Details of the Customer:\n" +
                "Customer ID: " + customerID +
                "\nName:" + name +
                "\nPhone: " + phone;
    }
}


public class Task_4_Serialize_a_Customer
{
    public static void main(String[] args) throws Exception
    {
        //Create an array of Customers
        Customer list[] = {new Customer("Smith", "6980000000"), new Customer("John", "6975555555"), new Customer("Stef", "6941111111")};


        // Serialization: Writing Customers to a file
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Konstantina\\OneDrive\\Υπολογιστής\\Folders\\DATA\\JAVA\\My_Java\\Customer.txt"); // C:/MyJava/Customer.txt
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeInt(list.length);
        for(Customer c:list)
        {
            oos.writeObject(c);
        }
        oos.close();
        fos.close();

        // Deserialization: Reading Customers from a file
        FileInputStream fis = new FileInputStream("C:\\Users\\Konstantina\\OneDrive\\Υπολογιστής\\Folders\\DATA\\JAVA\\My_Java\\Customer.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        int length = ois.readInt();

        Customer list1[] = new Customer[length];

        // read all the customers from the file
        for(int i=0;i<length;i++)
        {
            list1[i] = (Customer)ois.readObject();
        }

        // Search for a customer by name
        System.out.println("Enter name of Customer:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        for(int i=0;i<length;i++)
        {
            if(name.equalsIgnoreCase(list[i].name))
                System.out.println(list[i]);
        }

        ois.close();
        fis.close();

    }
}
