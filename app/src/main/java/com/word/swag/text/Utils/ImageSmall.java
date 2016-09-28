package com.word.swag.text.Utils;
import com.word.swag.text.R;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ThanhDat on 12/14/15.
 */
public class ImageSmall {

    ArrayList<Integer> arrImageLandscape = new ArrayList<Integer>();
    ArrayList<Integer> arrImagePortrait = new ArrayList<Integer>();
    ArrayList<Integer> arrImageSquare = new ArrayList<Integer>();
    ArrayList<Integer> arrWreath = new ArrayList<Integer>();
    ArrayList<Integer> arrCircle = new ArrayList<Integer>();
    ArrayList<Integer> arrBadge = new ArrayList<Integer>();
    ArrayList<Integer> arrChalk = new ArrayList<Integer>();
    ArrayList<Integer> arrTemp23 = new ArrayList<Integer>();
    ArrayList<Integer> arrTemp24 = new ArrayList<Integer>();
    ArrayList<Integer> arrTemp25 = new ArrayList<Integer>();
    ArrayList<Integer> arrTemp26 = new ArrayList<Integer>();

    Random random = new Random();
    int number;

    public ArrayList<Integer> getArrImageLandscape(){
        arrImageLandscape.add(R.drawable.image_landscape_1);
        arrImageLandscape.add(R.drawable.image_landscape_2);
        arrImageLandscape.add(R.drawable.image_landscape_3);
        arrImageLandscape.add(R.drawable.image_landscape_4);
        arrImageLandscape.add(R.drawable.image_landscape_5);
        return arrImageLandscape;
    }

    public ArrayList<Integer> getArrImagePortrait(){
        arrImagePortrait.add(R.drawable.image_portrait_1);
        arrImagePortrait.add(R.drawable.image_portrait_2);
        arrImagePortrait.add(R.drawable.image_portrait_3);
        arrImagePortrait.add(R.drawable.image_portrait_4);
        arrImagePortrait.add(R.drawable.image_portrait_5);
        return arrImagePortrait;
    }

    public ArrayList<Integer> getArrImageSquare(){
        arrImageSquare.add(R.drawable.image_square_1);
        arrImageSquare.add(R.drawable.image_square_2);
        arrImageSquare.add(R.drawable.image_square_3);
        arrImageSquare.add(R.drawable.image_square_4);
        arrImageSquare.add(R.drawable.image_square_5);
        arrImageSquare.add(R.drawable.image_square_6);
        arrImageSquare.add(R.drawable.image_square_7);
        return arrImageSquare;
    }

    public ArrayList<Integer> getArrWreath(){
        arrWreath.add(R.mipmap.wreath1);
        arrWreath.add(R.mipmap.wreath2);
        arrWreath.add(R.mipmap.wreath3);
        arrWreath.add(R.mipmap.wreath4);
        arrWreath.add(R.mipmap.wreath5);
        return arrWreath;
    }

    public ArrayList<Integer> getArrCircle(){
        arrCircle.add(R.mipmap.circle1);
        arrCircle.add(R.mipmap.circle2);
        arrCircle.add(R.mipmap.circle3);
        arrCircle.add(R.mipmap.circle4);
        return arrCircle;
    }

    public ArrayList<Integer> getArrBadge(){
        arrBadge.add(R.mipmap.badge1);
        arrBadge.add(R.mipmap.badge2);
        arrBadge.add(R.mipmap.badge3);
        arrBadge.add(R.mipmap.badge4);
        arrBadge.add(R.mipmap.badge5);
        arrBadge.add(R.mipmap.badge6);
        arrBadge.add(R.mipmap.badge7);
        arrBadge.add(R.mipmap.badge8);
        arrBadge.add(R.mipmap.badge9);
        arrBadge.add(R.mipmap.badge10);
        arrBadge.add(R.mipmap.badge11);
        arrBadge.add(R.mipmap.badge12);
        return arrBadge;
    }

    public ArrayList<Integer> getArrTemp23(){
        arrTemp23.add(R.mipmap.square_01);
        arrTemp23.add(R.mipmap.square_02);
        arrTemp23.add(R.mipmap.square_03);
        arrTemp23.add(R.mipmap.square_04);
        arrTemp23.add(R.mipmap.square_05);
        arrTemp23.add(R.mipmap.square_06);
        return arrTemp23;
    }

    public ArrayList<Integer> getArrTemp24(){
        arrTemp24.add(R.mipmap.temp24_01);
        arrTemp24.add(R.mipmap.temp24_02);
        arrTemp24.add(R.mipmap.temp24_03);
        arrTemp24.add(R.mipmap.temp24_04);
        return arrTemp24;
    }

    public ArrayList<Integer> getArrTemp25(){
        arrTemp25.add(R.mipmap.temp25_01);
        arrTemp25.add(R.mipmap.temp25_02);
        arrTemp25.add(R.mipmap.temp25_03);
        arrTemp25.add(R.mipmap.temp25_04);
        return arrTemp25;
    }

    public ArrayList<Integer> getArrTemp26(){
        arrTemp26.add(R.mipmap.temp26_01);
        arrTemp26.add(R.mipmap.temp26_02);
        arrTemp26.add(R.mipmap.temp26_03);
        arrTemp26.add(R.mipmap.temp26_04);
        arrTemp26.add(R.mipmap.temp26_05);
        arrTemp26.add(R.mipmap.temp26_06);
        arrTemp26.add(R.mipmap.temp26_07);
        arrTemp26.add(R.mipmap.temp26_08);
        arrTemp26.add(R.mipmap.temp26_09);
        return arrTemp26;
    }

    public ArrayList<Integer> getArrChalk(){
        arrChalk.add(R.mipmap.chalk1);
        arrChalk.add(R.mipmap.chalk2);
        arrChalk.add(R.mipmap.chalk3);
        arrChalk.add(R.mipmap.chalk4);
        arrChalk.add(R.mipmap.chalk5);
        arrChalk.add(R.mipmap.chalk6);
        return arrChalk;
    }

    public int getRandomImageLandscape(){
        number = random.nextInt(getArrImageLandscape().size());
        return getArrImageLandscape().get(number);
    }

    public int getRandomImagePortrait(){
        number = random.nextInt(getArrImagePortrait().size());
        return getArrImagePortrait().get(number);
    }

    public int getRandomImageSquare(){
        number = random.nextInt(getArrImageSquare().size());
        return getArrImageSquare().get(number);
    }

    public int getRandomWreath(){
        number = random.nextInt(getArrWreath().size());
        return getArrWreath().get(number);
    }

    public int getRandomCircle(){
        number = random.nextInt(getArrCircle().size());
        return getArrCircle().get(number);
    }

    public int getRandomBadge(){
        number = random.nextInt(getArrCircle().size());
        return getArrBadge().get(number);
    }

    public int getRandomChalk(){
        number = random.nextInt(getArrCircle().size());
        return getArrChalk().get(number);
    }

    public int getRandomTemp23(){
        number = random.nextInt(getArrTemp23().size());
        return getArrTemp23().get(number);
    }

    public int getRandomTemp24(){
        number = random.nextInt(getArrTemp24().size());
        return getArrTemp24().get(number);
    }

    public int getRandomTemp25(){
        number = random.nextInt(getArrTemp25().size());
        return getArrTemp25().get(number);
    }

    public int getRandomTemp26(){
        number = random.nextInt(getArrTemp26().size());
        return getArrTemp26().get(number);
    }
}
