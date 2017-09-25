import java.util.ArrayList;

/**
 * �����ⷨ��
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
		
		// �ҵ����еĿո�
		findHoles();
		
		do {
			// ����ÿһ���ո�����к�ѡ��
			findHolesNum();
			// ���ո��ѡ��Ϊ1�Ŀո����������У������Ϊ����
		} while (writeHoles());
		
		// �ж��Ƿ����еĿո񶼱�����
		if (holeLength() != 0) {
			
			//System.out.println("�ж���⣡��");
		} else {
			flag = true;
			//System.out.println("�ɹ���");
		}
		return flag;
		
	}

	// �ҵ����еĿո�
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

	// �ҵ�ÿһ���ո�ĺ�ѡ��
	public void findHolesNum() {

		for (Hole hole : holes) {
			// ��ǰ�ո��Ѿ���д������
			if (hole.isWrite()) {
				continue;
			}
			// �õ�ÿһ���ո������ͺ�ѡ����
			int x = hole.getX();
			int y = hole.getY();
			int[] wNum = hole.getwNum();
			// ɾ��ÿһ�����е�����
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
			// ɾ��ÿһ�����е�����
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
			// ɾ���ո�����3*3���������е�����
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

	// �����ѡ��Ϊ1�Ŀո񣬲����Ϊд�룬�����Ƿ��пո�����
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

	// ������Ҫ����Ŀո�ĸ���
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
