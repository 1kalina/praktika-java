package ex03;

public interface ResultDisplay {
    void display(ResultData data);

    // Реалізації відображення
    class TextResultDisplay implements ResultDisplay {
        @Override
        public void display(ResultData data) {
            System.out.println(data + "\n");
        }
    }

    class TableResultDisplay implements ResultDisplay {
        private static final int[] COLUMN_WIDTHS = {20, 20, 20, 20};

        @Override
        public void display(ResultData data) {
            String[] columns = {
                String.valueOf(data.getDecimalNumber()),
                data.getBinaryRepresentation(),
                String.valueOf(data.getTransitionsCount()),
                (data instanceof ResultData.ExtendedResultData) 
                    ? ((ResultData.ExtendedResultData) data).getHexRepresentation() 
                    : "N/A"
            };

            StringBuilder format = new StringBuilder();
            for (int width : COLUMN_WIDTHS) {
                format.append("| %-").append(width).append("s ");
            }
            format.append("|%n");

            System.out.printf(format.toString(), "Decimal", "Binary", "Transitions", "Hex");
            System.out.println("-".repeat(COLUMN_WIDTHS.length * 23));
            System.out.printf(format.toString(), (Object[]) columns);
        }
    }
}
