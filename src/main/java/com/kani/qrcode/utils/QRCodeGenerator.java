package com.kani.qrcode.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.kani.qrcode.entity.Student;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {
    public static void generateQRCode(Student student) throws WriterException, IOException {

        String qrCodePath = "C:\\Users\\dell\\Desktop\\surot";
        String qrCodeName = qrCodePath + student.getFirstName() + student.getId() + "-QRCODE.png";

        var qrCodeWriter = new QRCodeWriter();

        BitMatrix bitMatrix = qrCodeWriter.encode(
                "ID: " + student.getId() + "\n" +
                "First Name: " + student.getFirstName() + "\n" +
                "Last Name: " + student.getLastName() + "\n" +
                "E-Mail: " + student.getEmail() + "\n" +
                "Mobile: " + student.getMobile(), BarcodeFormat.QR_CODE, 400,400 );
        Path path = FileSystems.getDefault().getPath(qrCodeName);
        MatrixToImageWriter.writeToFile(bitMatrix, "PNG", path.toFile());
    }
}
