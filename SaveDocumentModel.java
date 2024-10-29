import javax.swing.text.Document;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;

public class SaveDocumentModel {

  public boolean saveToFile(File file, Document content) {

    FileOutputStream fileOutputStream = null;
    ObjectOutputStream objectOutputStream = null;

    try {
      fileOutputStream = new FileOutputStream(file);
      objectOutputStream = new ObjectOutputStream(fileOutputStream);
      objectOutputStream.writeObject(content);
      objectOutputStream.flush();

      return true;

    } catch (NotSerializableException nse) {
      System.out.println("nse " + nse);
    } catch (IOException ioe) {
      System.out.println("ioe " + ioe);
    } finally {
      try {
        if (fileOutputStream != null) {
          fileOutputStream.close();
        }
        if (objectOutputStream != null) {
          objectOutputStream.close();
        }
      } catch (IOException ioe) {
        System.out.println("ioe " + ioe);
      }
    }
    return false;
  }
}
