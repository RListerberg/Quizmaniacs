package se.quizmaniacs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robin on 2017-03-21.
 */

public class RectangleView extends View {

    private Rect categoryRect;
    private final int nrOfCategories = 5;
    private ArrayList<Rect> categoryRectList;
    private List<Integer> colorIntList;
    private Paint curPaint;

    public RectangleView(Context context) {
        super(context);
        curPaint = new Paint();
        categoryRectList = new ArrayList<>();
        colorIntList = new ArrayList<>();

        categoryRect = new Rect();

        for (int i = 0; i < nrOfCategories; i++) {
            categoryRectList.add(i, categoryRect);
        }

        for (int index = 0; index < ColorTemplateBasic.VORDIPLOM_COLORS.length; index++) {
            colorIntList.add(ColorTemplateBasic.VORDIPLOM_COLORS[index]);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    public ArrayList<Rect> getCategoryRectList() {
        return categoryRectList;
    }

    public void setCategoryRectList(ArrayList<Rect> categoryRectList) {
        this.categoryRectList = categoryRectList;
    }

    public List<Integer> getColorIntList() {
        return colorIntList;
    }

    public void setColorIntList(List<Integer> colorIntList) {
        this.colorIntList = colorIntList;
    }

    public Paint getCurPaint() {
        return curPaint;
    }
}
