import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
	// public static void main(String[] args) {
	// // System.out.println("Hello World!");
	// // 开始记时
	// long start = System.currentTimeMillis();
	//
	// // 种子数组
	// int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	//
	// // 四角数组
	// int[] array = new int[9];
	//
	// // 四边数组
	// int[] upArray = new int[9];
	// int[] downArray = new int[9];
	// int[] leftArray = new int[9];
	// int[] rightArray = new int[9];
	// // 数独数组
	// int[][] sudoku = new int[9][9];
	//
	// // 第一步，将事先定义好的数组放入数独数组的中心的3*3格子中
	// for (int i = 3, k = 0; i < 6; i++) {
	// for (int j = 3; j < 6; j++) {
	// sudoku[i][j] = arr[k];
	// k++;
	// }
	// }
	//
	// // 第二步根据中心3*3格子，填写上下两个3*3格子(将中心3*3格子的值进行列置换)
	//
	// // 1、向右列置换
	// for (int i = 0; i < upArray.length; i++) {
	// if (i % 3 == 0) {
	// upArray[i] = arr[i + 2];
	// } else {
	// upArray[i] = arr[i - 1];
	// }
	//
	// }
	// // 放入上面的3*3的格子中
	// for (int i = 0, k = 0; i < 3; i++) {
	// for (int j = 3; j < 6; j++) {
	// sudoku[i][j] = upArray[k];
	// k++;
	// }
	//
	// }
	// // 2、向左列置换
	// for (int i = 0; i < downArray.length; i++) {
	// if ((i + 1) % 3 == 0) {
	// downArray[i] = arr[i - 2];
	// } else {
	// downArray[i] = arr[i + 1];
	// }
	//
	// }
	// // 放入下面的3*3的格子中
	// for (int i = 6, k = 0; i < 9; i++) {
	// for (int j = 3; j < 6; j++) {
	// sudoku[i][j] = downArray[k];
	// k++;
	// }
	//
	// }
	//
	// // 第三步根据中心3*3格子，填写左右两个3*3格子(将中心3*3格子的值进行行置换)
	//
	// // 1、向上行置换
	// for (int i = 0; i < leftArray.length; i++) {
	// if (i < 3) {
	// leftArray[i] = arr[i + 6];
	// } else {
	// leftArray[i] = arr[i - 3];
	// }
	//
	// }
	// // 放入左面的3*3的格子中
	// for (int i = 3, k = 0; i < 6; i++) {
	// for (int j = 0; j < 3; j++) {
	// sudoku[i][j] = leftArray[k];
	// k++;
	// }
	//
	// }
	//
	// // 2、向下行置换
	// for (int i = 0; i < rightArray.length; i++) {
	// if (i < 6) {
	// rightArray[i] = arr[i + 3];
	// } else {
	// rightArray[i] = arr[i - 6];
	// }
	//
	// }
	// // 放入右面的3*3的格子中
	// for (int i = 3, k = 0; i < 6; i++) {
	// for (int j = 6; j < 9; j++) {
	// sudoku[i][j] = rightArray[k];
	// k++;
	// }
	// }
	//
	// // 第四步，根据上下或左右的3*3格子的数字填写四角的3*3格子，完成数独的创建
	// // 例如，我使用左右两个数组，通过列置换，填写四角的格子
	//
	// // 左边3*3格子填写左上和左下3*3格子
	//
	// // 向右列置换
	// for (int i = 0; i < array.length; i++) {
	// if (i % 3 == 0) {
	// array[i] = leftArray[i + 2];
	// } else {
	// array[i] = leftArray[i - 1];
	// }
	//
	// }
	// // 放入左下面的3*3的格子中
	// for (int i = 6, k = 0; i < 9; i++) {
	// for (int j = 0; j < 3; j++) {
	// sudoku[i][j] = array[k];
	// k++;
	// }
	//
	// }
	//
	// // 向左列置换
	// for (int i = 0; i < array.length; i++) {
	// if ((i + 1) % 3 == 0) {
	// array[i] = leftArray[i - 2];
	// } else {
	// array[i] = leftArray[i + 1];
	// }
	//
	// }
	// // 放入左上面的3*3的格子中
	// for (int i = 0, k = 0; i < 3; i++) {
	// for (int j = 0; j < 3; j++) {
	// sudoku[i][j] = array[k];
	// k++;
	// }
	//
	// }
	//
	// // 使用右边3*3格子填写右上和右下3*3格子
	//
	// // 向右列置换
	// for (int i = 0; i < array.length; i++) {
	// if (i % 3 == 0) {
	// array[i] = rightArray[i + 2];
	// } else {
	// array[i] = rightArray[i - 1];
	// }
	//
	// }
	// // 放入右下面的3*3的格子中
	// for (int i = 6, k = 0; i < 9; i++) {
	// for (int j = 6; j < 9; j++) {
	// sudoku[i][j] = array[k];
	// k++;
	// }
	//
	// }
	//
	// // 向左列置换
	// for (int i = 0; i < array.length; i++) {
	// if ((i + 1) % 3 == 0) {
	// array[i] = rightArray[i - 2];
	// } else {
	// array[i] = rightArray[i + 1];
	// }
	//
	// }
	// // 放入右上面的3*3的格子中
	// for (int i = 0, k = 0; i < 3; i++) {
	// for (int j = 6; j < 9; j++) {
	// sudoku[i][j] = array[k];
	// k++;
	// }
	//
	// }
	//
	// // 输出数独数组
	// for (int[] is : sudoku) {
	// for (int i : is) {
	// System.out.print(i + " ");
	// }
	// System.out.println();
	// }
	//
	// // 结束记时
	// long end = System.currentTimeMillis();
	// System.out.println((end - start));
	//
	//
	// // for (int i = 0; i < arr.length; i++) {
	// //
	// // if (0 == i % 3) {
	// // System.out.println();
	// // }
	// // System.out.print(arr[i]);
	// //
	// // }
	//
	// }
	//
	public static void main(String[] args) {
		
//		int n = 10;
//		int avgNum = 0;
//		long avgTime = 0;
//		for (int i = 0; i < n ; i++) {
//			long start = System.currentTimeMillis();
//			int num = 0;
//			for (int i1 = 0; i1 < 10000; i1++) {
//				SudokuSolution sudokuSolution = new SudokuSolution(new SudokuFactory().produceGameSudoku());
//				if (sudokuSolution.findAnswer()) {
//					num ++;
//				}	
//			}
//			avgNum += num;
//			
//			long end = System.currentTimeMillis();
//			// 输出程序运行时间
//			avgTime += end - start;
//		}
//		
//		System.out.println(avgNum / 10);
//		System.out.println(avgTime / 10);
		
		
		SudokuFactory sudokuFactory = new SudokuFactory();
		
		int[][] array = sudokuFactory.produceGameSudoku();
		
		for (int[] is : array) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		SudokuSolution sudokuSolution = new SudokuSolution(array);
		
		boolean  flag = sudokuSolution.findAnswer();
		
		if (flag) {
			for (int[] is : array) {
				for (int i : is) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
		} else {
			System.out.println("many answer!!");
		}
		
		
		
//		// 输出数独
//		for (int[] is : array) {
//			for (int i : is) {
//				System.out.print(i + " ");
//			}
//			System.out.println();
//		}

		// 测试此数独是否有解
		// 找到所有空格的所有候选数（根据每行、每列和其所在的3*3格子中其它的格子的值，得到候选数），如果候选数只有一个，就找到了当前空格的解。
		// 如果，所有空格的候选数都不是一个，则需要递归测试求解，观察是否存在多解。
		
//		SudokuSolution sudokuSolution = new SudokuSolution(array);
//		if (!sudokuSolution.findAnswer()) {
//			ArrayList<Hole> holes = new ArrayList<>();
//			holes = sudokuSolution.getHoles();
//			// 输出无法直接填入的空格的坐标和候选数
//			System.out.println(sudokuSolution.holeLength());
//			for (Hole hole : holes) {
//				if (hole.isWrite()) {
//					continue;
//				}
//				System.out.print(hole.getX() + "," + hole.getY() + ": ");
//				for (int i : hole.getwNum()) {
//					if (i == 0) {
//						continue;
//					}
//					System.out.print(i + " ");
//				}
//				System.out.println();
//			}
//		}
		
				
//		System.out.println();
//		// 输出数独
//		for (int[] is : array) {
//			for (int i : is) {
//				System.out.print(i + " ");
//			}
//			System.out.println();
//		}

		

	}

}
