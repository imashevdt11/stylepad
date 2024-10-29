import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

public class PrintDocument implements Printable {

  private String content;
  private Font font;
  private int[] pageBreaks;
  private String[] textLines;
  // private Image image;

  // public PrintDocument(String content, Font font, Image image) {
  public PrintDocument(String content, Font font) {
    this.content = content;
    this.font = font;
    // this.image = image;
  }

  public int print(Graphics g, PageFormat pf, int page) throws PrinterException {

    g.setFont(font);
    FontMetrics metrics = g.getFontMetrics(font);
    int lineHeight = metrics.getHeight();

    if (pageBreaks == null) {
      initTextLines();
      int linesPerPage = (int) ((pf.getImageableHeight() - 100) / lineHeight);
      int numBreaks = (textLines.length - 1) / linesPerPage;
      pageBreaks = new int[numBreaks];
      for (int b = 0; b < numBreaks; b++) {
        pageBreaks[b] = (b + 1) * linesPerPage;
      }
    }

    if (page > pageBreaks.length) {
      return NO_SUCH_PAGE;
    }

    Graphics2D g2d = (Graphics2D) g;
    g2d.translate(pf.getImageableX(), pf.getImageableY());

    int x = 50;
    int y = 50;

    int start = (page == 0) ? 0 : pageBreaks[page - 1];
    int end = (page == pageBreaks.length)
              ? textLines.length : pageBreaks[page];
    for (int line = start; line < end; line++) {
      y = y + lineHeight;
      g.drawString(textLines[line], x, y);
    }

    g.drawString("" + (page + 1), (int) (pf.getImageableWidth() - 50), 25);
    g.drawString("" + (page + 1), (int) (pf.getImageableWidth() - 50), (int) (pf.getImageableHeight() - 50));

    if (page == pageBreaks.length) {
      ImageIcon imageIcon = new ImageIcon("images/duke.png");
      Image image = imageIcon.getImage();
      g.drawImage(image, x, y + lineHeight, null);
    }

    // g.drawImage(image, 100, 100, null);

    return PAGE_EXISTS;
  }

  private void initTextLines() {
    if (textLines == null) {
      textLines = content.split("\n");
     }
  }
}
