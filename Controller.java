import javax.swing.text.Document;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

public class Controller implements ActionListener {

  private Viewer viewer;
  private OpenDocumentModel openDocumentModel;
  private SaveDocumentModel saveDocumentModel;
  private NewDocumentModel newDocumentModel;

  public Controller(Viewer viewer) {
    this.viewer = viewer;
    openDocumentModel = new OpenDocumentModel();
    saveDocumentModel = new SaveDocumentModel();
    newDocumentModel = new NewDocumentModel();
  }

  public void actionPerformed(ActionEvent event) {
    String command = event.getActionCommand();

    if (command.equals("New_Document")) {
      Document document = newDocumentModel.getNewDocument();

      if (document != null) {
        viewer.update(document);
      } else {
        // need to write what else
      }
    }
    else if (command.equals("Open_Document")) {
      File file = viewer.showFileDialog(command);

      if (file != null) {
        Document dataFromFile = openDocumentModel.openFile(file);

        if (dataFromFile != null) {
          viewer.update(dataFromFile);
        }
      } else {
        viewer.showNotFoundFile();
      }
    } else if (command.equals("Save_Document")) {
      File file = viewer.showFileDialog(command);

      if (file != null) {
        Document contentDocument = viewer.getContent();

        if (contentDocument != null) {
          boolean result = saveDocumentModel.saveToFile(file, contentDocument);
          viewer.showResultSaveDocumentIntoModel(result);
        }
      }
    } else if (command.equals("Insert_Image")) {
      viewer.insertImage();
    }
  }
}
