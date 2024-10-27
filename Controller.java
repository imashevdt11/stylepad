import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

public class Controller implements ActionListener {

  private Viewer viewer;
  private OpenDocumentModel openDocumentModel;

  public Controller(Viewer viewer) {
    this.viewer = viewer;
    openDocumentModel = new OpenDocumentModel();
  }

  public void actionPerformed(ActionEvent event) {
    String command = event.getActionCommand();

    if (command.equals("Open_Document")) {
      File file = viewer.showOpenFileDialog();

      if (file != null) {
        String textFromModel = openDocumentModel.openFile(file);

        if (textFromModel != null) {
          viewer.update(textFromModel);
        }
      } else {
        viewer.showNotFoundFile();
      }
    } else if (command.equals("Insert_Image")) {
      viewer.insertImage();
    }
  }
}
