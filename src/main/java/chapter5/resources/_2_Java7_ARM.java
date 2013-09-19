package chapter5.resources;

import java.io.FileWriter;
import java.io.IOException;

/**
 * TODO Write purpose of Type
 *
 * @author adahotre
 */
public class _2_Java7_ARM {

  public static void main(String[] args) {
    try (final FileWriterWithARM writerExample = new FileWriterWithARM("peekaboo.txt")) {
      writerExample.writeStuff("peek-a-boo");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  static class FileWriterWithARM implements AutoCloseable {
    private final FileWriter writer;
    public FileWriterWithARM(final String fileName) throws IOException {
      writer = new FileWriter(fileName);
    }

    public void writeStuff(final String message) throws IOException {
      writer.write(message);
    }

    @Override
    public void close() throws Exception {
      writer.close();
    }
  }
}
