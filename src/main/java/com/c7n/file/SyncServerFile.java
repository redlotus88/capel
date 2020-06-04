package com.c7n.file;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

@Log4j2
public class SyncServerFile {

    private static final String SERVER_IP = "10.130.161.112";

    private static final String SOURCE_PATH = "/home/appuser/logs/dcs-service-smi/";
    private static final String FILE_NAME = "error.2020-05-29.log";
    private static final String OUTPUT_PATH = "./tmp/";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("输入用户名: ");
        String username = input.next();
        System.out.print("输入密码: ");
        String password = input.next();

        log.info("用户名: [{}]", username);
        log.info("密码: [{}]", password);
        log.info("开始连接服务器....");

        ServerSSH2 serverSSH2 = ServerSSH2.connectServer(SERVER_IP, username, password);
        checkAndMkdirOutputDirectory();
        serverSSH2.syncFileToLocal(SOURCE_PATH + FILE_NAME, OUTPUT_PATH + FILE_NAME);
    }

    private static void checkAndMkdirOutputDirectory() {
        File file = new File(OUTPUT_PATH);
        log.info("输出地址: {}", OUTPUT_PATH);
        if (!file.exists()) {
            try {
                FileUtils.forceMkdir(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
