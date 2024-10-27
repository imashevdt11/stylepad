import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

public class Controller implements ActionListener {

  private Viewer viewer;
  private OpenDocumentModel openDocumentModel;
  private SaveDocumentModel saveDocumentModel;

  public Controller(Viewer viewer) {
    this.viewer = viewer;
    openDocumentModel = new OpenDocumentModel();
    saveDocumentModel = new SaveDocumentModel();
  }

  public void actionPerformed(ActionEvent event) {
    String command = event.getActionCommand();

    if (command.equals("Open_Document")) {
      File file = viewer.showFileDialog(command);

      if (file != null) {
        String textFromModel = openDocumentModel.openFile(file);

        if (textFromModel != null) {
          viewer.update(textFromModel);
        }
      } else {
        viewer.showNotFoundFile();
      }
    } else if (command.equals("Save_Document")) {
      File file = viewer.showFileDialog(command);

      if (file != null) {
        String content = viewer.getContent();

        if (!content.equals("")) {
          boolean result = saveDocumentModel.saveToFile(file, content);
          viewer.showResultSaveDocumentIntoModel(result);
        }
      }
      else if (command.equals("Insert_Image")) {
        viewer.insertImage();
      }
    }
  }
}
