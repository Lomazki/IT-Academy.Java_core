package by.it.doNotTouch.zhuravaskarabahataya.calc.report;

interface ReportBuilder {

    void startReport();
    void addTitle();
    void addLaunchTime();
    void addEndTime();
    void addErrorAndExpressionReport();
    void writeReportToFile();
}
