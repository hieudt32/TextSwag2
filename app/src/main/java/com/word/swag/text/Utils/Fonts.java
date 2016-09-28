package com.word.swag.text.Utils;

import android.graphics.Typeface;

import com.word.swag.text.Activity.MainActivity;

import java.util.Random;

/**
 * Created by ThanhDat on 12/14/15.
 */
public class Fonts {

    public static Typeface typeface[] = new Typeface[]{Typeface.createFromAsset(MainActivity.getmContext().getAssets(),
            "fonts/cabinsketch.ttf"), Typeface.createFromAsset(MainActivity.getmContext().getAssets(),
            "fonts/chunkfive.otf"), Typeface.createFromAsset(MainActivity.getmContext().getAssets(),
            "fonts/crayon.ttf"), Typeface.createFromAsset(MainActivity.getmContext().getAssets(),
            "fonts/sesame.ttf"), Typeface.createFromAsset(MainActivity.getmContext().getAssets(),
            "fonts/capture.ttf"), Typeface.createFromAsset(MainActivity.getmContext().getAssets(),
            "fonts/market.ttf"), Typeface.createFromAsset(MainActivity.getmContext().getAssets(),
            "fonts/valentine.ttf"), Typeface.createFromAsset(MainActivity.getmContext().getAssets(),
            "fonts/droidsan.ttf"), Typeface.createFromAsset(MainActivity.getmContext().getAssets(),
            "fonts/typo.otf"), Typeface.createFromAsset(MainActivity.getmContext().getAssets(),
            "fonts/sketch.otf"), Typeface.createFromAsset(MainActivity.getmContext().getAssets(),
            "fonts/floral.ttf"), Typeface.createFromAsset(MainActivity.getmContext().getAssets(),
            "fonts/howdoyousleep.ttf"), Typeface.createFromAsset(MainActivity.getmContext().getAssets(),
            "fonts/sympathy.ttf"), Typeface.createFromAsset(MainActivity.getmContext().getAssets(),
            "fonts/campanile.ttf"), Typeface.createFromAsset(MainActivity.getmContext().getAssets(),
            "fonts/mailr.otf"), Typeface.createFromAsset(MainActivity.getmContext().getAssets(),
            "fonts/acaslonpro.ttf"), Typeface.createFromAsset(MainActivity.getmContext().getAssets(),
            "fonts/sablon.otf"), Typeface.createFromAsset(MainActivity.getmContext().getAssets(),
            "fonts/firebug.ttf"), Typeface.createFromAsset(MainActivity.getmContext().getAssets(),
            "fonts/sancreek.ttf"), Typeface.createFromAsset(MainActivity.getmContext().getAssets(),
            "fonts/payday.ttf"), Typeface.createFromAsset(MainActivity.getmContext().getAssets(),
            "fonts/mybigheart.ttf"), Typeface.createFromAsset(MainActivity.getmContext().getAssets(),
            "fonts/twinpine.ttf"), Typeface.createFromAsset(MainActivity.getmContext().getAssets(),
            "fonts/dutchtulips.ttf"), Typeface.createFromAsset(MainActivity.getmContext().getAssets(),
            "fonts/creatvibes.otf"), Typeface.createFromAsset(MainActivity.getmContext().getAssets(),
            "fonts/sketchhandwriting.otf"), Typeface.createFromAsset(MainActivity.getmContext().getAssets(),
            "fonts/ficticcia.otf"), Typeface.createFromAsset(MainActivity.getmContext().getAssets(),
            "fonts/Tremolo.ttf"), Typeface.createFromAsset(MainActivity.getmContext().getAssets(),
            "fonts/edselfont.ttf"), Typeface.createFromAsset(MainActivity.getmContext().getAssets(),
            "fonts/Amadeus.ttf")};

    public static Typeface getRandomTypeface(){
        Random random = new Random();
        int number = random.nextInt(typeface.length);
        return typeface[number];
    }
}
