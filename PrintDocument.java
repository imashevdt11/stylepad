import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

public class PrintDocument implements Printable {

  private String content;

  public PrintDocument(String content) {
    this.content = content;
  }
  public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
    if (page > 0) {
      return NO_SUCH_PAGE;
    }

    Graphics2D g2d = (Graphics2D) g;
    g2d.translate(pf.getImageableX(), pf.getImageableY());
    g.drawString(content, 100, 100);

    return PAGE_EXISTS;
  }
}
