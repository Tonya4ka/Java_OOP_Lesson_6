import java.util.UUID;

public class Homework {

    interface ReportCreator {
        Report createReport(Document document);
    }

    static class PdfReportCreator implements ReportCreator {
        @Override
        public Report createReport(Document document) {
            // create PDF report
            return new Report(new byte[0]); // placeholder
        }
    }

    static class JsonReportCreator implements ReportCreator {
        @Override
        public Report createReport(Document document) {
            // create JSON report
            return new Report(new byte[0]); // placeholder
        }
    }

    static class XmlReportCreator implements ReportCreator {
        @Override
        public Report createReport(Document document) {
            // create XML report
            return new Report(new byte[0]); // placeholder
        }
    }

    static class ReportFactory {
        public ReportCreator getReportCreator(String reportType) {
            switch (reportType) {
                case "PDF":
                    return new PdfReportCreator();
                case "JSON":
                    return new JsonReportCreator();
                case "XML":
                    return new XmlReportCreator();
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static void main(String[] args) {
        ReportFactory reportFactory = new ReportFactory();
        Document document = new Document();

        ReportCreator reportCreator = reportFactory.getReportCreator("PDF");
        Report pdfReport = reportCreator.createReport(document);

        reportCreator = reportFactory.getReportCreator("JSON");
        Report jsonReport = reportCreator.createReport(document);

        reportCreator = reportFactory.getReportCreator("XML");
        Report xmlReport = reportCreator.createReport(document);
    }

    public static class Document {
        private UUID id;
        private String number;
        // ...
    }

    public static class Report {
        private byte[] data;

        public Report(byte[] data) {
            this.data = data;
        }
    }
}

