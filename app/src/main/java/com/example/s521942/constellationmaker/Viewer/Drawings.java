package com.example.s521942.constellationmaker.Viewer;

import com.example.s521942.constellationmaker.Drawing.DrawView;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class Drawings {

    /**
     * An array of sample (dummy) items.
     *
     */
    //public static DrawView.Point
    public static List<DrawItem> SELECTED_ITEMS = new ArrayList<DrawItem>();
    public static List<DrawItem> ITEMS = new ArrayList<DrawItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
   // public static Map<String, DrawItem> ITEM_MAP = new HashMap<String, DrawItem>();

    static {
        // Add 3 sample items.
        //addItem(new DrawItem("1", null));
//        addItem(new DrawItem("2", null));
//        addItem(new DrawItem("3", null));
    }

    public static void addItem(DrawItem item) {
        ITEMS.add(item);
        //ITEM_MAP.put(item.id, item);
    }
    public static void addselectedItem(DrawItem item){
        SELECTED_ITEMS.add(item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DrawItem {
        public String nameOfDrawing;
        public List<DrawView.Point> pointsOfDrawing=new ArrayList<DrawView.Point>();

        public DrawItem(String nameOfDrawing, List<DrawView.Point> pointsOfDrawing) {
            this.nameOfDrawing = nameOfDrawing;
            this.pointsOfDrawing = pointsOfDrawing;
        }

        @Override
        public String toString() {
            return nameOfDrawing;
        }

        public List<DrawView.Point> getPointsOfDrawing() {
            return pointsOfDrawing;
        }
    }
}
