/**
 * �����ո���
 * 
 * @author admin
 *
 */

public class Hole {
	
	private boolean isWrite = false;  // ��д״̬
	private int x = -1;   // �ո��x����
	private int y = -1;   // �ո��y����
	private int[] wNum = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};  // �ո�ĺ�ѡ������
	private int number = -1;  // �ո����Ҫ��д��ֵ 
	
	public boolean isWrite() {
		return isWrite;
	}
	public void setWrite(boolean isWrite) {
		this.isWrite = isWrite;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int[] getwNum() {
		return wNum;
	}
	public void setwNum(int[] wNum) {
		this.wNum = wNum;
	}
	public int getNumber() {
		return number;
	}
	
	// ���غ�ѡ���ĸ���
	public int getLength() {
		int num = 0;
		for (int i = 0; i < wNum.length; i++) {
			if (wNum[i] != 0) {
				this.number = wNum[i];
				num ++;
			}
		}
		return num;
	}
	// ����ѡ���鳤��Ϊ1ʱ�����ص�һ����ѡ������Ҫ�����ֵ
	@Deprecated
	public int getFirstNum() {
		int num = 0;
		for (int i = 0; i < wNum.length; i++) {
			if (wNum[i] != 0) {
				num = wNum[i];
			}
		}
		return num;
	}
	
}
