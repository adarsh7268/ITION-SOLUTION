import java.util.ArrayList;
import java.util.List;
public class OrchardSizes {
 public static void main(String[] args) {
 char[][] matrix = {
 {'O','T','O','O'},
 {'O','T','O','T'},
 {'T','T','O','T'},
 {'O','T','O','T'}
 };
 List<Integer> orchardSizes = computeOrchardSizes(matrix);
 System.out.println("Orchard sizes: " + orchardSizes);
 }
 public static List<Integer> computeOrchardSizes(char[][] matrix) {
 List<Integer> orchardSizes = new ArrayList<>();
 int rows = matrix.length;
 int cols = matrix[0].length;
 boolean[][] visited = new boolean[rows][cols];
 for (int i = 0; i < rows; i++) {
 for (int j = 0; j < cols; j++) {
 if (matrix[i][j] == 'T' && !visited[i][j]) {
 int orchardSize = findOrchardSize(matrix, visited, i, j);
 orchardSizes.add(orchardSize);
 }
 }
 }
 return orchardSizes;
 }
 private static int findOrchardSize(char[][] matrix, boolean[][] visited, int row, int col) {
 int size = 0;
 int rows = matrix.length;
 int cols = matrix[0].length;
 if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || matrix[row][col] != 'T') {
 return size;
 }
 visited[row][col] = true;
 size++;
 size += findOrchardSize(matrix, visited, row - 1, col); // Check up
 size += findOrchardSize(matrix, visited, row + 1, col); // Check down
 size += findOrchardSize(matrix, visited, row, col - 1); // Check left
 size += findOrchardSize(matrix, visited, row, col + 1); // Check right
 size += findOrchardSize(matrix, visited, row - 1, col - 1); // Check diagonally up-left
 size += findOrchardSize(matrix, visited, row - 1, col + 1); // Check diagonally up-right
 size += findOrchardSize(matrix, visited, row + 1, col - 1); // Check diagonally down-left
 size += findOrchardSize(matrix, visited, row + 1, col + 1); // Check diagonally down-right
 return size;
 } }