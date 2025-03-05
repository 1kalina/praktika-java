package ex02;

import java.util.List;

public class TextResultFormatter implements ResultFormatter {
    @Override
    public String format(ResultData data) {
        return String.format("Decimal: %d | Binary: %s | Transitions: %d",
                data.getDecimalNumber(),
                data.getBinaryRepresentation(),
                data.getTransitionsCount());
    }

    @Override
    public String formatAll(List<ResultData> dataList) {
        StringBuilder sb = new StringBuilder();
        for (ResultData data : dataList) {
            sb.append(format(data)).append("\n");
        }
        return sb.toString();
    }

    public String formatAll(Object dataList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
