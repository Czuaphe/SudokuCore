
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

/**
 * ����������
 * 
 * @author Czuaphe
 *
 */
public class SudokuFactory {

	private Random random = new Random();
	// ����block
	private int[] centerBlock = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	// �ı�block
	private int[] topBlock = new int[9];
	private int[] bottomBlock = new int[9];
	private int[] leftBlock = new int[9];
	private int[] rightBlock = new int[9];
	// �Ľ�block
	private int[] topleftBlock = new int[9];
	private int[] toprightBlock = new int[9];
	private int[] bottomleftBlock = new int[9];
	private int[] bottomrightBlock = new int[9];
	// ��������
	private int[][] sudokuArray = new int[9][9];

	private int holeNum = 30;

	// ����һ�������������
	public int[][] produceFinalSudoku() {

		// ���ѡ��һ����������
		selectCenterBlock();

		// ������������� ������û� �����������
		if (random.nextInt(2) == 0) {
			rowPermToTop(leftBlock, centerBlock);
			rowPermToBottom(rightBlock, centerBlock);
		} else {
			rowPermToTop(rightBlock, centerBlock);
			rowPermToBottom(leftBlock, centerBlock);
		}

		// ������������� ������û� �����������
		if (random.nextInt(2) == 0) {
			columnPermToLeft(topBlock, centerBlock);
			columnPermToRight(bottomBlock, centerBlock);
		} else {
			columnPermToLeft(bottomBlock, centerBlock);
			columnPermToRight(topBlock, centerBlock);
		}

		// ѡ�����һ��������飬����Ľ�����
		// Ϊ0ʹ���������飬Ϊ1ʹ����������
		if (random.nextInt(2) == 0) {

			// ����������� ������û� ������Ϻ���������
			if (random.nextInt(2) == 0) {
				columnPermToLeft(topleftBlock, leftBlock);
				columnPermToRight(bottomleftBlock, leftBlock);
			} else {
				columnPermToLeft(bottomleftBlock, leftBlock);
				columnPermToRight(topleftBlock, leftBlock);
			}
			// ����������� ������û� ������Ϻ���������
			if (random.nextInt(2) == 0) {
				columnPermToLeft(toprightBlock, rightBlock);
				columnPermToRight(bottomrightBlock, rightBlock);
			} else {
				columnPermToLeft(bottomrightBlock, rightBlock);
				columnPermToRight(toprightBlock, rightBlock);
			}

		} else {

			// �����������������û�������Ϻ���������
			if (random.nextInt(2) == 0) {
				rowPermToTop(topleftBlock, topBlock);
				rowPermToBottom(toprightBlock, topBlock);
			} else {
				rowPermToTop(toprightBlock, topBlock);
				rowPermToBottom(topleftBlock, topBlock);
			}
			// �����������������û�������º���������
			if (random.nextInt(2) == 0) {
				rowPermToTop(bottomleftBlock, bottomBlock);
				rowPermToBottom(bottomrightBlock, bottomBlock);
			} else {
				rowPermToTop(bottomrightBlock, bottomBlock);
				rowPermToBottom(bottomleftBlock, bottomBlock);
			}

		}

		// ����������飬��ɹ���
		fillSudoku();

		return sudokuArray;

	}

	// ����һ������ո�����
	public int[][] produceGameSudoku() {

		produceFinalSudoku();
	
		for (int i = 0; i < holeNum;) {
			int x = random.nextInt(9);
			int y = random.nextInt(9);
			if (sudokuArray[x][y] != 0) {
				sudokuArray[x][y] = 0;
				i++;
			}
		}

		return sudokuArray;

	}

	// ������������
	public int[][] getSudokuArray() {
		return sudokuArray;
	}

	// �������û�
	private void rowPermToTop(int[] des, int[] src) {
		for (int i = 0; i < des.length; i++) {
			if (i < 3) {
				des[i] = src[i + 6];
			} else {
				des[i] = src[i - 3];
			}
		}
	}

	// �������û�
	private void rowPermToBottom(int[] des, int[] src) {
		for (int i = 0; i < des.length; i++) {
			if (i < 6) {
				des[i] = src[i + 3];
			} else {
				des[i] = src[i - 6];
			}

		}
	}

	// �������û�
	private void columnPermToLeft(int[] des, int[] src) {
		for (int i = 0; i < des.length; i++) {
			if ((i + 1) % 3 == 0) {
				des[i] = src[i - 2];
			} else {
				des[i] = src[i + 1];
			}

		}
	}

	// �������û�
	private void columnPermToRight(int[] des, int[] src) {
		for (int i = 0; i < des.length; i++) {
			if (i % 3 == 0) {
				des[i] = src[i + 2];
			} else {
				des[i] = src[i - 1];
			}

		}
	}

	// ���ѡ����������
	private void selectCenterBlock() {

		String fileName = new String("data.txt");

		File file = new File(fileName);
		// �ж������ļ��Ƿ����
		while (!file.exists()) {
			// �������ļ�
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// �������
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
				// ��ӵ�һ������
				String first = new String();
				for (int i : centerBlock) {
					first += "" + i + " ";
				}
				out.write(first.trim());
				out.newLine();

				// �������������
				while (true) {
					String data = nextArray();
					if (data == null) {
						break;
					}
					out.write(data);
					out.newLine();
				}

				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		// �����������������
		int num = random.nextInt(factorial(9));

		// ��ȡ��Ӧ�е�����
		try {

			RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "r");
			randomAccessFile.seek(19 * (num));
			String data = randomAccessFile.readLine();
			// �����ݷ�������������
			String[] nums = data.split(" ");
			for (int i = 0; i < nums.length; i++) {
				centerBlock[i] = Integer.valueOf(nums[i]);
			}
			randomAccessFile.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	// �����������һ���ֵ���
	private String nextArray() {
		String next = new String();
		int j = -1;

		for (int i = centerBlock.length - 2; i > -1; i--) {
			if (centerBlock[i] < centerBlock[i + 1]) {
				j = i;
				break;
			}
		}

		if (j == -1) {
			return null;
		}

		int k = -1;

		for (int i = centerBlock.length - 1; i > -1; i--) {
			if (centerBlock[i] > centerBlock[j]) {
				k = i;
				break;
			}
		}

		//
		int tmp = centerBlock[j];
		centerBlock[j] = centerBlock[k];
		centerBlock[k] = tmp;

		int start = j + 1;
		int end = centerBlock.length - 1;

		while (start < end) {

			int num1 = centerBlock[start];
			centerBlock[start] = centerBlock[end];
			centerBlock[end] = num1;
			start++;
			end--;
		}

		for (int i : centerBlock) {
			next += "" + i + " ";
		}
		return next.trim();
	}

	// ��׳�
	private int factorial(int n) {
		if (n == 1) {
			return n;
		} else {
			return n * factorial(n - 1);
		}
	}

	// ����������������������
	private void fillSudoku() {

		// ���ȣ������������
		for (int i = 3, k = 0; i < 6; i++) {
			for (int j = 3; j < 6; j++) {
				sudokuArray[i][j] = centerBlock[k];
				k++;
			}
		}

		// ��Σ�������������ı�����
		// ���������
		for (int i = 0, k = 0; i < 3; i++) {
			for (int j = 3; j < 6; j++) {
				sudokuArray[i][j] = topBlock[k];
				k++;
			}
		}
		// ���������
		for (int i = 6, k = 0; i < 9; i++) {
			for (int j = 3; j < 6; j++) {
				sudokuArray[i][j] = bottomBlock[k];
				k++;
			}
		}
		// ���������
		for (int i = 3, k = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				sudokuArray[i][j] = leftBlock[k];
				k++;
			}
		}
		// ���������
		for (int i = 3, k = 0; i < 6; i++) {
			for (int j = 6; j < 9; j++) {
				sudokuArray[i][j] = rightBlock[k];
				k++;
			}
		}

		// �������Ľ�����
		// �����������
		for (int i = 6, k = 0; i < 9; i++) {
			for (int j = 0; j < 3; j++) {
				sudokuArray[i][j] = bottomleftBlock[k];
				k++;
			}
		}
		// �����������
		for (int i = 0, k = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				sudokuArray[i][j] = topleftBlock[k];
				k++;
			}
		}
		// �����������
		for (int i = 6, k = 0; i < 9; i++) {
			for (int j = 6; j < 9; j++) {
				sudokuArray[i][j] = bottomrightBlock[k];
				k++;
			}
		}
		// �����������
		for (int i = 0, k = 0; i < 3; i++) {
			for (int j = 6; j < 9; j++) {
				sudokuArray[i][j] = toprightBlock[k];
				k++;
			}
		}

	}

}
