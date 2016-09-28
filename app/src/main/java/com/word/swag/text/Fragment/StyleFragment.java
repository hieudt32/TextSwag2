package com.word.swag.text.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.word.swag.text.Activity.MainActivity;
import com.word.swag.text.Animation.BaseAnimation;
import com.word.swag.text.Animation.Techniques;
import com.word.swag.text.R;
import com.word.swag.text.View.Style.MyStyleViewEight;
import com.word.swag.text.View.Style.MyStyleViewEightTeen;
import com.word.swag.text.View.Style.MyStyleViewEleven;
import com.word.swag.text.View.Style.MyStyleViewFitteen;
import com.word.swag.text.View.Style.MyStyleViewFive;
import com.word.swag.text.View.Style.MyStyleViewFour;
import com.word.swag.text.View.Style.MyStyleViewFourteen;
import com.word.swag.text.View.Style.MyStyleViewNine;
import com.word.swag.text.View.Style.MyStyleViewNineTeen;
import com.word.swag.text.View.Style.MyStyleViewOne;
import com.word.swag.text.View.Style.MyStyleViewSeven;
import com.word.swag.text.View.Style.MyStyleViewSevenTeen;
import com.word.swag.text.View.Style.MyStyleViewSix;
import com.word.swag.text.View.Style.MyStyleViewSixTeen;
import com.word.swag.text.View.Style.MyStyleViewTen;
import com.word.swag.text.View.Style.MyStyleViewThirteen;
import com.word.swag.text.View.Style.MyStyleViewThree;
import com.word.swag.text.View.Style.MyStyleViewTwelve;
import com.word.swag.text.View.Style.MyStyleViewTwenty;
import com.word.swag.text.View.Style.MyStyleViewTwentyOne;
import com.word.swag.text.View.Style.MyStyleViewTwo;
import com.word.swag.text.View.Style.TemplatePurchase.MyStyleViewTwentyEight;
import com.word.swag.text.View.Style.TemplatePurchase.MyStyleViewTwentyFive;
import com.word.swag.text.View.Style.TemplatePurchase.MyStyleViewTwentyFour;
import com.word.swag.text.View.Style.TemplatePurchase.MyStyleViewTwentySeven;
import com.word.swag.text.View.Style.TemplatePurchase.MyStyleViewTwentySix;
import com.word.swag.text.View.Style.TemplatePurchase.MyStyleViewTwentyThree;
import com.word.swag.text.View.Style.TemplatePurchase.MyStyleViewTwentyTwo;
import com.word.swag.text.View.TouchBaseView;

/**
 * Created by ThanhDat on 12/18/15.
 */
public class StyleFragment extends Fragment implements View.OnClickListener {
    private View styleOne, styleTwo, styleThree, styleFour, styleFive, styleSix,
            styleSeven, styleEight, styleNine, styleTen, styleEleven, styleTwelve,
            styleThirteen, styleFourteen, styleFifteen, styleSixteen, styleSeventeen,
            styleEighteen, styleNineteen, styleTwenty, styleTwentyOne, styleTwentyTwo,
            styleTwentyThree, styleTwentyFour, styleTwentyFive, styleTwentySix, styleTwentySeven,
            styleTwentyEight;
    private FrameLayout fl_styleOne, fl_styleTwo, fl_styleThree, fl_styleFour, fl_styleFive, fl_styleSix,
            fl_styleSeven, fl_styleEight, fl_styleNine, fl_styleTen, fl_styleEleven, fl_styleTwelve,
            fl_styleThirteen, fl_styleFourteen, fl_styleFifteen, fl_styleSixteen, fl_styleSeventeen,
            fl_styleEighteen, fl_styleNineteen, fl_styleTwenty, fl_styleTwentyOne, fl_styleTwentyTwo,
            fl_styleTwentyThree, fl_styleTwentyFour, fl_styleTwentyFive, fl_styleTwentySix, fl_styleTwentySeven,
            fl_styleTwentyEight;
    private TouchBaseView frm_container;
    public MyStyleViewOne myStyleViewOne;
    public MyStyleViewTwo myStyleViewTwo;
    public MyStyleViewThree myStyleViewThree;
    public MyStyleViewFour myStyleViewFour;
    public MyStyleViewFive myStyleViewFive;
    public MyStyleViewSix myStyleViewSix;
    public MyStyleViewSeven myStyleViewSeven;
    public MyStyleViewEight myStyleViewEight;
    public MyStyleViewNine myStyleViewNine;
    public MyStyleViewTen myStyleViewTen;
    public MyStyleViewEleven myStyleViewEleven;
    public MyStyleViewTwelve myStyleViewTwelve;
    public MyStyleViewThirteen myStyleViewThirteen;
    public MyStyleViewFourteen myStyleViewFourteen;
    public MyStyleViewFitteen myStyleViewFitteen;
    public MyStyleViewSixTeen myStyleViewSixteen;
    public MyStyleViewSevenTeen myStyleViewSeventeen;
    public MyStyleViewEightTeen myStyleViewEightTeen;
    public MyStyleViewNineTeen myStyleViewNineTeen;
    public MyStyleViewTwenty myStyleViewTwenty;
    public MyStyleViewTwentyOne myStyleViewTwentyOne;
    public MyStyleViewTwentyTwo myStyleViewTwentyTwo;
    public MyStyleViewTwentyThree myStyleViewTwentyThree;
    public MyStyleViewTwentyFour myStyleViewTwentyFour;
    public MyStyleViewTwentyFive myStyleViewTwentyFive;
    public MyStyleViewTwentySix myStyleViewTwentySix;
    public MyStyleViewTwentySeven myStyleViewTwentySeven;
    public MyStyleViewTwentyEight myStyleViewTwentyEight;

    // dat add 5/9/2016
    private boolean isPurchase = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_style, container, false);
        frm_container = MainActivity.getFrm_container();
        init(view);
        return view;
    }

    public void init(View view) {
        styleOne = view.findViewById(R.id.style_one);
        styleTwo = view.findViewById(R.id.style_two);
        styleThree = view.findViewById(R.id.style_three);
        styleFour = view.findViewById(R.id.style_four);
        styleFive = view.findViewById(R.id.style_five);
        styleSix = view.findViewById(R.id.style_six);
        styleSeven = view.findViewById(R.id.style_seven);
        styleEight = view.findViewById(R.id.style_eight);
        styleNine = view.findViewById(R.id.style_nine);
        styleTen = view.findViewById(R.id.style_ten);
        styleEleven = view.findViewById(R.id.style_eleven);
        styleTwelve = view.findViewById(R.id.style_twelve);
        styleThirteen = view.findViewById(R.id.style_thirteen);
        styleFourteen = view.findViewById(R.id.style_fourteen);
        styleFifteen = view.findViewById(R.id.style_fifteen);
        styleSixteen = view.findViewById(R.id.style_sixteen);
        styleSeventeen = view.findViewById(R.id.style_seventeen);
        styleEighteen = view.findViewById(R.id.style_eighteen);
        styleNineteen = view.findViewById(R.id.style_nineteen);
        styleTwenty = view.findViewById(R.id.style_twenty);
        styleTwentyOne = view.findViewById(R.id.style_twenty_one);
        styleTwentyTwo = view.findViewById(R.id.style_twenty_two);
        styleTwentyThree = view.findViewById(R.id.style_twenty_three);
        styleTwentyFour = view.findViewById(R.id.style_twenty_four);
        styleTwentyFive = view.findViewById(R.id.style_twenty_five);
        styleTwentySix = view.findViewById(R.id.style_twenty_six);
        styleTwentySeven = view.findViewById(R.id.style_twenty_seven);
        styleTwentyEight = view.findViewById(R.id.style_twenty_eight);

        styleOne.setOnClickListener(this);
        styleTwo.setOnClickListener(this);
        styleThree.setOnClickListener(this);
        styleFour.setOnClickListener(this);
        styleFive.setOnClickListener(this);
        styleSix.setOnClickListener(this);
        styleSeven.setOnClickListener(this);
        styleEight.setOnClickListener(this);
        styleNine.setOnClickListener(this);
        styleTen.setOnClickListener(this);
        styleEleven.setOnClickListener(this);
        styleTwelve.setOnClickListener(this);
        styleThirteen.setOnClickListener(this);
        styleFourteen.setOnClickListener(this);
        styleFifteen.setOnClickListener(this);
        styleSixteen.setOnClickListener(this);
        styleSeventeen.setOnClickListener(this);
        styleEighteen.setOnClickListener(this);
        styleNineteen.setOnClickListener(this);
        styleTwenty.setOnClickListener(this);
        styleTwentyOne.setOnClickListener(this);
        styleTwentyTwo.setOnClickListener(this);
        styleTwentyThree.setOnClickListener(this);
        styleTwentyFour.setOnClickListener(this);
        styleTwentyFive.setOnClickListener(this);
        styleTwentySix.setOnClickListener(this);
        styleTwentySeven.setOnClickListener(this);
        styleTwentyEight.setOnClickListener(this);
        styleOne.setSelected(true);
        initContainerView(view);
        fl_styleOne.setBackgroundColor(Color.parseColor("#01bdc9"));
        myStyleViewOne = new MyStyleViewOne(MainActivity.getmContext());
        setStyleView(myStyleViewOne);

    }

    public void initContainerView(View view){
        fl_styleOne = (FrameLayout) view.findViewById(R.id.fl_style_one);
        fl_styleTwo = (FrameLayout) view.findViewById(R.id.fl_style_two);
        fl_styleThree = (FrameLayout) view.findViewById(R.id.fl_style_three);
        fl_styleFour = (FrameLayout)  view.findViewById(R.id.fl_style_four);
        fl_styleFive = (FrameLayout) view.findViewById(R.id.fl_style_five);
        fl_styleSix = (FrameLayout) view.findViewById(R.id.fl_style_six);
        fl_styleSeven = (FrameLayout) view.findViewById(R.id.fl_style_seven);
        fl_styleEight = (FrameLayout) view.findViewById(R.id.fl_style_eight);
        fl_styleNine = (FrameLayout) view.findViewById(R.id.fl_style_nine);
        fl_styleTen = (FrameLayout) view.findViewById(R.id.fl_style_ten);
        fl_styleEleven = (FrameLayout) view.findViewById(R.id.fl_style_eleven);
        fl_styleTwelve = (FrameLayout) view.findViewById(R.id.fl_style_twelve);
        fl_styleThirteen = (FrameLayout) view.findViewById(R.id.fl_style_thirteen);
        fl_styleFourteen = (FrameLayout) view.findViewById(R.id.fl_style_fourteen);
        fl_styleFifteen = (FrameLayout) view.findViewById(R.id.fl_style_fifteen);
        fl_styleSixteen = (FrameLayout) view.findViewById(R.id.fl_style_sixteen);
        fl_styleSeventeen = (FrameLayout) view.findViewById(R.id.fl_style_seventeen);
        fl_styleEighteen = (FrameLayout) view.findViewById(R.id.fl_style_eighteen);
        fl_styleNineteen = (FrameLayout) view.findViewById(R.id.fl_style_nineteen);
        fl_styleTwenty = (FrameLayout) view.findViewById(R.id.fl_style_twenty);
        fl_styleTwentyOne = (FrameLayout) view.findViewById(R.id.fl_style_twenty_one);
        fl_styleTwentyTwo = (FrameLayout) view.findViewById(R.id.fl_style_twenty_two);
        fl_styleTwentyThree = (FrameLayout) view.findViewById(R.id.fl_style_twenty_three);
        fl_styleTwentyFour = (FrameLayout) view.findViewById(R.id.fl_style_twenty_four);
        fl_styleTwentyFive = (FrameLayout) view.findViewById(R.id.fl_style_twenty_five);
        fl_styleTwentySix = (FrameLayout) view.findViewById(R.id.fl_style_twenty_six);
        fl_styleTwentySeven = (FrameLayout) view.findViewById(R.id.fl_style_twenty_seven);
        fl_styleTwentyEight = (FrameLayout) view.findViewById(R.id.fl_style_twenty_eight);

        if (!isPurchase){
            addLayoutPur(fl_styleTwentyTwo);
            addLayoutPur(fl_styleTwentyThree);
            addLayoutPur(fl_styleTwentyFour);
            addLayoutPur(fl_styleTwentyFive);
            addLayoutPur(fl_styleTwentySix);
            addLayoutPur(fl_styleTwentySeven);
            addLayoutPur(fl_styleTwentyEight);
        }else {
            removelayoutPur(fl_styleTwentyTwo);
            removelayoutPur(fl_styleTwentyThree);
            removelayoutPur(fl_styleTwentyFour);
            removelayoutPur(fl_styleTwentyFive);
            removelayoutPur(fl_styleTwentySix);
            removelayoutPur(fl_styleTwentySeven);
            removelayoutPur(fl_styleTwentyEight);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.style_one:
                refreshSelected();
                refreshContainerSelected();
                styleOne.setSelected(true);
                fl_styleOne.setBackgroundColor(Color.parseColor("#01bdc9"));
                myStyleViewOne = new MyStyleViewOne(MainActivity.getmContext());
                setStyleView(myStyleViewOne);

                break;
            case R.id.style_two:
                refreshSelected();
                refreshContainerSelected();
                styleTwo.setSelected(true);
                fl_styleTwo.setBackgroundColor(Color.parseColor("#01bdc9"));
                myStyleViewTwo = new MyStyleViewTwo(MainActivity.getmContext());
                setStyleView(myStyleViewTwo);

                break;
            case R.id.style_three:
                refreshSelected();
                refreshContainerSelected();
                styleThree.setSelected(true);
                fl_styleThree.setBackgroundColor(Color.parseColor("#01bdc9"));
                myStyleViewThree = new MyStyleViewThree(MainActivity.getmContext());
                setStyleView(myStyleViewThree);

                break;
            case R.id.style_four:
                refreshSelected();
                styleFour.setSelected(true);
                refreshContainerSelected();
                fl_styleFour.setBackgroundColor(Color.parseColor("#01bdc9"));
                myStyleViewFour = new MyStyleViewFour(MainActivity.getmContext());
                setStyleView(myStyleViewFour);

                break;
            case R.id.style_five:
                refreshSelected();
                styleFive.setSelected(true);
                refreshContainerSelected();
                fl_styleFive.setBackgroundColor(Color.parseColor("#01bdc9"));
                myStyleViewFive = new MyStyleViewFive(MainActivity.getmContext());
                setStyleView(myStyleViewFive);
                break;

            case R.id.style_six:
                refreshSelected();
                styleSix.setSelected(true);
                refreshContainerSelected();
                fl_styleSix.setBackgroundColor(Color.parseColor("#01bdc9"));
                myStyleViewSix = new MyStyleViewSix(MainActivity.getmContext());
                setStyleView(myStyleViewSix);
                break;

            case R.id.style_seven:
                refreshSelected();
                styleSeven.setSelected(true);
                refreshContainerSelected();
                fl_styleSeven.setBackgroundColor(Color.parseColor("#01bdc9"));
                myStyleViewSeven = new MyStyleViewSeven(MainActivity.getmContext());
                setStyleView(myStyleViewSeven);
                break;

            case R.id.style_eight:
                refreshSelected();
                styleEight.setSelected(true);
                refreshContainerSelected();
                fl_styleEight.setBackgroundColor(Color.parseColor("#01bdc9"));
                myStyleViewEight = new MyStyleViewEight(MainActivity.getmContext());
                setStyleView(myStyleViewEight);
                break;

            case R.id.style_nine:
                refreshSelected();
                styleNine.setSelected(true);
                refreshContainerSelected();
                fl_styleNine.setBackgroundColor(Color.parseColor("#01bdc9"));
                myStyleViewNine = new MyStyleViewNine(MainActivity.getmContext());
                setStyleView(myStyleViewNine);
                break;

            case R.id.style_ten:
                refreshSelected();
                styleTen.setSelected(true);
                refreshContainerSelected();
                fl_styleTen.setBackgroundColor(Color.parseColor("#01bdc9"));
                myStyleViewTen = new MyStyleViewTen(MainActivity.getmContext());
                setStyleView(myStyleViewTen);
                break;

            case R.id.style_eleven:
                refreshSelected();
                styleEleven.setSelected(true);
                refreshContainerSelected();
                fl_styleEleven.setBackgroundColor(Color.parseColor("#01bdc9"));
                myStyleViewEleven = new MyStyleViewEleven(MainActivity.getmContext());
                setStyleView(myStyleViewEleven);
                break;

            case R.id.style_twelve:
                refreshSelected();
                styleTwelve.setSelected(true);
                refreshContainerSelected();
                fl_styleTwelve.setBackgroundColor(Color.parseColor("#01bdc9"));
                myStyleViewTwelve = new MyStyleViewTwelve(MainActivity.getmContext());
                setStyleView(myStyleViewTwelve);
                break;

            case R.id.style_thirteen:
                refreshSelected();
                styleThirteen.setSelected(true);
                refreshContainerSelected();
                fl_styleThirteen.setBackgroundColor(Color.parseColor("#01bdc9"));
                myStyleViewThirteen = new MyStyleViewThirteen(MainActivity.getmContext());
                setStyleView(myStyleViewThirteen);
                break;
            case R.id.style_fourteen:
                refreshSelected();
                styleFourteen.setSelected(true);
                refreshContainerSelected();
                fl_styleFourteen.setBackgroundColor(Color.parseColor("#01bdc9"));
                myStyleViewFourteen = new MyStyleViewFourteen(MainActivity.getmContext());
                setStyleView(myStyleViewFourteen);
                break;

            case R.id.style_fifteen:
                refreshSelected();
                styleFifteen.setSelected(true);
                refreshContainerSelected();
                fl_styleFifteen.setBackgroundColor(Color.parseColor("#01bdc9"));
                myStyleViewFitteen = new MyStyleViewFitteen(MainActivity.getmContext());
                setStyleView(myStyleViewFitteen);
                break;
            case R.id.style_sixteen:
                refreshSelected();
                styleSixteen.setSelected(true);
                refreshContainerSelected();
                fl_styleSixteen.setBackgroundColor(Color.parseColor("#01bdc9"));
                myStyleViewSixteen = new MyStyleViewSixTeen(MainActivity.getmContext());
                setStyleView(myStyleViewSixteen);
                break;
            case R.id.style_seventeen:
                refreshSelected();
                styleSeventeen.setSelected(true);
                refreshContainerSelected();
                fl_styleSeventeen.setBackgroundColor(Color.parseColor("#01bdc9"));
                myStyleViewSeventeen = new MyStyleViewSevenTeen(MainActivity.getmContext());
                setStyleView(myStyleViewSeventeen);
                break;
            case R.id.style_eighteen:
                refreshSelected();
                styleEighteen.setSelected(true);
                refreshContainerSelected();
                fl_styleEighteen.setBackgroundColor(Color.parseColor("#01bdc9"));
                myStyleViewEightTeen = new MyStyleViewEightTeen(MainActivity.getmContext());
                setStyleView(myStyleViewEightTeen);
                break;
            case R.id.style_nineteen:
                refreshSelected();
                styleNineteen.setSelected(true);
                refreshContainerSelected();
                fl_styleNineteen.setBackgroundColor(Color.parseColor("#01bdc9"));
                myStyleViewNineTeen = new MyStyleViewNineTeen(MainActivity.getmContext());
                setStyleView(myStyleViewNineTeen);
                break;
            case R.id.style_twenty:
                refreshSelected();
                styleTwenty.setSelected(true);
                refreshContainerSelected();
                fl_styleTwenty.setBackgroundColor(Color.parseColor("#01bdc9"));
                myStyleViewTwenty = new MyStyleViewTwenty(MainActivity.getmContext());
                setStyleView(myStyleViewTwenty);
                break;
            case R.id.style_twenty_one:
                refreshSelected();
                styleTwentyOne.setSelected(true);
                refreshContainerSelected();
                fl_styleTwentyOne.setBackgroundColor(Color.parseColor("#01bdc9"));
                myStyleViewTwentyOne = new MyStyleViewTwentyOne(MainActivity.getmContext());
                setStyleView(myStyleViewTwentyOne);
                break;
            case R.id.style_twenty_two:
                if (isPurchase){
                    refreshSelected();
                    styleTwentyTwo.setSelected(true);
                    refreshContainerSelected();
                    fl_styleTwentyTwo.setBackgroundColor(Color.parseColor("#01bdc9"));
                    myStyleViewTwentyTwo = new MyStyleViewTwentyTwo(MainActivity.getmContext());
                    setStyleView(myStyleViewTwentyTwo);
                } else {
                    onShowPurchase();
                }

                break;
            case R.id.style_twenty_three:
                if (isPurchase){
                    refreshSelected();
                    styleTwentyThree.setSelected(true);
                    refreshContainerSelected();
                    fl_styleTwentyThree.setBackgroundColor(Color.parseColor("#01bdc9"));
                    myStyleViewTwentyThree = new MyStyleViewTwentyThree(MainActivity.getmContext());
                    setStyleView(myStyleViewTwentyThree);
                } else {
                    onShowPurchase();
                }

                break;
            case R.id.style_twenty_four:
                if (isPurchase){
                    refreshSelected();
                    styleTwentyFour.setSelected(true);
                    refreshContainerSelected();
                    fl_styleTwentyFour.setBackgroundColor(Color.parseColor("#01bdc9"));
                    myStyleViewTwentyFour = new MyStyleViewTwentyFour(MainActivity.getmContext());
                    setStyleView(myStyleViewTwentyFour);
                } else {
                    onShowPurchase();
                }

                break;
            case R.id.style_twenty_five:
                if (isPurchase){
                    refreshSelected();
                    styleTwentyFive.setSelected(true);
                    refreshContainerSelected();
                    fl_styleTwentyFive.setBackgroundColor(Color.parseColor("#01bdc9"));
                    myStyleViewTwentyFive = new MyStyleViewTwentyFive(MainActivity.getmContext());
                    setStyleView(myStyleViewTwentyFive);
                } else {
                    onShowPurchase();
                }
                break;
            case R.id.style_twenty_six:
                if (isPurchase){
                    refreshSelected();
                    styleTwentySix.setSelected(true);
                    refreshContainerSelected();
                    fl_styleTwentySix.setBackgroundColor(Color.parseColor("#01bdc9"));
                    myStyleViewTwentySix = new MyStyleViewTwentySix(MainActivity.getmContext());
                    setStyleView(myStyleViewTwentySix);
                } else {
                    onShowPurchase();
                }

                break;
            case R.id.style_twenty_seven:
                if (isPurchase){
                    refreshSelected();
                    styleTwentySeven.setSelected(true);
                    refreshContainerSelected();
                    fl_styleTwentySeven.setBackgroundColor(Color.parseColor("#01bdc9"));
                    myStyleViewTwentySeven = new MyStyleViewTwentySeven(MainActivity.getmContext());
                    setStyleView(myStyleViewTwentySeven);
                } else {
                    onShowPurchase();
                }
                break;
            case R.id.style_twenty_eight:
                if (isPurchase){
                    refreshSelected();
                    styleTwentyEight.setSelected(true);
                    refreshContainerSelected();
                    fl_styleTwentyEight.setBackgroundColor(Color.parseColor("#01bdc9"));
                    myStyleViewTwentyEight = new MyStyleViewTwentyEight(MainActivity.getmContext());
                    setStyleView(myStyleViewTwentyEight);
                } else {
                    onShowPurchase();
                }
                break;
        }
    }

    public void setStyleView(FrameLayout frameLayout) {
        if (frm_container != null) {
            frm_container.removeAllViews();

        }
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
        frameLayout.setLayoutParams(params);
        frm_container.addView(frameLayout);
        BaseAnimation.with(Techniques.Landing).duration(800).playOn(frm_container);
        frm_container.setVisibility(View.VISIBLE);
        MainActivity.getVi_baseview_delete().setVisibility(View.VISIBLE);
    }

    public void refreshSelected(){
        styleOne.setSelected(false);
        styleTwo.setSelected(false);
        styleThree.setSelected(false);
        styleFour.setSelected(false);
        styleFive.setSelected(false);
        styleSix.setSelected(false);
        styleSeven.setSelected(false);
        styleEight.setSelected(false);
        styleNine.setSelected(false);
        styleTen.setSelected(false);
        styleEleven.setSelected(false);
        styleTwelve.setSelected(false);
        styleThirteen.setSelected(false);
        styleFourteen.setSelected(false);
        styleFifteen.setSelected(false);
        styleSixteen.setSelected(false);
        styleSeventeen.setSelected(false);
        styleEighteen.setSelected(false);
        styleNineteen.setSelected(false);
        styleTwenty.setSelected(false);
        styleTwentyOne.setSelected(false);
        styleTwentyTwo.setSelected(false);
        styleTwentyThree.setSelected(false);
        styleTwentyFour.setSelected(false);
        styleTwentyFive.setSelected(false);
        styleTwentySix.setSelected(false);
        styleTwentySeven.setSelected(false);
        styleTwentyEight.setSelected(false);
    }

    public void refreshContainerSelected(){

        fl_styleOne.setBackgroundColor(Color.parseColor("#212a33"));
        fl_styleTwo.setBackgroundColor(Color.parseColor("#212a33"));
        fl_styleThree.setBackgroundColor(Color.parseColor("#212a33"));
        fl_styleFour.setBackgroundColor(Color.parseColor("#212a33"));
        fl_styleFive.setBackgroundColor(Color.parseColor("#212a33"));
        fl_styleSix.setBackgroundColor(Color.parseColor("#212a33"));
        fl_styleSeven.setBackgroundColor(Color.parseColor("#212a33"));
        fl_styleEight.setBackgroundColor(Color.parseColor("#212a33"));
        fl_styleNine.setBackgroundColor(Color.parseColor("#212a33"));
        fl_styleTen.setBackgroundColor(Color.parseColor("#212a33"));
        fl_styleEleven.setBackgroundColor(Color.parseColor("#212a33"));
        fl_styleTwelve.setBackgroundColor(Color.parseColor("#212a33"));
        fl_styleThirteen.setBackgroundColor(Color.parseColor("#212a33"));
        fl_styleFourteen.setBackgroundColor(Color.parseColor("#212a33"));
        fl_styleFifteen.setBackgroundColor(Color.parseColor("#212a33"));
        fl_styleSixteen.setBackgroundColor(Color.parseColor("#212a33"));
        fl_styleSeventeen.setBackgroundColor(Color.parseColor("#212a33"));
        fl_styleEighteen.setBackgroundColor(Color.parseColor("#212a33"));
        fl_styleNineteen.setBackgroundColor(Color.parseColor("#212a33"));
        fl_styleTwenty.setBackgroundColor(Color.parseColor("#212a33"));
        fl_styleTwentyOne.setBackgroundColor(Color.parseColor("#212a33"));
        fl_styleTwentyTwo.setBackgroundColor(Color.parseColor("#212a33"));
        fl_styleTwentyThree.setBackgroundColor(Color.parseColor("#212a33"));
        fl_styleTwentyFour.setBackgroundColor(Color.parseColor("#212a33"));
        fl_styleTwentyFive.setBackgroundColor(Color.parseColor("#212a33"));
        fl_styleTwentySix.setBackgroundColor(Color.parseColor("#212a33"));
        fl_styleTwentySeven.setBackgroundColor(Color.parseColor("#212a33"));
        fl_styleTwentyEight.setBackgroundColor(Color.parseColor("#212a33"));
    }

    public void onShowPurchase(){
        PurchaseFragment purchaseFragment = new PurchaseFragment().newInstance("pur");
        purchaseFragment.show(getFragmentManager(), "dialofg");
    }


    public void addLayoutPur(FrameLayout viewBase){
        LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_lock_purchase, null);
        view.setTag("ddt");
        viewBase.addView(view);
    }

    public void removelayoutPur(FrameLayout viewBase){
        if (viewBase.findViewWithTag("ddt") != null){
            viewBase.removeView(viewBase.findViewWithTag("ddt"));
        }
    }

}
