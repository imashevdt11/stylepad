import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class SaveDocumentModel {

  public boolean saveToFile(File file, String content) {

    PrintWriter outputStream = null;
    FileWriter fileWriter = null;

    try {
      fileWriter = new FileWriter(file);
      outputStream = new PrintWriter(fileWriter);
      outputStream.println(content);
      outputStream.flush();

      return true;

    } catch (IOException ioe) {
      System.out.println("ioe " + ioe);
    } finally {
      try {
        if (fileWriter != null) {
          fileWriter.close();
        }
        if (outputStream != null) {
          outputStream.close();
        }
      } catch (IOException ioe) {
        System.out.println("ioe " + ioe);
      }
    }
    return false;
  }
}
