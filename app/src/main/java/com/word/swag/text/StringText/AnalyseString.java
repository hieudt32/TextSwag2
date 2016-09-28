package com.word.swag.text.StringText;

import android.util.Log;

import com.word.swag.text.Activity.MainActivity;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ThanhDat on 12/9/15.
 */
public class AnalyseString {
    public String mText = MainActivity.getmText();
    public int[] a = new int[100];
    public ArrayList<Integer> arrResult = new ArrayList<Integer>();
    public ArrayList<Integer> arrValue = new ArrayList<Integer>();
    int k;
    int n = Calculate.countSpace(mText);

    public AnalyseString(int k) {
        this.k = k;
        combination();
        resultValueSpace();
    }

    public void resultValueSpace() {
        int x = arrValue.size() / k;
        int y = new Random().nextInt(x);
        int j = 0;
        int[] result = new int[k];
        for (int i = y*k; i < y*k + k; i++, j++) {
            result[j] = arrValue.get(i);
            Log.d("dat", "resultValue: " + result[j]);
            arrResult.add(result[j]);
        }
    }

    public String [] result(){
//        String[] a = splitStr(mText, arrResult);
//        for (int i = 0; i< a.length; i++){
//            Log.d("dat", "in result: "+a[i]);
//        }
        return splitStr(mText, arrResult);
    }

    public String[] splitStr(String str, ArrayList<Integer> arrPoints) {
        String[] resultData = new String[arrPoints.size() + 1];
        int start = 0;
        int currentPoint = 0;
        int currentIndex = 0;
        int currentSpaceIndex = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                if (arrPoints.get(currentPoint) == currentSpaceIndex) {
                    resultData[currentIndex] = str.substring(start, i);
                    currentIndex++;
                    currentPoint++;
                    start = i + 1;
                    if (currentPoint == arrPoints.size()){
                        break;
                    }
                }
                currentSpaceIndex++;
            }
        }
        resultData[currentIndex] = str.substring(start);
        return resultData;
    }

    private void printResultBackTrack() {
        for (int i = 1; i <= k; i++) {
            arrValue.add(a[i]);
        }
    }

    public void backTrack(int i) {
        for (int j = a[i - 1] + 1; j <= n - k + i; j++) {
            a[i] = j;
            if (i == k) {
                printResultBackTrack();
            } else {
                backTrack(i + 1);
            }

        }
    }

    public void combination() {
        if (k >= 0 && k <= n) {
            a[0] = 0;
            backTrack(1);
        } else {
            System.out.println("không thoả mãn điều kiện 0 <= k <= n");


        }
    }

    public void setmText(String mText) {
        this.mText = mText;
    }
}
