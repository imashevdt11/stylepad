import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class SaveDocumentModel {

  public boolean saveToFile(File file, String content) {

    FileOutputStream out = null;

    try {
      out = new FileOutputStream(file);

      for (int i = 0; i < content.length(); i++) {
        char symbol = content.charAt(i);
        int unicode = (int) symbol;
        out.write(symbol);
      }

      return true;
    } catch (IOException ioe) {
      System.out.println("ioe " + ioe);
    } finally {
      try {
        out.close();
      } catch (IOException ioe) {
        System.out.println("ioe " + ioe);
      }
    }
    return false;
  }
}
