import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OpenDocumentModel {

  public String openFile(File file) {

    BufferedReader inputStream = null;
    FileReader fileReader = null;

    try {
      List<String> list = new ArrayList<>();

      fileReader = new FileReader(file);
      inputStream = new BufferedReader(fileReader);

      String line;
      while ((line = inputStream.readLine()) != null) {
        list.add(line);
      }
      String content = String.join("\n", list);
      list.clear();

      return content;

    } catch (IOException ioe) {
      System.out.println("ioe " + ioe);
    } finally {
      try {
        if (fileReader != null) {
          fileReader.close();
        }
        if (inputStream != null) {
          inputStream.close();
        }
      } catch (IOException ioe) {
        System.out.println("ioe " + ioe);
      }
    }
    return null;
  }
}
