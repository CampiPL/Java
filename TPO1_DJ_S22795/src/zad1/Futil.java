package zad1;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Futil {

    static void processDir(String dirName, String resultFileName) {

            Path p1 = Paths.get(resultFileName);
            Path p2 = Paths.get(dirName);

            try {

            Files.deleteIfExists(p1);

            FileChannel file = FileChannel.open(p1, StandardOpenOption.CREATE_NEW, StandardOpenOption.APPEND);

            SimpleFileVisitor<Path> sfv = new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path p, BasicFileAttributes atr) throws IOException {

                    try (FileChannel fc = (FileChannel) Files.newByteChannel(p)) { //autoClosedChannel

                        MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
                        CharBuffer charBuffer = Charset.forName("Cp1250").decode(mbb);

                        file.write(StandardCharsets.UTF_8.encode(charBuffer));

                    }
                    return FileVisitResult.CONTINUE;
                }
            };

            Files.walkFileTree(p2, sfv);

            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
