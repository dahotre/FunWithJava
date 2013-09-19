package chapter5.resources;

import java.io.FileWriter;
import java.io.IOException;

/**
 * TODO Write purpose of Type
 *
 * @author adahotre
 */
public class _1_RelyOnFinalize {

  public static void main(String[] args) throws IOException {
    final FileWriterExample writerExample = new FileWriterExample("peekaboo.txt");
    writerExample.writeStuff("peek-a-boo");
  }


  static class FileWriterExample {
    private final FileWriter writer;
    public FileWriterExample(final String fileName) throws IOException {
      writer = new FileWriter(fileName);
    }

    public void writeStuff(final String message) throws IOException {
      writer.write(message);
    }
    public void finalize() throws IOException {
      writer.close();
    }
  }
}
