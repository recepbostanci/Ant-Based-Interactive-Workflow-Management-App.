/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis.fileforms;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 *
 * @author BSTNC
 */
public class Fonksiyon {
     public String readFileContent(String URL) throws FileNotFoundException, IOException {

        int i;
        String content = "";
        FileInputStream fin = new FileInputStream(URL);

        do {
            i = fin.read();
            if (i != -1) {
                //System.out.print((char) i);
                content = content + (char) i;
            }
        } while (i != -1);
        return content;
    }
}
