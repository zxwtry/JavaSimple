package nowCoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
public class 华为购物单￥又依赖的背包问题￥完整代码 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int sum=scanner.nextInt();
        int N=scanner.nextInt();
        List<Item> extraItems=new ArrayList<Item>();
        Map<Integer, Group> groupMap=new HashMap<Integer, Group>();
        for(int i=0;i<N;i++) {
            int price=scanner.nextInt();
            int deg=scanner.nextInt();
            int q=scanner.nextInt();
            Item item=new Item();
            item.price=price;
            item.value=price*deg;
            item.id=(q==0?i+1:q);  		//这样id就和依赖完全匹配
            if(q==0) {					//主件
                Group group=new Group();
                group.item=item;
                groupMap.put(item.id, group);
            } else {
                if(groupMap.get(q)!=null) {
                    Group group=groupMap.get(q);
                    if(group.accessory!=null) {
                        group.accessory.add(item);
                    }
                    else {
                        group.accessory=new ArrayList<Item>();
                        group.accessory.add(item);
                    }
                }
                else {
                    extraItems.add(item);
                }
            }
        }
        //将顺序有序的加入
        for(int i=0;i<extraItems.size();i++) {
            Item item=extraItems.get(i);
            int id=item.id;
            if(groupMap.get(id)!=null) {
                Group group=groupMap.get(id);
                if(group.accessory!=null) {
                    group.accessory.add(item);
                }
                else {
                    group.accessory=new ArrayList<Item>();
                    group.accessory.add(item);
                }
            }
        }
        //将有依赖的百宝问题转换成背包问题
        List<Item> bag=new ArrayList<Item>();
        Iterator<Map.Entry<Integer, Group>> iterator=groupMap.entrySet().iterator();
        while(iterator.hasNext()) {
            Entry<Integer,Group> entry=iterator.next();
            Group group=entry.getValue();
            if(group.accessory==null) {
                bag.add(group.item);
            }
            else if(group.accessory.size()==1) {
                Item acItem=group.accessory.get(0);
                Item item=group.item;
                bag.add(item);
                Item newItem=new Item();
                newItem.price=item.price+acItem.price;
                newItem.value=item.value+acItem.value;
                bag.add(newItem);
            }
            else if(group.accessory.size()==2) {
                Item ac1=group.accessory.get(0);
                Item ac2=group.accessory.get(1);
                Item item =group.item;
                bag.add(item);
                Item n1=new Item();
                n1.price=item.price+ac1.price;
                n1.value=item.value+ac1.value;
                Item n2=new Item();
                n2.price=item.price+ac2.price;
                n2.value=item.value+ac2.value;
                Item n3=new Item();
                n3.price=item.price+ac2.price+ac1.price;
                n3.value=item.value+ac2.value+ac1.value;
                bag.add(n1);
                bag.add(n2);
                bag.add(n3);
            }
        }
        //对背包进行规划
        System.out.println(getMax(bag, bag.size(), sum));
        scanner.close();
    }
    
    public static int getMax(List<Item> list,Integer index,int extraMoney) {
        if(index==0 || extraMoney==0) return 0;
        if(list.get(index-1).price>extraMoney) {
            return getMax(list, index-1, extraMoney);
        }
        else {
            int m1=getMax(list, index-1, extraMoney);
            int m2=getMax(list, index-1, extraMoney-list.get(index-1).price)+list.get(index-1).value;
            return Math.max(m1, m2);
        }
    }
    
    static class Item {
        int id;
        int price;
        int value;//价格与重要度的乘积
    }
    static class Group {
        Item item;
        List<Item> accessory;
    }
}