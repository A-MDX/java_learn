package com.test.chinaChess;

import java.awt.*;
import java.io.Serializable;

/**
 * 走步类
 * Created by A-mdx on 2016/10/21.
 */
public class MoveStep implements Serializable {
    public Point pStart, pEnd;

    public MoveStep(Point p1, Point p2) {
        pStart = p1;
        pEnd = p2;
    }
}
