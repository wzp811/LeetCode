package QuestOfTheDay;

public class No780_ReachingPoints {
    public boolean reachingPointsError(int sx, int sy, int tx, int ty) {
        if (sx > tx || sy > ty) return false;
        if (sx == tx && sy == ty) return true;
        return reachingPointsError(sx + sy, sy, tx, ty) || reachingPointsError(sx, sx + sy, tx, ty);
    }

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) return true;
        if (tx < sx || ty < sy) return false;
        if (tx == ty) return sx == 0 && sy == tx || sx == tx && sy == 0;
        int nx = tx > ty ? tx - Math.max((tx - sx) / ty, 1) * ty : tx;
        int ny = ty > tx ? ty - Math.max((ty - sy) / tx, 1) * tx : ty;
        return reachingPoints(sx, sy, nx, ny);
    }
}
