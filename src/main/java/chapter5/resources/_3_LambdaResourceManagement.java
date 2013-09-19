package chapter5.resources;

import java.io.FileWriter;
import java.io.IOException;

/**
 * TODO Write purpose of Type
 *
 * @author adahotre
 */
public class _3_LambdaResourceManagement {
  public static void main(String[] args) throws IOException {
    FileWriterEAM.use("eam.txt", writerEAM -> writerEAM.writeStuff("hello.."));

    FileWriterEAM.use("eam2.txt", writerEAM -> { writerEAM.writeStuff("how"); writerEAM.writeStuff("sweet"); });
  }

  static class FileWriterEAM {
    private final FileWriter writer;

    private FileWriterEAM(final String fileName) throws IOException {
      writer = new FileWriter(fileName);
    }

    private void close() throws IOException {
      System.out.println("close called automatically...");
      writer.close();
    }

    public void writeStuff(final String message) throws IOException {
      writer.write(message);
    }

    public static void use(final String fileName, final UseInstance<FileWriterEAM, IOException> block) throws IOException {
      final FileWriterEAM writerEAM = new FileWriterEAM(fileName);
      try {
        block.accept(writerEAM);
      } finally {
        writerEAM.close();
      }
    }
  }

  @FunctionalInterface
  public interface UseInstance<T, X extends Throwable> {
    void accept(T instance) throws X;
  }
}
