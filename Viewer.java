import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.StyleContext;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;

public class Viewer {

  private JFileChooser fileChooser;
  private JTextPane textPane;
  private Icon icon;

  public Viewer() {
    Controller controller = new Controller(this);

    // menubar creation
    JMenuBar menubar = createMenubar(controller);

    // edit area creation
    JPanel editorArea = createEditorArea();

    // frame creation
    JFrame frame = new JFrame("Stylepad MVC Pattern");
    frame.setJMenuBar(menubar);
    frame.setSize(500, 500);
    frame.setLocation(400, 200);
    frame.add("Center", editorArea);
    frame.setVisible(true);
  }

  private JMenuBar createMenubar(Controller controller) {
    JMenuBar menubar = new JMenuBar();
    JMenu fileMenu = createFileMenu(controller);
    JMenu editMenu = createEditMenu(controller);
    menubar.add(fileMenu);
    menubar.add(editMenu);
    return menubar;
  }

  private JMenu createFileMenu(Controller controller) {

    JMenu fileMenu = new JMenu("File");
    fileMenu.setMnemonic('F');

    // Font font = new Font("Roboto", Font.PLAIN, 35);
    // fileMenu.setFont(font);
    // fileMenu.setForeground(Color.GREEN);

    JMenuItem newDocument = new JMenuItem("New", new ImageIcon("images/new.png"));
    newDocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
    newDocument.addActionListener(controller);
    newDocument.setActionCommand("New_Document");

    JMenuItem openDocument = new JMenuItem("Open", new ImageIcon("images/open.png"));
    openDocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
    openDocument.addActionListener(controller);
    openDocument.setActionCommand("Open_Document");

    JMenuItem saveDocument = new JMenuItem("Save", new ImageIcon("images/save.png"));
    saveDocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
    saveDocument.addActionListener(controller);
    saveDocument.setActionCommand("Save_Document");

    JMenuItem insertImage = new JMenuItem("Insert Image", new ImageIcon("images/insert.png"));
    insertImage.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
    insertImage.addActionListener(controller);
    insertImage.setActionCommand("Insert_Image");

    JMenuItem printDocument = new JMenuItem("Print", new ImageIcon("images/print.png"));
    printDocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
    printDocument.addActionListener(controller);
    printDocument.setActionCommand("Print_Document");

    JMenuItem exitPorgram = new JMenuItem("Exit");
    exitPorgram.addActionListener(controller);
    exitPorgram.setActionCommand("Exit");

    fileMenu.add(newDocument);
    fileMenu.add(openDocument);
    fileMenu.add(saveDocument);
    fileMenu.add(new JSeparator());
    fileMenu.add(insertImage);
    fileMenu.add(new JSeparator());
    fileMenu.add(printDocument);
    fileMenu.add(new JSeparator());
    fileMenu.add(exitPorgram);

    return fileMenu;
  }

  private JMenu createEditMenu(Controller controller) {

    JMenuItem cutJMenuItem = new JMenuItem("Cut", new ImageIcon("images/cut.png"));
    cutJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
    cutJMenuItem.addActionListener(controller);
    cutJMenuItem.setActionCommand("Cut");
    cutJMenuItem.setEnabled(true);

    JMenuItem copyJMenuItem = new JMenuItem("Copy", new ImageIcon("images/copy.png"));
    copyJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
    copyJMenuItem.addActionListener(controller);
    copyJMenuItem.setActionCommand("Copy");
    copyJMenuItem.setEnabled(true);
    cutJMenuItem.setEnabled(true);

    JMenuItem pasteJMenuItem = new JMenuItem("Paste", new ImageIcon("images/paste.png"));
    pasteJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
    pasteJMenuItem.addActionListener(controller);
    pasteJMenuItem.setActionCommand("Paste");
    cutJMenuItem.setEnabled(true);

    JMenuItem clearJMenuItem = new JMenuItem("Clear", new ImageIcon("images/clear.png"));
    clearJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
    clearJMenuItem.addActionListener(controller);
    clearJMenuItem.setActionCommand("Clear");
    cutJMenuItem.setEnabled(true);

    JMenuItem findJMenuItem = new JMenuItem("Find", new ImageIcon("images/find.png"));
    findJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
    findJMenuItem.addActionListener(controller);
    findJMenuItem.setActionCommand("Find");
    cutJMenuItem.setEnabled(true);

    JMenuItem findMoreJMenuItem = new JMenuItem("Find More", new ImageIcon("images/findMore.png"));
    findMoreJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, ActionEvent.CTRL_MASK));
    findMoreJMenuItem.addActionListener(controller);
    findMoreJMenuItem.setActionCommand("Find_More");
    cutJMenuItem.setEnabled(true);

    JMenuItem goJMenuItem = new JMenuItem("Go", new ImageIcon("images/go.png"));
    goJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
    goJMenuItem.addActionListener(controller);
    goJMenuItem.setActionCommand("Go");
    cutJMenuItem.setEnabled(true);

    JMenuItem selectAllJMenuItem = new JMenuItem("Select All", new ImageIcon("images/selectAll.png"));
    selectAllJMenuItem.setAccelerator(KeyStroke.getKeyStroke(65, ActionEvent.CTRL_MASK));
    selectAllJMenuItem.addActionListener(controller);
    selectAllJMenuItem.setActionCommand("Select_All");
    cutJMenuItem.setEnabled(true);

    JMenuItem timeAndDateJMenuItem = new JMenuItem("Time and date", new ImageIcon("images/timeAndDate.png"));
    timeAndDateJMenuItem.setAccelerator(KeyStroke.getKeyStroke(116, 0));
    timeAndDateJMenuItem.addActionListener(controller);
    timeAndDateJMenuItem.setActionCommand("Time_And_Date");
    cutJMenuItem.setEnabled(true);

    JMenu editMenu = new JMenu("Edit");
    editMenu.setMnemonic('E');
    editMenu.add(cutJMenuItem);
    editMenu.add(copyJMenuItem);
    editMenu.add(pasteJMenuItem);
    editMenu.add(clearJMenuItem);
    editMenu.add(new JSeparator());
    editMenu.add(findJMenuItem);
    editMenu.add(findMoreJMenuItem);
    editMenu.add(goJMenuItem);
    editMenu.add(new JSeparator());
    editMenu.add(selectAllJMenuItem);
    editMenu.add(timeAndDateJMenuItem);

    return editMenu;
  }

  public JPanel createEditorArea() {

    JTextComponent editor = createEditor();

    Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
    Border emptyBorder = new EmptyBorder(25, 25, 25, 25);
    Border compound = BorderFactory.createCompoundBorder(emptyBorder, raisedetched);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBorder(compound);
    JViewport viewport = scrollPane.getViewport();
    viewport.add(editor);

    raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
    emptyBorder = new EmptyBorder(10, 10, 10, 10);
    compound = BorderFactory.createCompoundBorder(emptyBorder, raisedetched);

    JPanel panel = new JPanel();
    panel.setBorder(compound);
    panel.setBackground(new Color(230, 230, 230));
    panel.setLayout(new BorderLayout());
    panel.add(scrollPane);

    return panel;
  }

  protected JTextComponent createEditor() {
    StyleContext styleContext = new StyleContext();
    DefaultStyledDocument defaultStyledDocument = new DefaultStyledDocument(styleContext);
    textPane = new JTextPane(defaultStyledDocument);
    textPane.setFont(new Font("Roboto", Font.PLAIN, 35));
    return textPane;
  }

  public void insertImage() {
    File file = showFileDialog("Open_Document");
    if (file != null) {
      Icon icon = new ImageIcon(file.getAbsolutePath());
      textPane.insertIcon(icon);
    }
  }

  public File showFileDialog(String command) {
    if (fileChooser == null) {
      fileChooser = new JFileChooser();
    }

    File file = null;
    int returnVal = -100;

    if (command.equals("Open_Document")) {
      returnVal = fileChooser.showOpenDialog(null);
    } else if (command.equals("Save_Document")) {
      returnVal = fileChooser.showSaveDialog(null);
    }

    if (returnVal == JFileChooser.APPROVE_OPTION) {
      file = fileChooser.getSelectedFile();
    }
    return file;
  }

  public void showNotFoundFile() {
    JOptionPane.showMessageDialog(null, "File not found",
                                  "About File", JOptionPane.ERROR_MESSAGE);
  }

  public void update(Document document) {
    if (textPane.getDocument() != null) {
      textPane.getDocument().removeUndoableEditListener(null);
    }
    textPane.setDocument(document);
    document.addUndoableEditListener(null);
  }

  public Document getContent() {
    return textPane.getDocument();
  }

  public void showResultSaveDocumentIntoModel(boolean result) {
    if (result) {
      JOptionPane.showMessageDialog(null, "File saved successfully");
    } else {
      JOptionPane.showMessageDialog(null, "File wasn't saved",
                                    "File saving error", JOptionPane.ERROR_MESSAGE);
    }
  }

  public void showPrintDocumentDialog() {

    String content = textPane.getText();
    PrintDocument printDocument = new PrintDocument(content);

    PrinterJob job = PrinterJob.getPrinterJob();
    job.setPrintable(printDocument);
    boolean ok = job.printDialog();

    if (ok) {
      try {
        job.print();
        showResultPrintDocument();
      } catch (PrinterException pe) {
        System.out.println("pe: " + pe);
      }
    }
  }

  private void showResultPrintDocument() {
    if (icon == null) {
      icon = new ImageIcon("images/duke.png");
    }
    JOptionPane.showMessageDialog(null,
    "The document has been successfully printed",
    "Printer Document Dialog - Stylepad MVC Pattern",
    JOptionPane.INFORMATION_MESSAGE,
    icon);
  }
}
