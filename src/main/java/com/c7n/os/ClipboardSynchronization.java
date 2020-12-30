package com.c7n.os;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 剪贴板同步功能
 *
 * @author jialong.wang
 * @Date on 2020/12/22 10:45 AM
 * @since 1.0
 */
public class ClipboardSynchronization {

    public static void main(String[] args) {

        final Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        Transferable contents = new Transferable() {
            DataFlavor[] dataFlavors = new DataFlavor[] { DataFlavor.javaFileListFlavor };

            @Override
            public DataFlavor[] getTransferDataFlavors() {
                return dataFlavors;
            }

            @Override
            public boolean isDataFlavorSupported(DataFlavor dataFlavor) {
                for (int i = 0; i < dataFlavors.length; i++) {
                    if (dataFlavors[i].equals(dataFlavor)) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public Object getTransferData(DataFlavor dataFlavor) throws UnsupportedFlavorException, IOException {
                List<File> files = new ArrayList<File>();
                files.add(new File("/Users/dragon/Downloads/usingthymeleaf.pdf"));
                return files;
            }
        };

        systemClipboard.setContents(contents, null);
    }

    public void setClipboardString(String text) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable trans = new StringSelection(text);
        clipboard.setContents(trans, null);
    }


}
