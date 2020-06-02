package com.c8n.file;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.SCPInputStream;
import ch.ethz.ssh2.Session;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Log4j2
@Data
public class ServerSSH2 {

    private static Connection connection;
    private String username;
    private String password;
    private String ipAddress;
    private int port = 22;

    private ServerSSH2(String ipAddress, String username, String password) {
        this.ipAddress = ipAddress;
        this.connection = new Connection(ipAddress);
        this.username = username;
        this.password = password;
    }

    public static ServerSSH2 connectServer(String ipAddress, String username, String password) {
        ServerSSH2 ssh2 = new ServerSSH2(ipAddress, username, password);
        try {
            connection.connect();
            connection.authenticateWithPassword(username, password);
            log.info("连接服务器成功，服务器信息：{}", ssh2);
        } catch (IOException e) {
            log.error("连接ssh2服务器失败，请检查ip地址，用户名密码信息。");
            e.printStackTrace();
        }
        return ssh2;
    }

    /**
     * 同步服务器的单个文件到本地文件
     *
     * @param serverFilePath 服务器文件路径
     * @param localFile 不存在则创建一个文件（目录必须存在），存在则覆盖。
     */
    public void syncFileToLocal(String serverFilePath, String localFile) {
        try {
            File newLocalFile = new File(localFile);
            if (!newLocalFile.exists()) {
                newLocalFile.createNewFile();
            }

            log.info("Sync File {} to Local {}", serverFilePath, localFile);
            SCPClient scpClient = connection.createSCPClient();
            scpClient.setCharset(StandardCharsets.UTF_8.toString());
            SCPInputStream scpInputStream = scpClient.get(serverFilePath);
            FileUtils.writeByteArrayToFile(newLocalFile, IOUtils.toByteArray(scpInputStream));
        } catch (IOException e) {
            log.error("同步文件到本地出错， {}", e.getMessage());
            e.printStackTrace();
        }
    }
}
