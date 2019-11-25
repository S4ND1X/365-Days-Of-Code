package com.android.loginandform;

public class Reporte {

    private String workerEmail, reportDate, reportText;

    public Reporte(String workerEmail, String reportDate, String reportText){
        this.workerEmail = workerEmail;
        this.reportDate = reportDate;
        this.reportText = reportText;
    }


    public String getWorkerEmail() {
        return workerEmail;
    }

    public String getReportDate() {
        return reportDate;
    }

    public String getReportText() {
        return reportText;
    }



}
