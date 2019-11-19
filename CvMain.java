import java.awt.*;

public class CvMain {
  static void imageProcessing1() {
    String filename1 = "./anime/Chopper_org.jpg";
    String filename2 = "./anime/test_Chopper.jpg";
    MyImage image1, image2;
    image1 = JpegFileReader.read(filename1); {
      //image2 = Negative.execute(image1);
      //image2 = Binalization.execute(image1);
      //image2 = GammaCorrection.execute(image1);
      //image2 = SpaceFiltering.execute(image1);
      //image2 = Scale.execute(image1);

      //image2 = Rotation.execute(image1);
      image2 = Size.execute(image1, 0.5);
    }
    JpegFileWriter.write(filename2, image2);
  }
  // ワンピース
  static void imageProcessing2() {
    String filename00 = "./anime/onepiece.jpg";
    String filename0 = "./anime/beach.jpg";
    String filename1 = "./anime/Sanji.jpg";
    String filename2 = "./anime/Zoro.jpg";
    String filename3 = "./anime/Luffy.jpg";
    String filename4 = "./anime/Usopp.jpg";
    String filename5 = "./anime/Nami.jpg";
    String filename6 = "./anime/Robin.jpg";
    String filename7 = "./anime/Franky2.jpg";
    String filename8 = "./anime/Brook2.jpg";
    String filename9 = "./anime/Chopper.jpg";
    String filename10 = "./anime/Logo.jpg";

    MyImage image0, image1, image2, image3, image4, image5, image6, image7, image8, image9, image10,
        image7_b, image8_b, image9_s,
        image0_1, image0_2, image0_3, image0_4, image0_5, image0_6, image0_7, image0_8, image0_9, image0_10,
        image3_a, image3_b, image3_c, image3_d, image3_e,
        image2_a, image2_b,
        newpic, newpic2, newpic3, newpic4;
    image0 = JpegFileReader.read(filename0); // 背景
    image1 = JpegFileReader.read(filename1); // サンジ
    image2 = JpegFileReader.read(filename2); // ゾロ
    image3 = JpegFileReader.read(filename3); // ルフィ
    image4 = JpegFileReader.read(filename4); // ウソップ
    image5 = JpegFileReader.read(filename5); // ナミ
    image6 = JpegFileReader.read(filename6); // ロビン
    image7 = JpegFileReader.read(filename7); // フランキー
    image8 = JpegFileReader.read(filename8); // ブルック
    image9 = JpegFileReader.read(filename9); // チョッパー
    image10 = JpegFileReader.read(filename10); // ロゴ

    image7_b = Size.execute(image7, 1.5); // フランキーのサイズ変更
    image8_b = Size.execute(image8, 1.5); // ブルックのサイズ変更
    image9_s = Size.execute(image9, 0.5); // チョッパーのサイズ変更

    KMeans kmeans = new KMeans();
    kmeans.clustering(image1, 14);
    image0_1 = Chromakey.execute(image1, kmeans, 13, Color.blue);

    kmeans.clustering(image2, 14);
    image0_2 = Chromakey.execute(image2, kmeans, 13, Color.green);

    kmeans.clustering(image3, 14);
    image0_3 = Chromakey.execute(image3, kmeans, 13, Color.red);

    kmeans.clustering(image4, 14);
    image0_4 = Chromakey.execute(image4, kmeans, 13, Color.yellow);

    kmeans.clustering(image5, 14);
    image0_5 = Chromakey.execute(image5, kmeans, 13, Color.orange);

    kmeans.clustering(image6, 14);
    image0_6 = Chromakey.execute(image6, kmeans, 13, Color.magenta);

    kmeans.clustering(image7_b, 14);
    image0_7 = Chromakey.execute(image7_b, kmeans, 13, new Color(184, 134, 11));

    kmeans.clustering(image8_b, 14);
    image0_8 = Chromakey.execute(image8_b, kmeans, 13, new Color(106, 90, 205));

    kmeans.clustering(image9_s, 14);
    image0_9 = Chromakey.execute(image9_s, kmeans, 13, Color.pink);

    kmeans.clustering(image10, 14);
    image0_10 = Chromakey.execute(image10, kmeans, 0, Color.gray);

    // 6人くっつける
    image3_a = Tiling.execute(image0_1, image0_2);
    image3_b = Tiling.execute(image3_a, image0_3);
    image3_c = Tiling.execute(image3_b, image0_4);
    image3_d = Tiling.execute(image3_c, image0_5);
    image3_e = Tiling.execute(image3_d, image0_6);

    // 後ろ2人をくっつける
    image2_a = Tiling.execute(image0_7, image0_8);

    newpic = AlphaBlending2.execute(image2_a, image0, image2_a, 1);
    newpic2 = AlphaBlending2.execute(image3_e, newpic, image3_e, 1);
    newpic3 = AlphaBlending2.execute(image0_9, newpic2, image0_9, 1);
    newpic4 = AlphaBlending2.execute(image10, newpic3, image0_10, 0);

    //image3 = VirtualStudio.execute(image3_a, image5, image0);
    //image3 = AlphaBlending2.execute(image3_a, image5, image0);
    //image3 = Tiling.execute(image1, image2); 	
    JpegFileWriter.write(filename00, newpic4);
  }


  public static void main(String args[]) {
    //imageProcessing1();
    imageProcessing2();
  }
}
