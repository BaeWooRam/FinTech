package com.example.fintech.data;

import android.graphics.Bitmap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.Hashtable;

public class MsUtil {

    static public Bitmap m_createQrCode(String context){return m_createQrCode(context, 1000, 1000, ErrorCorrectionLevel.H, 12);}
    static public Bitmap m_createQrCode(String context, int qrW, int qrH){return m_createQrCode(context, qrW, qrH, ErrorCorrectionLevel.H, 12);}
    static public Bitmap m_createQrCode(String context, int qrW, int qrH, ErrorCorrectionLevel ErrorCorrectionLevel, int QR_VERSION)
    {
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            Hashtable hints = new Hashtable();
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel);
            hints.put(EncodeHintType.QR_VERSION, QR_VERSION);

            BitMatrix bitMatrix = multiFormatWriter.encode(context, BarcodeFormat.QR_CODE, qrW,qrH, hints);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);

            return bitmap;
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
