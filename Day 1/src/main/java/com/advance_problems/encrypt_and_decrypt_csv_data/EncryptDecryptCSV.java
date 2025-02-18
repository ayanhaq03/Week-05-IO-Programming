package com.advance_problems.encrypt_and_decrypt_csv_data;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;

public class EncryptDecryptCSV {
    private static final String KEY = "1234567890123456"; // 16-byte encryption key

    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String encryptedFile = "encrypted_employees.csv";
        String decryptedFile = "decrypted_employees.csv";

        encryptCSV(inputFile, encryptedFile);
        decryptCSV(encryptedFile, decryptedFile);
    }

    // Encrypts the CSV file
    public static void encryptCSV(String inputFile, String outputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             FileWriter writer = new FileWriter(outputFile)) {

            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) { // Keep header as is
                    writer.write(line + "\n");
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                data[3] = encrypt(data[3]); // Encrypt salary
                writer.write(String.join(",", data) + "\n");
            }
            System.out.println("CSV file encrypted successfully.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Decrypts the CSV file
    public static void decryptCSV(String inputFile, String outputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             FileWriter writer = new FileWriter(outputFile)) {

            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) { // Keep header as is
                    writer.write(line + "\n");
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                data[3] = decrypt(data[3]); // Decrypt salary
                writer.write(String.join(",", data) + "\n");
            }
            System.out.println("CSV file decrypted successfully.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Method to encrypt a value
    private static String encrypt(String value) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(value.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting value: " + e.getMessage());
        }
    }

    // Method to decrypt a value
    private static String decrypt(String encryptedValue) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedValue));
            return new String(decryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error decrypting value: " + e.getMessage());
        }
    }
}

