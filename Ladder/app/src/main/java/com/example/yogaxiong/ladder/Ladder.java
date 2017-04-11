package com.example.yogaxiong.ladder;

/**
 * Created by YogaXiong on 2017/4/8.
 */

public class Ladder {
    private String ip;
    private String port;
    private String password;
    private String encription;
    private String QRCode;

    Ladder(String ip, String port, String password, String encription, String QRCode) {
        this.ip = ip;
        this.port = port;
        this.password = password;
        this.encription = encription;
        this.QRCode = QRCode;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncription() {
        return encription;
    }

    public void setEncription(String encription) {
        this.encription = encription;
    }

    public String getQRCode() {
        return QRCode;
    }

    public void setQRCode(String QRCode) {
        this.QRCode = QRCode;
    }

    public String getIpText() {
        return "ip: " + getIp();
    }

    public String getPortText() {
        return "port: " + getPort();
    }

    public String getPasswordText() {
        return "port: " + getPassword();
    }

    public String getEncriptionText() {
        return "encryption: " + getEncription();
    }
}