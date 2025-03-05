package ex02;

import java.util.List;

public interface ResultFormatter {
    String format(ResultData data);
    String formatAll(List<ResultData> dataList);
}
