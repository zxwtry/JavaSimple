/*

ĳ��Ϸ�еĶ���������ԣ�

1. ���ʣ� ľ�ģ��������Ͻ�����

2. ��ɫ�� �� �� �� ��

3. ��״�� �� Բ ���� ���
4. �ߴ磺 ���� 1 ~ 1000

����Ƹö���ļ�ֵ���㷽�������Ե���Ҫ�Դ��ϵ��¼�С��ͬһ���Ե�ֵ����Ҫ�Դ����Ҽ�С��

���� ���ʺõĲ�����ɫ���ߴ磬�϶��и��߼�ֵ��
������ͬ����ɫ�ıȺ�ɫ��ֵ��
�ߴ�ԽСԽֵǮ��

 */


package gaoXiaoBang;

public class �����¶���Ƚ�_��ֵ���� {
	public static void main(String[] args) {
		GameObject g1 = new GameObject("����", "��", "���", 1000);
		GameObject g2 = new GameObject("ľ��", "��", "���", 1000);
		System.out.println(g1.getTheMoreValuableOne(g2).toString());
	}
	static class GameObject {
		private String ����;
		private String ��ɫ;
		private String ��״;
		private int �ߴ�;
		public GameObject() {
		}
		public GameObject(String ����, String ��ɫ, String ��״, int �ߴ�) {
			this.���� = ����;
			this.��ɫ = ��ɫ;
			this.��״ = ��״;
			this.�ߴ� = �ߴ�;
		}
		public void set����(String ����) {
			this.���� = ����;
		}
		public String get����() {
			return ����;
		}
		public void set��ɫ(String ��ɫ) {
			this.��ɫ = ��ɫ;
		}
		public String get��ɫ() {
			return ��ɫ;
		}
		public void set��״(String ��״) {
			this.��״ = ��״;
		}
		public String get��״() {
			return ��״;
		}
		public void set�ߴ�(int �ߴ�) {
			this.�ߴ� = �ߴ�;
		}
		public int get�ߴ�() {
			return �ߴ�;
		}
		public int getValue() {
			//valueֵԽСԽ����Ҫ
			int value = 0;
			if (����.equals("ľ��"))
				value = value * 100 + 0;
			else if (����.equals("����"))
				value = value * 100 + 1;
			else if (����.equals("�Ͻ�"))
				value = value * 100 + 2;
			else if (����.equals("����"))
				value = value * 100 + 3;
			if (��ɫ.equals("��"))
				value = value * 100 + 0;
			else if (��ɫ.equals("��"))
				value = value * 100 + 1;
			else if (��ɫ.equals("��"))
				value = value * 100 + 2;
			else if (��ɫ.equals("��"))
				value = value * 100 + 3;
			if (��״.equals("��"))
				value = value * 100 + 0;
			else if (��״.equals("Բ"))
				value = value * 100 + 1;
			else if (��״.equals("����"))
				value = value * 100 + 2;
			else if (��״.equals("���"))
				value = value * 100 + 3;
			value = value * 1000 + �ߴ� - 1;
			return value;
		}
		public GameObject getTheMoreValuableOne(GameObject myGameObject) {
			return this.getValue() < myGameObject.getValue() ? this : myGameObject;
		}
		public String toString() {
			return "����:"+����+"   ��ɫ:"+��ɫ+"   ��״:"+��״+"   �ߴ�:"+�ߴ�;
		}
	}
}
