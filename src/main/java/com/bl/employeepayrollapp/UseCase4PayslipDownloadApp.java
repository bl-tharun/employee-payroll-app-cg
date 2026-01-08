package com.bl.employeepayrollapp;

import com.bl.employeepayrollapp.model.uc4.Payslip;
import com.bl.employeepayrollapp.service.FileService;
import com.bl.employeepayrollapp.session.DownloadToken;

public class UseCase4PayslipDownloadApp {

    public static void main(String[] args) {

        System.out.println("=== USE CASE 4: PAYSLIP PRINT / DOWNLOAD ===");

        // existing generated payslip
        Payslip original = new Payslip("EMP-1010", "John David", "January 2026", 48500.00);

        System.out.println("\nOriginal Payslip:");
        System.out.println(original);

        try {
            // Step 1 → Clone
            Payslip downloadCopy = (Payslip) original.clone();

            // Step 2 → Validate equality
            if (original.equals(downloadCopy)) {
                System.out.println("Verified: Download copy is equal to original.");
            }

            // Step 3 → Hash comparison
            System.out.println("Original hashcode : " + original.hashCode());
            System.out.println("Cloned   hashcode : " + downloadCopy.hashCode());

            // Step 4 → Create download token (expiry)
            DownloadToken token = new DownloadToken();

            if (token.isExpired()) {
                System.out.println("Download link expired.");
                return;
            }

            // Step 5 → Save File
            FileService fs = new FileService();

            String textFile = fs.savePayslipAsText(downloadCopy);
            String pdfFile = fs.savePayslipAsPdf(downloadCopy);

            // Step 6 → Confirm
            System.out.println("\nPayslip Download Successful.");
            System.out.println("Saved as text file: " + textFile);
            System.out.println("Saved as PDF file : " + pdfFile);

            // Step 7 → Print to console
            System.out.println("\n--- Printed Payslip ---");
            System.out.println(downloadCopy);

        } catch (Exception e) {
            System.out.println("Error during payslip download.");
        }
    }
}
