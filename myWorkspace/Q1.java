import java.util.*;
import java.io.*;
import java.lang.*;

class item
{
	private String itemCode;
	private String itemName;
	private int itemRate;
	private int itemQuantity;

	public item(String itemCode,String itemName,int itemRate,int itemQuantity){
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.itemRate = itemRate;
		this.itemQuantity = itemQuantity;
	}
	public String getItemCode(){
		return itemCode;
	}
	public String getItemName(){
		return itemName;
	}
	public int getItemRate(){
		return itemRate;
	}
	public int getItemQuantity(){
		return itemQuantity;
	}
	public String getItemTotal(){
		int total = itemRate*itemQuantity;
		return total;
	}
	public String toString(){
		return String.format("%s %s %d %d %d\n",itemCode,itemName,itemRate,itemQuantity,getItemTotal());
	}
}


class listItems{
	private ArrayList <item>it;
	public listItems(){
		it = new ArrayList<item>();
	}

	public void addItem(item i){
		it.add(it);
	}
	public item getItem(int index){
        return it.get(index);
	}
	public int getTotal(){
		int sum=0;
		for(item items:it){
			sum+=items.getItemTotal();
		}
		return sum;
	}
}

class mainClass{
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0){
			int n=s.nextInt();
			int temp = n;
			listItems li = new ListItems();
			while(n-->0){
				String icode = s.next();
				String iname = s.next();
				int irate = s.nextInt();
				int iQuantity = s.nextInt();
				item itm = new item(icode,iname,irate,iQuantity);
				li.addItem(itm);
			}
			for(int i=0;i<temp;i++){
				System.out.print(li.getItem(i).toString());
			}
			System.out.println(li.getTotal());
		}
	}
}