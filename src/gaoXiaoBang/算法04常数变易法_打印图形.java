package gaoXiaoBang;


/*

打印图形
试打印出如下图形：
 
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
 
注意规模可以调整


 */


public class 算法04常数变易法_打印图形 {
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
