import javax.swing.text.Document;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OpenDocumentModel {

  public Document openFile(File file) {

    FileInputStream fileInputStream = null;
    ObjectInputStream objectInputStream = null;

    try {

      fileInputStream = new FileInputStream(file);
      objectInputStream = new ObjectInputStream(fileInputStream);

      Document dataModelFromFile = (Document) objectInputStream.readObject();

      return dataModelFromFile;

    } catch (ClassNotFoundException cnfe) {
      System.out.println("cnfe " + cnfe);
    } catch (IOException ioe) {
      System.out.println("ioe " + ioe);
    } finally {
      try {
        if (fileInputStream != null) {
          fileInputStream.close();
        }
        if (objectInputStream != null) {
          objectInputStream.close();
        }
      } catch (IOException ioe) {
        System.out.println("ioe " + ioe);
      }
    }
    return null;
  }
}
