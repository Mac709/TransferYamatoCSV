import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class YamatoCSVTranfer {
  public static void main(String[] args) throws IOException {
    String line;
    // ファイルパス
    Path path = Paths.get("trade.csv");
    // ファイルの行数
    long lineCount = Files.lines(path).count();
    String[][] data = new String[(int) lineCount][9];

    int i = 0;
    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("trade.csv"), "UTF-8"))) {
      while ((line = br.readLine()) != null) {
        data[i] = line.split(",");
        i++;
      }
    } catch (IOException e) {
      System.out.print("ファイルが存在しませんでした。ファイルを準備してください。");
    } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
      System.out.println("配列の範囲外にアクセスしようとしました。");
    }

    try (PrintWriter pw = new PrintWriter(
        new BufferedWriter(new OutputStreamWriter(new FileOutputStream("yamato.csv"), "Shift-JIS")))) {

      int num = 2;
      int countList = 0;
      while (data[num].length > 4) {
        countList = num + 1;
        num++;
      }

      for (int a = 2; a < countList; a++) {
        pw.print(" ");
        pw.print(",");

        pw.print(" ");
        pw.print(",");

        pw.print(" ");
        pw.print(",");

        pw.print(" ");
        pw.print(",");

        pw.print(" ");
        pw.print(",");

        pw.print("2023/01/20");
        pw.print(",");

        pw.print(" ");
        pw.print(",");

        pw.print(" ");
        pw.print(",");

        pw.print(" ");
        pw.print(",");

        pw.print(data[a][6]);// 電話番号
        pw.print(",");

        pw.print(" ");
        pw.print(",");

        pw.print(data[a][4]);// 郵便番号
        pw.print(",");

        pw.print(data[a][5]);// 住所
        pw.print(",");

        pw.print("");
        pw.print(",");

        pw.print(data[a][1]);// 会社名
        pw.print(",");

        pw.print("");
        pw.print(",");

        pw.print(data[a][3]);// 氏名
        pw.print(",");

        pw.print("");
        pw.print(",");

        pw.print("");
        pw.print(",");

        pw.print("");
        pw.print(",");

        pw.print("######");// 依頼者電話番号
        pw.print(",");

        pw.print("");
        pw.print(",");

        pw.print("#####");// 依頼者郵便番号
        pw.print(",");

        pw.print("###");// 依頼者住所
        pw.print(",");

        pw.print("");
        pw.print(",");

        pw.print("###");// 依頼者組織名
        pw.print(",");

        pw.print("");
        pw.print(",");

        pw.print("");
        pw.print(",");

        pw.print(data[a][7]);
        pw.print(",");

        pw.print("");
        pw.print(",");

        pw.print("");
        pw.print(",");

        pw.print("");
        pw.print(",");

        pw.print("");
        pw.print(",");

        pw.print("");
        pw.print(",");

        pw.print("");
        pw.print(",");

        pw.print("");
        pw.print(",");

        pw.print("");
        pw.print(",");

        pw.print("");
        pw.print(",");

        pw.print("");
        pw.print(",");

        pw.print("");
        pw.print(",");

        pw.print("######");// 依頼者電話番号
        pw.print(",");

        pw.print("");
        pw.print(",");

        pw.print("01");
        pw.println();
      }
      pw.close();
      System.out.println("銘柄残高のCSVファイルをYamato用に変換しました。");
    } catch (IOException e) {
      System.out.println("ファイルを読み込むことができませんでした。ファイルを確認してください。");
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("data配列の範囲外にアクセスしようとしました。");
    } catch (NullPointerException e) {
      System.out.println("nullの範囲外にアクセスしようとしました。");
    }
  }
}
