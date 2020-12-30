package com.c7n.os;

import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;
import java.util.Date;

/**
 * 剪贴板监听功能
 *
 * @author jialong.wang
 * @Date on 2020/12/22 11:12 AM
 * @since 1.0
 */
public class SystemClipboardMonitor implements ClipboardOwner {

    private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    public SystemClipboardMonitor() {
        //如果剪贴板中有文本，则将它的ClipboardOwner设为自己
        if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
            clipboard.setContents(clipboard.getContents(null), this);
        }
    }

    /************
     * 测试代码 *
     * **********
     */
    public static void main(String[] args) {
        SystemClipboardMonitor temp = new SystemClipboardMonitor();
//        temp.clipboard.addFlavorListener(new FlavorListener() {
//            @Override
//            public void flavorsChanged(FlavorEvent flavorEvent) {
//                System.out.println("flavor event : " + flavorEvent);
//            }
//        });

        new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                int i = 0;
                while (i < Integer.MAX_VALUE - 1) {
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)){
                        try {
                            String text = (String) clipboard.getData(DataFlavor.stringFlavor);
                            System.out.println(new Date().toString() + " 监控到剪贴板： " + text);
                        } catch (UnsupportedFlavorException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    if (i % 20 == 0) {
                        System.gc();
                    }

                    Thread.sleep(2000L);
                    i++;
                }


            }
        }.run();

        // 软件窗口
        new JFrame().setVisible(true);
    }

    /**********************************************
     * 如果剪贴板的内容改变，则系统自动调用此方法 *
     **********************************************
     */
    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        // 如果不暂停一下，经常会抛出IllegalStateException
        // 猜测是操作系统正在使用系统剪切板，故暂时无法访问
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 取出文本并进行一次文本处理
        String text = null;
        if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)){
            try {
                text = (String)clipboard.getData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 自定义的处理方法
        System.out.println(text);
//        String clearedText = Text.handle(text);
//         存入剪贴板，并注册自己为所有者
//         用以监控下一次剪贴板内容变化
        StringSelection tmp = new StringSelection(text);
        clipboard.setContents(tmp, this);
    }

    public void setClipboardString(String text) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable trans = new StringSelection(text);
        clipboard.setContents(trans, null);
    }

}
