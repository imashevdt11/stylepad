import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class OpenDocumentModel {

  public String openFile(File file) {

    String textFromFile = "";
    FileInputStream in = null;

    try {
      in = new FileInputStream(file);
      int unicode;

      while ((unicode = in.read()) != -1) {
        char symbol = (char) unicode;
        textFromFile = textFromFile + symbol;
      }
      return textFromFile;
    } catch (IOException ioe) {
      System.out.println("ioe " + ioe);
    } finally {
      try {
        in.close();
      } catch (IOException ioe) {
        System.out.println("ioe " + ioe);
      }
    }
    return textFromFile;
  }
}
