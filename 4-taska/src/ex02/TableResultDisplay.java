package ex02;

/**
 * Відображає результати у вигляді таблиці з фіксованою шириною стовпців (20 символів).
 */
public class TableResultDisplay implements ResultDisplay {
    private static final int[] COLUMN_WIDTHS = {20, 20, 20, 20};

    @Override
    public void display(ResultData data) {
        String[] columns = {
            String.valueOf(data.getDecimalNumber()),
            data.getBinaryRepresentation(),
            String.valueOf(data.getTransitionsCount()),
            (data instanceof ExtendedResultData) ? ((ExtendedResultData) data).getHexRepresentation() : "N/A"
        };

        StringBuilder format = new StringBuilder();
        for (int width : COLUMN_WIDTHS) {
            format.append("| %-").append(width).append("s ");
        }
        format.append("|%n");

        // Заголовки
        System.out.printf(format.toString(), "Decimal", "Binary", "Transitions", "Hex");
        // Роздільник
        System.out.println("-".repeat(COLUMN_WIDTHS.length * 23)); 
        // Дані
        System.out.printf(format.toString(), (Object[]) columns);
    }
}