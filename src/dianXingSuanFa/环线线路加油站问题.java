package dianXingSuanFa;

/*


���⣺ĳ���������ɼ���վ����֪��վ��������վ�����������������ĳһվ�����ܹ���һȦ��

�������뵽�ķ������ȴӵ�0��λ�ÿ�ʼ��̽�����Ƿ�����һȦ���������һ��λ�ý�����̽��
���Ӷ�ΪO(n^2)����A[i]Ϊ����վ������B[i]Ϊ��iվ����i+1վ��Ҫ�ķѵ��������㷨�ֲ������£�

1.��C[i] = A[i] �C B[i] ��ʾ��i��i+1����õġ�����������
2.����SUM��C[0:N-1])�������ڽ⣬���������򷵻ء�
3.��i=0��
4.��j=i��
5.����sum(C[i:j])��
6.��sum��C[i:j])С��0��i��1��ת4��
7.��jС��N-1��j��1��ת5�����򷵻�i���㷨������

���� ��6����i��1��Ϊ��̽ʧ��ʱ������һ��λ�ý�����̽��������������Ż�����Ϊ��̽ʧ����ζ�ţ�
1.sum(C[i:j])<0
2.sum[C[i:k])>=0 i<=k<=j-1��
��Ϊsum(C[i:j])=sum(C[i:k])+sum(C[k+1:j])������sum(C[k+1:j])<0�� i<=k<=j-1��
��˴�i+1��j��������̽����������̽��λ�ÿ���ֱ����j+1�������㷨�ĸ��Ӷ�ΪO(n)��


 */



public class ������·����վ���� {
	public static void main(String[] args) {
		int[] oilMassOfPort    = {200, 200, 200, 200, 200, 200};
//		int[] oilConsumeStartI = {201};
//		int[] oilConsumeStartI = null;
//		int[] oilConsumeStartI = {201, 201, 201, 201, 201, 195};
		int[] oilConsumeStartI = {200, 200, 203, 200, 200, 197};
		System.out.println(findThePort(oilMassOfPort, oilConsumeStartI));
	}
	
	//�����ҵ�һ����������ҵ���ʼ����վ�ķ���
	private static int findThePort (int[] oilMassOfPort, int[] oilConsumeStartI) {
		//����-1��ʾ��������Ϊ�գ������������ݲ���ͬ����
		if (oilMassOfPort == null || oilConsumeStartI == null || 
				oilMassOfPort.length != oilConsumeStartI.length)	return -1;
		
		//����-2��ʾȫ�����ʹ����ﲻ��Ҫ��
		int[] massMinusConsume = new int[oilMassOfPort.length];
		int massMinusConsumeSum = 0;
		for (int i = oilMassOfPort.length-1; i >= 0; -- i) {
			massMinusConsume[i] = oilMassOfPort[i] - oilConsumeStartI[i];
			massMinusConsumeSum += massMinusConsume[i];
		}
		if (massMinusConsumeSum < 0)   return -2;
		
		//��ʼ����
		for (int selectStartPort = 0; selectStartPort < oilMassOfPort.length; ++ selectStartPort) {
			int selectMassMinusConsumeSum = 0;
			for (int nowPortPre = selectStartPort; nowPortPre < selectStartPort+oilMassOfPort.length; ++ nowPortPre) {
				int nowPort = getNowPort(oilMassOfPort.length, nowPortPre);
				selectMassMinusConsumeSum += massMinusConsume[nowPort];
				if (selectMassMinusConsumeSum < 0) {
					selectStartPort = nowPort;
					break;
				}
				if (nowPortPre == selectStartPort+oilMassOfPort.length-1)
					return selectStartPort;
			}
		}
		
		
		//���ܼ���õ��Ľ���ǣ�û�н�����򷵻�-3
		return -3;
	}
	
	//������findThePort�����У�nowPort�ļ��㷽��
	private static int getNowPort(int oilMassOfPortLength, int nowPortPre) {
		return nowPortPre >= oilMassOfPortLength ? nowPortPre-oilMassOfPortLength : nowPortPre;
	}
}
