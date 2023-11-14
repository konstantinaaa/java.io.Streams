// Store and retrieve float numbers

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Task_3_Store_and_retrieve_float_numbers
{
    public static void main(String[] args) throws Exception
    {
        float list[] = {10.5f, 2.9f, 6.4f, 3.7f};

        FileOutputStream fos = new FileOutputStream("C:\\My_Java\\Data1.txt");
        DataOutputStream dos = new DataOutputStream(fos);

        dos.writeInt(list.length);
        for(float f:list)
        {
            dos.writeFloat(f);
        }

        dos.close();
        fos.close();

        FileInputStream fis = new FileInputStream("C:\\My_Java\\Data1.txt");
        DataInputStream dis = new DataInputStream(fis);

        int length = dis.readInt();
        float data;

        for(int i=0;i<length;i++)
        {
            data = dis.readFloat();
            System.out.println(data);

        }

        dis.close();
        fis.close();
    }
}
