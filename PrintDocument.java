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
  // private Image image;

  // public PrintDocument(String content, Font font, Image image) {
  public PrintDocument(String content, Font font) {
    this.content = content;
    this.font = font;
    // this.image = image;
  }
  public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
    if (page > 0) {
      return NO_SUCH_PAGE;
    }

    Graphics2D g2d = (Graphics2D) g;
    g2d.translate(pf.getImageableX(), pf.getImageableY());
    g.setFont(font);
    FontMetrics metrics = g.getFontMetrics(font);
    int lineHeight = metrics.getHeight();
    int x = 50;
    int y = 50;
    String line = "";
    for (int i = 0; i < content.length(); i++) {
      char symbol = content.charAt(i);
      if (symbol == '\n') {
        g.drawString(line, x, y);
        line = "";
        y = y + lineHeight;
        continue;
      }
      line = line + symbol;
      if (i == content.length() - 1) {
        g.drawString(line, x, y);
      }
    }

    // g.drawImage(image, 100, 100, null);

    return PAGE_EXISTS;
  }
}
