package com.bl.employeepayrollapp.service;

import com.bl.employeepayrollapp.model.uc4.Payslip;

import java.io.FileWriter;
import java.io.IOException;

public class FileService {

    public String savePayslipAsText(Payslip payslip) throws IOException {

        // unique filename using timestamp
        String fileName = "Payslip_" + payslip.getEmpId() + "_" +
                System.currentTimeMillis() + ".txt";

        FileWriter fw = new FileWriter(fileName);
        fw.write(payslip.toString());
        fw.close();

        return fileName;
    }

    // simple PDF support: save same content in .pdf extension
    public String savePayslipAsPdf(Payslip payslip) throws IOException {

        String fileName = "Payslip_" + payslip.getEmpId() + "_" +
                System.currentTimeMillis() + ".pdf";

        FileWriter fw = new FileWriter(fileName);
        fw.write(payslip.toString()); // NOTE: simple text content with .pdf extension
        fw.close();

        return fileName;
    }
}
