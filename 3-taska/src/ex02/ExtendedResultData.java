package ex02;

public class ExtendedResultData extends ResultData {
    public ExtendedResultData(int decimalNumber) {
        super(decimalNumber);
    }

    public String getHexRepresentation() {
        return Integer.toHexString(decimalNumber);
    }

    @Override
    public String toString() {
        return super.toString() + ", Hex: " + getHexRepresentation();
    }
}