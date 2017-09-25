/**
 * 数独空格类
 * 
 * @author admin
 *
 */

public class Hole {
	
	private boolean isWrite = false;  // 填写状态
	private int x = -1;   // 空格的x坐标
	private int y = -1;   // 空格的y坐标
	private int[] wNum = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};  // 空格的候选数数组
	private int number = -1;  // 空格最后要填写的值 
	
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
	
	// 返回候选数的个数
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
	// 当候选数组长度为1时，返回第一个候选数就是要填入的值
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
