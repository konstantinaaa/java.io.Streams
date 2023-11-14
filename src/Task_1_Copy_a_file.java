// Copying the data, which is in uppercase, from one file to another file and converting it to lowercase.

import java.io.FileOutputStream;

public class Task_1_Copy_a_file
{
    public static void main(String[] args) throws Exception
    {
        try(FileOutputStream file_output_stream = new FileOutputStream("C:/Users/Konstantina/OneDrive/Υπολογιστής/Folders/DATA/JAVA/My_Java/Source1.txt"))
        {
            String str = "JAVA PROGRAMMING LANGUAGE\nJAVA TEST FILE\nCOPY DATA FROM ONE FILE TO ANOTHER";

            file_output_stream.write(str.getBytes());
            file_output_stream.close();
        }

        // Provide the full path to the "Source1.txt" file.
        java.io.FileInputStream fis = new java.io.FileInputStream("C:/Users/Konstantina/OneDrive/Υπολογιστής/Folders/DATA/JAVA/My_Java/Source1.txt"); // github "C:/My JAVA/Source1.txt"
        FileOutputStream fos = new FileOutputStream("C:/Users/Konstantina/OneDrive/Υπολογιστής/Folders/DATA/JAVA/My_Java/Source2.txt"); // github "C:/My JAVA/Source2.txt"

       int b;
       while((b = fis.read())!= -1)
        {
            if(b >= 65 && b <= 90) // The ASCII values for uppercase letters range from 65 to 90
            {
                fos.write(b + 32); // To convert from an uppercase character to its lower case equivalent, we add 32 to the ASCII code of the uppercase letter to obtain the ASCII code of the lowercase equivalent.
            }
            else fos.write(b);
        }

        fis.close();
        fos.close();

    }
}
