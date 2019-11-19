
import java.awt.*;


public class AlphaBlending {

	static MyImage execute(MyImage input1, MyImage input2, MyImage input0) {

		int width1 = input1.width;
		int width2 = input2.width;
		int height1 = input1.height;
		int height2 = input2.height;

		int width  = (width1  > width2)  ? width1  : width2;
		int height = (height1 > height2) ? height1 : height2;

		MyImage output = new MyImage(width, height);

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				boolean isProcessed = false;

				if(i < height1 && j < width1) {

					Color color0 = input0.getColor(j, i);
					if(color0.getRed() > 0) {

						Color color1 = input1.getColor(j, i);
            Color color2 = input2.getColor(j, i);

            int r1 = color1.getRed();
            int g1 = color1.getGreen();
            int b1 = color1.getBlue();

            int r2 = color2.getRed();
            int g2 = color2.getGreen();
            int b2 = color2.getBlue();

            int R = (int)(r1*0.75 + r2*0.25);
            int G = (int)(g1*0.75 + g2*0.25);
            int B = (int)(b1*0.75 + g2*0.25);

            Color color3 = new Color(R, G, B);

						output.setColor(j, i, color3);

						isProcessed = true;
					}

				}

				if(i < height2 && j < width2) {
					if(isProcessed == false) {

						Color color2 = input2.getColor(j, i);
						output.setColor(j, i, color2);
					}
				}
			}
		}

		return output;

	}

}
