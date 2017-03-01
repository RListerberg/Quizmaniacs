package se.quizmaniacs.Jdo;

import java.util.List;

/**
 * Created by robin on 2017-03-01.
 */

public class SimpleCategory {

    private int pieSize;
    private List<String> categories;

    public SimpleCategory(List<String> categories, int pieSize) {
        this.categories = categories;
        this.pieSize = pieSize;
    }

    public int getPieSize() {
        return pieSize;
    }

    public void setPieSize(int pieSize) {
        this.pieSize = pieSize;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
