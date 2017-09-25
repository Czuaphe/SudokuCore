import java.util.ArrayList;

/**
 * 数独解法类
 * 
 * @author Czuaphe
 *
 */
public class SudokuSolution {

	private int[][] sudokuArray;
	private ArrayList<Hole> holes = new ArrayList<>();

	public SudokuSolution(int[][] array) {
		this.sudokuArray = array;
	}

	public boolean findAnswer() {
		
		boolean flag = false;
		
		// 找到所有的空格
		findHoles();
		
		do {
			// 更新每一个空格的所有候选数
			findHolesNum();
			// 将空格候选数为1的空格填入数独中，并标记为填入
		} while (writeHoles());
		
		// 判断是否所有的空格都被填入
		if (holeLength() != 0) {
			
			//System.out.println("有多个解！！");
		} else {
			flag = true;
			//System.out.println("成功！");
		}
		return flag;
		
	}

	// 找到所有的空格
	public void findHoles() {
		for (int i = 0; i < sudokuArray.length; i++) {
			for (int j = 0; j < sudokuArray[i].length; j++) {
				if (sudokuArray[i][j] == 0) {
					Hole hole = new Hole();
					hole.setX(i);
					hole.setY(j);
					holes.add(hole);
				}
			}
		}
	}

	// 找到每一个空格的候选数
	public void findHolesNum() {

		for (Hole hole : holes) {
			// 当前空格已经填写就跳过
			if (hole.isWrite()) {
				continue;
			}
			// 得到每一个空格的坐标和候选数组
			int x = hole.getX();
			int y = hole.getY();
			int[] wNum = hole.getwNum();
			// 删除每一行已有的数字
			for (int i = 0; i < sudokuArray[x].length; i++) {
				if (sudokuArray[x][i] == 0) {
					continue;
				}
				for (int k = 0; k < wNum.length; k++) {
					if (wNum[k] == sudokuArray[x][i]) {
						wNum[k] = 0;
						break;
					}
				}

			}
			// 删除每一列已有的数字
			for (int i = 0; i < sudokuArray[y].length; i++) {
				if (sudokuArray[i][y] == 0) {
					continue;
				}
				for (int j = 0; j < wNum.length; j++) {
					if (wNum[j] == sudokuArray[i][y]) {
						wNum[j] = 0;
						break;
					}
				}
			}
			// 删除空格所在3*3格子中已有的数字
			int xBlock = hole.getX() / 3;
			int yBlock = hole.getY() / 3;

			for (int i = xBlock * 3; i < (xBlock + 1) * 3; i++) {
				for (int j = yBlock * 3; j < (yBlock + 1) * 3; j++) {
					for (int k = 0; k < wNum.length; k++) {
						if (wNum[k] == sudokuArray[x][i]) {
							wNum[k] = 0;
							break;
						}
					}
				}
			}
		}
	}

	// 填入候选数为1的空格，并标记为写入，返回是否有空格被填入
	public boolean writeHoles() {
		boolean flag = false;
		for (Hole hole : holes) {
			if (hole.isWrite()) {
				continue;
			}
			if (hole.getLength() == 1) {
				sudokuArray[hole.getX()][hole.getY()] = hole.getNumber();
				hole.setWrite(true);
				flag = true;
			}
		}
		return flag;
	}

	// 返回需要填入的空格的个数
	public int holeLength() {
		int num = 0;
		for (Hole hole : holes) {
			if (!hole.isWrite()) {
				num++;
			}
		}
		return num;
	}

	public void setSudokuArray(int[][] sudokuArray) {
		this.sudokuArray = sudokuArray;
	}

	public int[][] getSudokuArray() {
		return sudokuArray;
	}

	public ArrayList<Hole> getHoles() {
		return holes;
	}

}
