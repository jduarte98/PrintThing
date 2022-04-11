package joaoduarte.samples.printthing;

import java.awt.*;
import java.awt.print.*;

public class Main implements Printable{
    private String textToPrint = "Hello World!";

    public static void main(String[] args) {
        Main hello = new Main();
        hello.printPage();
    }

    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        g.drawString(textToPrint, 100, 100);
        if(page > 0) {
            return NO_SUCH_PAGE;
        } else {
            return PAGE_EXISTS;
        }
    }

    public void printPage() {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        boolean ok = job.printDialog();
        if(ok) {
            try {
                System.out.println("Printing ...");
                job.print();
                System.out.println("Printed Sucessfully!!!");
            }catch(PrinterException ex){
                System.out.println("Error printing; The error is:\n" + ex);
            }
        }
    }
}

