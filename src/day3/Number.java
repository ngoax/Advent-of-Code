package day3;

public class Number {
    protected int n;
    protected int startIdx;
    protected int endIdx;
    protected int lineNum;

    public Number(int n, int startIdx, int endIdx, int lineNum) {
        this.n = n;
        this.startIdx = startIdx;
        this.endIdx = endIdx;
        this.lineNum = lineNum;
    }

    public int getN() {
        return n;
    }

    public int getStartIdx() {
        return startIdx;
    }

    public int getEndIdx() {
        return endIdx;
    }

    public int getLineNum() {
        return lineNum;
    }


}
