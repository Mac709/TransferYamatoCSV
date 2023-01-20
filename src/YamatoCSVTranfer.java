import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class YamatoCSVTranfer {
  public static void main(String[] args) throws IOException {
    String line;
    String[][] data = new String[500][100];
    int i=0;
    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("trade.csv"), "UTF-8"))) {
   
      while ((line = br.readLine()) != null) {
        data[i] = line.split(",");
        i++;
      }
    } catch (IOException e) {
      System.out.print("ファイルが存在しませんでした。ファイルを準備してください。");
    }

    try (FileWriter file = new FileWriter("yamato.csv", false);
        PrintWriter pw = new PrintWriter(new BufferedWriter(file))) {

      for (int a = 0; a < data.length; a++) {
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
        pw.print(data[i][6]);//電話番号
        pw.print(",");
        pw.print(" ");
        pw.print(",");
        pw.print(data[i][4]);//郵便番号
        pw.print(",");
        pw.print(data[i][5]);//住所
        pw.print(",");
        pw.print("");
        pw.print(",");
        pw.print(data[i][1]);
        pw.print(",");
        pw.print("");
        pw.print(",");
        pw.print(data[i][3]);//氏名
        pw.print(",");
        pw.print("");
        pw.print(",");
        pw.print("");
        pw.print(",");
        pw.print("");
        pw.print(",");
        pw.print("#######");//依頼者電話番号
        pw.print(",");
        pw.print("");
        pw.print(",");
        pw.print("#####");//依頼者郵便番号
        pw.print(",");
        pw.print("#####");//依頼者住所
        pw.print(",");
        pw.print("#####");//依頼者組織名
        pw.print(",");
        pw.print("");
        pw.print(",");
        pw.print("");
        pw.print(",");
        pw.print(data[i][7]);
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
        pw.print("#####");//依頼者電話番号
        pw.print(",");
        pw.print("");
        pw.print(",");
        pw.print("1");
        pw.println();
        i++;
      }
      pw.close();
      System.out.println("銘柄残高のCSVファイルをYamato用に変換しました。");
    } catch (IOException e) {
      System.out.println("ファイルを読み込むことができませんでした。ファイルを確認してください。");
    }

 
  }
}
