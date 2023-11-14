// Copy the contents from two source files (Source1, Source2) into a single destination file (Destination)

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.SequenceInputStream;

public class Task2_Sequence_Stream
{
    public static void main(String[] args) throws Exception
    {
        FileInputStream file1 = new FileInputStream("C:/My_Java/Source1.txt");
        FileInputStream file2 = new FileInputStream("C:/My_Java/Source2.txt");

        FileOutputStream fos = new FileOutputStream("C:/My_Java/Destination.txt");

        SequenceInputStream sis = new SequenceInputStream(file1, file2);

        int b;
        while((b = sis.read()) != -1)
        {
           fos.write(b);
        }
        file1.close();
        file2.close();
        fos.close();
        sis.close();
    }
}
