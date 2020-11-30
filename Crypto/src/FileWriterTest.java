import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.*;

public class FileWriterTest {

    @Before
    public void setUp(){
        ROT13 cipher = new ROT13();
        cipher.encryptSonnetFile(new File("sonnet18.txt"));
        cipher.decryptSonnetFile(new File("sonnet18.enc"));
    }
    @Test
    public void testFileWriterROT13(){
        try{
            BufferedReader readerOriginalFile = new BufferedReader(new FileReader("sonnet18.txt"));
            BufferedReader readerDecryptedFile = new BufferedReader(new FileReader("sonnet18.dec"));
            String lineOriginal;
            String lineDecrypt;
            while((lineOriginal = readerOriginalFile.readLine()) != null && (lineDecrypt = readerDecryptedFile.readLine()) != null){
                lineOriginal = readerOriginalFile.readLine();
                lineDecrypt = readerDecryptedFile.readLine();
                Assert.assertEquals(lineOriginal, lineDecrypt);
            }
            readerOriginalFile.close();
            readerDecryptedFile.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}