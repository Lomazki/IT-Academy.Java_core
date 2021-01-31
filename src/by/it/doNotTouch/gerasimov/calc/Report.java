package by.it.doNotTouch.gerasimov.calc;

class Report {
    private ReportBuilder builder;

    void setBuilder(ReportBuilder builder) {
        this.builder = builder;
    }

    void printReport() {
        builder.addHeader();
        builder.addRunningTime();
        builder.addLines();
        builder.print();
    }
}
