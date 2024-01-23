import java.util.ArrayList;

public class L00_convert_grid_to_arraylist {
    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };

        ArrayList<ArrayList<Integer>> result = convertToArrayList(grid);

        // Print the result
        for (ArrayList<Integer> row : result) {
            System.out.println(row);
        }
    }

    private static ArrayList<ArrayList<Integer>> convertToArrayList(char[][] grid) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (char[] row : grid) {
            ArrayList<Integer> convertedRow = new ArrayList<>();
            for (char c : row) {
                convertedRow.add(c - '0'); // Convert char to integer
            }
            result.add(convertedRow);
        }

        return result;
    }
}
