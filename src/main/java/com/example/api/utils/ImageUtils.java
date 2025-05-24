package com.example.api.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import java.util.zip.DataFormatException;
public class ImageUtils {
    // Nén dữ liệu ảnh
    public static byte[] compressImage(byte[] data) throws IOException {
        // Kiểm tra xem dữ liệu ảnh có phải là JPEG hay không trước khi nén thêm
        if (isJPEG(data)) {
            // Nếu là JPEG, bỏ qua việc nén vì nó đã được nén
            return data;
        }

        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length)) {
            byte[] buffer = new byte[4096];  // Sử dụng buffer lớn hơn để tăng hiệu quả
            while (!deflater.finished()) {
                int count = deflater.deflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            return outputStream.toByteArray();
        }
    }

    // Giải nén dữ liệu ảnh
    public static byte[] decompressImage(byte[] data) throws IOException {
        Inflater inflater = new Inflater();
        inflater.setInput(data);

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length)) {
            byte[] buffer = new byte[4096];  // Sử dụng buffer lớn hơn
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            return outputStream.toByteArray();
        } catch (DataFormatException e) {
            throw new IOException("Failed to decompress image: Invalid format", e);
        } catch (Exception e) {
            throw new IOException("Failed to decompress image", e);
        }
    }

    // Kiểm tra xem dữ liệu có phải là ảnh JPEG không
    private static boolean isJPEG(byte[] data) {
        // JPEG thường có 2 byte đầu tiên là 0xFFD8 và 2 byte cuối cùng là 0xFFD9
        return data.length >= 4 &&
                (data[0] == (byte) 0xFF) && (data[1] == (byte) 0xD8) &&
                (data[data.length - 2] == (byte) 0xFF) && (data[data.length - 1] == (byte) 0xD9);
    }
}
