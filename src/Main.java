import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
	// public static void main(String[] args) {
	// // System.out.println("Hello World!");
	// // ��ʼ��ʱ
	// long start = System.currentTimeMillis();
	//
	// // ��������
	// int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	//
	// // �Ľ�����
	// int[] array = new int[9];
	//
	// // �ı�����
	// int[] upArray = new int[9];
	// int[] downArray = new int[9];
	// int[] leftArray = new int[9];
	// int[] rightArray = new int[9];
	// // ��������
	// int[][] sudoku = new int[9][9];
	//
	// // ��һ���������ȶ���õ��������������������ĵ�3*3������
	// for (int i = 3, k = 0; i < 6; i++) {
	// for (int j = 3; j < 6; j++) {
	// sudoku[i][j] = arr[k];
	// k++;
	// }
	// }
	//
	// // �ڶ�����������3*3���ӣ���д��������3*3����(������3*3���ӵ�ֵ�������û�)
	//
	// // 1���������û�
	// for (int i = 0; i < upArray.length; i++) {
	// if (i % 3 == 0) {
	// upArray[i] = arr[i + 2];
	// } else {
	// upArray[i] = arr[i - 1];
	// }
	//
	// }
	// // ���������3*3�ĸ�����
	// for (int i = 0, k = 0; i < 3; i++) {
	// for (int j = 3; j < 6; j++) {
	// sudoku[i][j] = upArray[k];
	// k++;
	// }
	//
	// }
	// // 2���������û�
	// for (int i = 0; i < downArray.length; i++) {
	// if ((i + 1) % 3 == 0) {
	// downArray[i] = arr[i - 2];
	// } else {
	// downArray[i] = arr[i + 1];
	// }
	//
	// }
	// // ���������3*3�ĸ�����
	// for (int i = 6, k = 0; i < 9; i++) {
	// for (int j = 3; j < 6; j++) {
	// sudoku[i][j] = downArray[k];
	// k++;
	// }
	//
	// }
	//
	// // ��������������3*3���ӣ���д��������3*3����(������3*3���ӵ�ֵ�������û�)
	//
	// // 1���������û�
	// for (int i = 0; i < leftArray.length; i++) {
	// if (i < 3) {
	// leftArray[i] = arr[i + 6];
	// } else {
	// leftArray[i] = arr[i - 3];
	// }
	//
	// }
	// // ���������3*3�ĸ�����
	// for (int i = 3, k = 0; i < 6; i++) {
	// for (int j = 0; j < 3; j++) {
	// sudoku[i][j] = leftArray[k];
	// k++;
	// }
	//
	// }
	//
	// // 2���������û�
	// for (int i = 0; i < rightArray.length; i++) {
	// if (i < 6) {
	// rightArray[i] = arr[i + 3];
	// } else {
	// rightArray[i] = arr[i - 6];
	// }
	//
	// }
	// // ���������3*3�ĸ�����
	// for (int i = 3, k = 0; i < 6; i++) {
	// for (int j = 6; j < 9; j++) {
	// sudoku[i][j] = rightArray[k];
	// k++;
	// }
	// }
	//
	// // ���Ĳ����������»����ҵ�3*3���ӵ�������д�Ľǵ�3*3���ӣ���������Ĵ���
	// // ���磬��ʹ�������������飬ͨ�����û�����д�Ľǵĸ���
	//
	// // ���3*3������д���Ϻ�����3*3����
	//
	// // �������û�
	// for (int i = 0; i < array.length; i++) {
	// if (i % 3 == 0) {
	// array[i] = leftArray[i + 2];
	// } else {
	// array[i] = leftArray[i - 1];
	// }
	//
	// }
	// // �����������3*3�ĸ�����
	// for (int i = 6, k = 0; i < 9; i++) {
	// for (int j = 0; j < 3; j++) {
	// sudoku[i][j] = array[k];
	// k++;
	// }
	//
	// }
	//
	// // �������û�
	// for (int i = 0; i < array.length; i++) {
	// if ((i + 1) % 3 == 0) {
	// array[i] = leftArray[i - 2];
	// } else {
	// array[i] = leftArray[i + 1];
	// }
	//
	// }
	// // �����������3*3�ĸ�����
	// for (int i = 0, k = 0; i < 3; i++) {
	// for (int j = 0; j < 3; j++) {
	// sudoku[i][j] = array[k];
	// k++;
	// }
	//
	// }
	//
	// // ʹ���ұ�3*3������д���Ϻ�����3*3����
	//
	// // �������û�
	// for (int i = 0; i < array.length; i++) {
	// if (i % 3 == 0) {
	// array[i] = rightArray[i + 2];
	// } else {
	// array[i] = rightArray[i - 1];
	// }
	//
	// }
	// // �����������3*3�ĸ�����
	// for (int i = 6, k = 0; i < 9; i++) {
	// for (int j = 6; j < 9; j++) {
	// sudoku[i][j] = array[k];
	// k++;
	// }
	//
	// }
	//
	// // �������û�
	// for (int i = 0; i < array.length; i++) {
	// if ((i + 1) % 3 == 0) {
	// array[i] = rightArray[i - 2];
	// } else {
	// array[i] = rightArray[i + 1];
	// }
	//
	// }
	// // �����������3*3�ĸ�����
	// for (int i = 0, k = 0; i < 3; i++) {
	// for (int j = 6; j < 9; j++) {
	// sudoku[i][j] = array[k];
	// k++;
	// }
	//
	// }
	//
	// // �����������
	// for (int[] is : sudoku) {
	// for (int i : is) {
	// System.out.print(i + " ");
	// }
	// System.out.println();
	// }
	//
	// // ������ʱ
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
//			// �����������ʱ��
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
		
		
		
//		// �������
//		for (int[] is : array) {
//			for (int i : is) {
//				System.out.print(i + " ");
//			}
//			System.out.println();
//		}

		// ���Դ������Ƿ��н�
		// �ҵ����пո�����к�ѡ��������ÿ�С�ÿ�к������ڵ�3*3�����������ĸ��ӵ�ֵ���õ���ѡ�����������ѡ��ֻ��һ�������ҵ��˵�ǰ�ո�Ľ⡣
		// ��������пո�ĺ�ѡ��������һ��������Ҫ�ݹ������⣬�۲��Ƿ���ڶ�⡣
		
//		SudokuSolution sudokuSolution = new SudokuSolution(array);
//		if (!sudokuSolution.findAnswer()) {
//			ArrayList<Hole> holes = new ArrayList<>();
//			holes = sudokuSolution.getHoles();
//			// ����޷�ֱ������Ŀո������ͺ�ѡ��
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
//		// �������
//		for (int[] is : array) {
//			for (int i : is) {
//				System.out.print(i + " ");
//			}
//			System.out.println();
//		}

		

	}

}
