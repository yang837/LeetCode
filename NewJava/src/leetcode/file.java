package leetcode;

import com.sun.istack.internal.NotNull;
import sun.rmi.log.LogInputStream;

import javax.swing.plaf.SliderUI;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class file {
    private static String dirname = "C:\\Users\\86187\\Desktop\\春风十里\\Linux\\考试范围";

    public static void write(FileOutputStream fos, File file) throws IOException {
        if (file.isDirectory()) {
            String[] dirs = file.list();
            for (String str : dirs) {
                String temp = str + "\r\n";
                byte[] bytes = temp.getBytes();
                fos.write(bytes);

                String path = dirname + "\\" + str;

                File file1 = new File(path);
                write(fos, file1);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        File file = new File(dirname);
        File file1 = new File("C:\\Users\\86187\\Desktop\\bb.txt");
        FileOutputStream fos = new FileOutputStream(file1);
        write(fos, file);
        fos.close();
    }
}
