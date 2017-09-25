
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

/**
 * 数独生成类
 * 
 * @author Czuaphe
 *
 */
public class SudokuFactory {

	private Random random = new Random();
	// 中心block
	private int[] centerBlock = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	// 四边block
	private int[] topBlock = new int[9];
	private int[] bottomBlock = new int[9];
	private int[] leftBlock = new int[9];
	private int[] rightBlock = new int[9];
	// 四角block
	private int[] topleftBlock = new int[9];
	private int[] toprightBlock = new int[9];
	private int[] bottomleftBlock = new int[9];
	private int[] bottomrightBlock = new int[9];
	// 数独数组
	private int[][] sudokuArray = new int[9][9];

	private int holeNum = 30;

	// 生成一个随机终盘数独
	public int[][] produceFinalSudoku() {

		// 随机选择一个中心区块
		selectCenterBlock();

		// 用中心区块进行 随机行置换 填充左右区块
		if (random.nextInt(2) == 0) {
			rowPermToTop(leftBlock, centerBlock);
			rowPermToBottom(rightBlock, centerBlock);
		} else {
			rowPermToTop(rightBlock, centerBlock);
			rowPermToBottom(leftBlock, centerBlock);
		}

		// 用中心区块进行 随机列置换 填充上下区块
		if (random.nextInt(2) == 0) {
			columnPermToLeft(topBlock, centerBlock);
			columnPermToRight(bottomBlock, centerBlock);
		} else {
			columnPermToLeft(bottomBlock, centerBlock);
			columnPermToRight(topBlock, centerBlock);
		}

		// 选择左右或上下区块，填充四角区块
		// 为0使用左右区块，为1使用上下区块
		if (random.nextInt(2) == 0) {

			// 用左区块进行 随机列置换 填充左上和左下区块
			if (random.nextInt(2) == 0) {
				columnPermToLeft(topleftBlock, leftBlock);
				columnPermToRight(bottomleftBlock, leftBlock);
			} else {
				columnPermToLeft(bottomleftBlock, leftBlock);
				columnPermToRight(topleftBlock, leftBlock);
			}
			// 用右区块进行 随机列置换 填充右上和右下区块
			if (random.nextInt(2) == 0) {
				columnPermToLeft(toprightBlock, rightBlock);
				columnPermToRight(bottomrightBlock, rightBlock);
			} else {
				columnPermToLeft(bottomrightBlock, rightBlock);
				columnPermToRight(toprightBlock, rightBlock);
			}

		} else {

			// 用上区块进行随机行置换填充左上和右上区块
			if (random.nextInt(2) == 0) {
				rowPermToTop(topleftBlock, topBlock);
				rowPermToBottom(toprightBlock, topBlock);
			} else {
				rowPermToTop(toprightBlock, topBlock);
				rowPermToBottom(topleftBlock, topBlock);
			}
			// 用下区块进行随机行置换填充左下和右下区块
			if (random.nextInt(2) == 0) {
				rowPermToTop(bottomleftBlock, bottomBlock);
				rowPermToBottom(bottomrightBlock, bottomBlock);
			} else {
				rowPermToTop(bottomrightBlock, bottomBlock);
				rowPermToBottom(bottomleftBlock, bottomBlock);
			}

		}

		// 填充数独数组，完成构建
		fillSudoku();

		return sudokuArray;

	}

	// 生成一个随机空格数独
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

	// 返回数独数组
	public int[][] getSudokuArray() {
		return sudokuArray;
	}

	// 向上行置换
	private void rowPermToTop(int[] des, int[] src) {
		for (int i = 0; i < des.length; i++) {
			if (i < 3) {
				des[i] = src[i + 6];
			} else {
				des[i] = src[i - 3];
			}
		}
	}

	// 向下行置换
	private void rowPermToBottom(int[] des, int[] src) {
		for (int i = 0; i < des.length; i++) {
			if (i < 6) {
				des[i] = src[i + 3];
			} else {
				des[i] = src[i - 6];
			}

		}
	}

	// 向左列置换
	private void columnPermToLeft(int[] des, int[] src) {
		for (int i = 0; i < des.length; i++) {
			if ((i + 1) % 3 == 0) {
				des[i] = src[i - 2];
			} else {
				des[i] = src[i + 1];
			}

		}
	}

	// 向右列置换
	private void columnPermToRight(int[] des, int[] src) {
		for (int i = 0; i < des.length; i++) {
			if (i % 3 == 0) {
				des[i] = src[i + 2];
			} else {
				des[i] = src[i - 1];
			}

		}
	}

	// 随机选择中心区块
	private void selectCenterBlock() {

		String fileName = new String("data.txt");

		File file = new File(fileName);
		// 判断数据文件是否存在
		while (!file.exists()) {
			// 创建新文件
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 添加数据
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
				// 添加第一行数据
				String first = new String();
				for (int i : centerBlock) {
					first += "" + i + " ";
				}
				out.write(first.trim());
				out.newLine();

				// 添加其它的数据
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

		// 随机中心区块的随机数
		int num = random.nextInt(factorial(9));

		// 读取对应行的数据
		try {

			RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "r");
			randomAccessFile.seek(19 * (num));
			String data = randomAccessFile.readLine();
			// 将数据放入中心区块中
			String[] nums = data.split(" ");
			for (int i = 0; i < nums.length; i++) {
				centerBlock[i] = Integer.valueOf(nums[i]);
			}
			randomAccessFile.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	// 中心区块的下一个字典序
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

	// 求阶乘
	private int factorial(int n) {
		if (n == 1) {
			return n;
		} else {
			return n * factorial(n - 1);
		}
	}

	// 将所有区块填入数独数组
	private void fillSudoku() {

		// 首先，填充中心区块
		for (int i = 3, k = 0; i < 6; i++) {
			for (int j = 3; j < 6; j++) {
				sudokuArray[i][j] = centerBlock[k];
				k++;
			}
		}

		// 其次，填充上下左右四边区块
		// 填充上区块
		for (int i = 0, k = 0; i < 3; i++) {
			for (int j = 3; j < 6; j++) {
				sudokuArray[i][j] = topBlock[k];
				k++;
			}
		}
		// 填充下区块
		for (int i = 6, k = 0; i < 9; i++) {
			for (int j = 3; j < 6; j++) {
				sudokuArray[i][j] = bottomBlock[k];
				k++;
			}
		}
		// 填充左区块
		for (int i = 3, k = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				sudokuArray[i][j] = leftBlock[k];
				k++;
			}
		}
		// 填充右区块
		for (int i = 3, k = 0; i < 6; i++) {
			for (int j = 6; j < 9; j++) {
				sudokuArray[i][j] = rightBlock[k];
				k++;
			}
		}

		// 最后，填充四角区块
		// 填充左下区块
		for (int i = 6, k = 0; i < 9; i++) {
			for (int j = 0; j < 3; j++) {
				sudokuArray[i][j] = bottomleftBlock[k];
				k++;
			}
		}
		// 填充左上区块
		for (int i = 0, k = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				sudokuArray[i][j] = topleftBlock[k];
				k++;
			}
		}
		// 填充右下区块
		for (int i = 6, k = 0; i < 9; i++) {
			for (int j = 6; j < 9; j++) {
				sudokuArray[i][j] = bottomrightBlock[k];
				k++;
			}
		}
		// 填充右上区块
		for (int i = 0, k = 0; i < 3; i++) {
			for (int j = 6; j < 9; j++) {
				sudokuArray[i][j] = toprightBlock[k];
				k++;
			}
		}

	}

}
