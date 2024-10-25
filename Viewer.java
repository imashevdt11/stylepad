import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Viewer {

  public Viewer() {
    Controller controller = new Controller(this);

    // menubar creation
    JMenuBar menubar = createMenubar(controller);

    // frame creation
    JFrame frame = new JFrame("Stylepad MVC Pattern");
    frame.setJMenuBar(menubar);
    frame.setSize(500, 500);
    frame.setLocation(400, 200);
    frame.setVisible(true);
  }

  // menubar creation
  private JMenuBar createMenubar(Controller controller) {
    JMenuBar menubar = new JMenuBar();

    // menu creation and addition to menubar
    JMenu fileMenu = createFileMenu(controller);
    JMenu editMenu = createEditMenu(controller);
    menubar.add(fileMenu);
    menubar.add(editMenu);
    return menubar;
  }

  // "File" menu creation
  private JMenu createFileMenu(Controller controller) {

    JMenu fileMenu = new JMenu("File");
    fileMenu.setMnemonic('F');

    // Font font = new Font("Roboto", Font.PLAIN, 35);
    // fileMenu.setFont(font);
    // fileMenu.setForeground(Color.GREEN);

    // menu items creation
    JMenuItem newDocument = new JMenuItem("New", new ImageIcon("resources/new.gif"));
    newDocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
    newDocument.addActionListener(controller);
    newDocument.setActionCommand("New_Document");

    JMenuItem openDocument = new JMenuItem("Open", new ImageIcon("resources/open.gif"));
    openDocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
    openDocument.addActionListener(controller);
    openDocument.setActionCommand("Open_Document");

    JMenuItem saveDocument = new JMenuItem("Save", new ImageIcon("resources/save.gif"));
    saveDocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
    saveDocument.addActionListener(controller);
    saveDocument.setActionCommand("Save_Document");

    JMenuItem printDocument = new JMenuItem("Print", new ImageIcon("resources/print.gif"));
    printDocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
    printDocument.addActionListener(controller);
    printDocument.setActionCommand("Print_Document");

    JMenuItem exitPorgram = new JMenuItem("Exit");
    printDocument.addActionListener(controller);
    printDocument.setActionCommand("Exit");

    fileMenu.add(newDocument);
    fileMenu.add(openDocument);
    fileMenu.add(saveDocument);
    fileMenu.add(new JSeparator());
    fileMenu.add(printDocument);
    fileMenu.add(new JSeparator());
    fileMenu.add(exitPorgram);

    return fileMenu;
  }

  // "Edit" menu creation
  private JMenu createEditMenu(Controller controller) {

    // menu items creation
    JMenuItem cutJMenuItem = new JMenuItem("Cut", new ImageIcon("resources/cut.gif"));
    cutJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
    cutJMenuItem.addActionListener(controller);
    cutJMenuItem.setActionCommand("Cut");
    cutJMenuItem.setEnabled(true);

    JMenuItem copyJMenuItem = new JMenuItem("Copy", new ImageIcon("resources/copy.gif"));
    copyJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
    copyJMenuItem.addActionListener(controller);
    copyJMenuItem.setActionCommand("Copy");
    copyJMenuItem.setEnabled(true);
    cutJMenuItem.setEnabled(true);

    JMenuItem pasteJMenuItem = new JMenuItem("Paste", new ImageIcon("resources/paste.gif"));
    pasteJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
    pasteJMenuItem.addActionListener(controller);
    pasteJMenuItem.setActionCommand("Paste");
    cutJMenuItem.setEnabled(true);

    JMenuItem clearJMenuItem = new JMenuItem("Clear", new ImageIcon("resources/clear.gif"));
    clearJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
    clearJMenuItem.addActionListener(controller);
    clearJMenuItem.setActionCommand("Clear");
    cutJMenuItem.setEnabled(true);

    JMenuItem findJMenuItem = new JMenuItem("Find", new ImageIcon("resources/find.gif"));
    findJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
    findJMenuItem.addActionListener(controller);
    findJMenuItem.setActionCommand("Find");
    cutJMenuItem.setEnabled(true);

    JMenuItem findMoreJMenuItem = new JMenuItem("Find More", new ImageIcon("resources/findMore.gif"));
    findMoreJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, ActionEvent.CTRL_MASK));
    findMoreJMenuItem.addActionListener(controller);
    findMoreJMenuItem.setActionCommand("Find_More");
    cutJMenuItem.setEnabled(true);

    JMenuItem goJMenuItem = new JMenuItem("Go", new ImageIcon("resources/go.gif"));
    goJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
    goJMenuItem.addActionListener(controller);
    goJMenuItem.setActionCommand("Go");
    cutJMenuItem.setEnabled(true);

    JMenuItem selectAllJMenuItem = new JMenuItem("Select All", new ImageIcon("resources/selectAll.gif"));
    selectAllJMenuItem.setAccelerator(KeyStroke.getKeyStroke(65, ActionEvent.CTRL_MASK));
    selectAllJMenuItem.addActionListener(controller);
    selectAllJMenuItem.setActionCommand("Select_All");
    cutJMenuItem.setEnabled(true);

    JMenuItem timeAndDateJMenuItem = new JMenuItem("Time and date", new ImageIcon("resources/timeAndDate.gif"));
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
}
