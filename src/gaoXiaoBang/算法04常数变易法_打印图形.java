package gaoXiaoBang;


/*

��ӡͼ��
�Դ�ӡ������ͼ�Σ�
 
 $$          $$
  $$        $$ 
   $$      $$ 
    $$    $$    
     $$  $$     
      $$$$    
        $$       
      $$$$    
     $$  $$     
    $$    $$   
   $$      $$  
  $$        $$ 
 $$          $$
 
ע���ģ���Ե���


 */


public class �㷨04�������׷�_��ӡͼ�� {
	public static void main(String[] args) {
		myPrintX(13);
	}
	private static void myPrintX(int numOfLayer) {
		myPrintALayer(numOfLayer, numOfLayer>>1);
	}
	private static void myPrintALayer(int numOfLayer, int indexOfLayer) {
		if (indexOfLayer < -Math.abs(numOfLayer>>1)) {
			return;
		}
		if (indexOfLayer == 0) {
			if ((numOfLayer & 0x1) == 1) {
				for (int i = 0; i < numOfLayer>>1; ++ i) {
					System.out.print(" ");
				}
				System.out.println("$$");
			}
		} else {
			for (int i = 0; i < (numOfLayer>>1) - Math.abs(indexOfLayer); ++i) {
				System.out.print(" ");
			}
			System.out.print("$$");
			for (int i = Math.abs(indexOfLayer); i > 1; -- i) {
				System.out.print("  ");
			}
			System.out.println("$$");
		}
		myPrintALayer(numOfLayer, --indexOfLayer);
	}
}
