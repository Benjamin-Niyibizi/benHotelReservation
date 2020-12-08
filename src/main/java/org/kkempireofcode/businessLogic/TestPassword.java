package org.kkempireofcode.businessLogic;

public class TestPassword {
    public static void main(String[] args) throws Exception {
        String pass ="qw";
        String password=EncriptPassword.byteArrayToHexString(EncriptPassword.computeHash(pass));
        System.out.println("Your encrypted pass is:"+ password);
    }
}
