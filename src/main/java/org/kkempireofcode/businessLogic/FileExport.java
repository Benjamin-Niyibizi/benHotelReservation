package org.kkempireofcode.businessLogic;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.kkempireofcode.model.Booking;
import org.kkempireofcode.model.Reservation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FileExport {

    public static void printBill(HttpServletRequest request, HttpServletResponse response, Booking booking, String filename){
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\""+ filename + "\""); // file name

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            addContent(document,booking);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void printBookingReport(HttpServletResponse response, List<Booking> bookings, String filename){
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\""+ filename + "\""); // file name

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            addReportContent(document,bookings);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void printReservationReport(HttpServletResponse response, List<Reservation> reservations, String filename){
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\""+ filename + "\""); // file name

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            addReservationContent(document,reservations);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void addReportContent(Document document,List<Booking> bookings) throws DocumentException{

       Chunk chk = new Chunk("Booking Report");
        chk.setFont(new Font(Font.FontFamily.COURIER, 8, Font.BOLD));
        chk.setUnderline(0.2f, -2f);
        Paragraph pa = new Paragraph();
        pa.add(chk);
        pa.setAlignment(Element.ALIGN_LEFT);
        document.add(pa);
        document.add(new Paragraph("\n"));


        // add a table
        document.add(createReportTable(bookings));
    }
    private static void addReservationContent(Document document,List<Reservation> reservations) throws DocumentException{
        Chunk chk = new Chunk("Reservation Report");
        chk.setFont(new Font(Font.FontFamily.COURIER, 8, Font.BOLD));
        chk.setUnderline(0.2f, -2f);
        Paragraph pa = new Paragraph();
        pa.add(chk);
        pa.setAlignment(Element.ALIGN_LEFT);
        document.add(pa);
        document.add(new Paragraph("\n"));


        // add a table
        document.add(createReservationTable(reservations));
    }


    private static void addContent(Document document,Booking booking) throws DocumentException {

        Chunk chk = new Chunk("Booking Bill");
        chk.setFont(new Font(Font.FontFamily.COURIER, 8, Font.BOLD));
        chk.setUnderline(0.2f, -2f);
        Paragraph pa = new Paragraph();
        pa.add(chk);
        pa.setAlignment(Element.ALIGN_LEFT);
        document.add(pa);
        document.add(new Paragraph("\n"));

        // add a table
        document.add(createTable(booking));

    }

    private static PdfPTable createReportTable(List<Booking> bookings)
            throws BadElementException {
        PdfPTable table = new PdfPTable(7);

        PdfPCell c1 = new PdfPCell(new Phrase("Booking No"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Names"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("CheckIn Date"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Checkout Date"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("RoomId"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Nights"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Paid amount"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);


        for (Booking booking:bookings) {
            table.addCell(""+booking.getBookingId());
            table.addCell(""+booking.getNames());
            table.addCell(""+booking.getStartDate());
            table.addCell(""+booking.getCheckOutDate());
            table.addCell(""+booking.getRoomId());
            table.addCell(""+booking.getNights());
            table.addCell(""+booking.getAmount());
        }


        return table;
    }

    private static PdfPTable createReservationTable(List<Reservation> reservations)
            throws BadElementException {
        PdfPTable table = new PdfPTable(7);

        PdfPCell c1 = new PdfPCell(new Phrase("Reservation ID"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Names"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("StartDate"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("EndDate"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("RoomId"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Email"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Telephone"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);


        for (Reservation reservation:reservations) {
            table.addCell(""+reservation.getId());
            table.addCell(""+reservation.getNames());
            table.addCell(""+reservation.getStartDate());
            table.addCell(""+reservation.getEndDate());
            table.addCell(""+reservation.getRoomId());
            table.addCell(""+reservation.getEmail());
            table.addCell(""+reservation.getTel());
        }


        return table;
    }

    private static PdfPTable createTable(Booking booking)
            throws BadElementException {
        PdfPTable table = new PdfPTable(2);

        PdfPCell c1 = new PdfPCell(new Phrase("Booking No"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase(""+booking.getBookingId()));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);

        table.addCell("Names");
        table.addCell(""+booking.getNames());

        table.addCell("StartDate");
        table.addCell(""+booking.getStartDate());

        table.addCell("EndDate");
        table.addCell(""+booking.getEndDate());

        table.addCell("Nights");
        table.addCell(""+booking.getNights());

        table.addCell("Room Id");
        table.addCell(""+booking.getRoomId());

        table.addCell("Paid Amount:");
        table.addCell(""+booking.getAmount());

        return table;
    }
}
