package com.coderm.basics.algorithm;
/*MergeSort 是一个非常典型的使用分治法（Divide and Conquer）进行排序的一种算法
MergeSort 的基本思路是，将数组从中间分为两个大小差不多相等的数组，不断进行分解，直到分解到一个个数字构成的数组
这个时候便可以十分方便的判断数字的大小，然后将其按分解顺序的倒序进行合并（Merge），直到全部合并。
Merge的基本思路是：有两个指向数组a，b的指针，不断比较指针指向的元素大小，小的元素填入总数组，然后该数组指针指向
下一个元素，循环往复，直到将两个数组中所有的元素都填入了总数组后，这样就完成了合并。
下举例:		a = {1,5,4,3}
		分割:  L = {1,5}  R = {4,3}
		再分割：{1} {5} {4} {3}
		合并： {1,5}  {3,4}
		合并： {1,3,4,5}
从代码来看：Merge的时间复杂度为O(n)，其没有循环，只有N次比较。
而整体算法的复杂度：T(n) = 2T(n/2)+O(n)
由主方法可知，该算法递归求解后的结果为T(n) = O(nlogn)
*/
import java.util.Arrays;
public class MergeSort {			//Merge是合并程序
	public static int[] Merge(int a[], int b[]) {    //假定数组a,b是从小到大排列有序的数组
		int IndexofA = 0, IndexofB = 0;
		int Index = 0;
		int SizeofA = a.length;
		int SizeofB = b.length;
		int[] MergeRs = new int [SizeofA+SizeofB];
		while(Index != SizeofA+SizeofB) { //在填满数组MergeRs之前不断循环
			if(IndexofA == a.length) {	//首先判断A数组是否已经被全部填入
				MergeRs[Index] = b[IndexofB]; //如果A已经全部填完,则直接按原序将B中元素填入
				IndexofB ++;
				Index++;
			}
			else if(IndexofB == b.length) { //再判断B数组是否已经被完全填入
				MergeRs[Index] = a[IndexofA];	//如果B已经全被填完,则直接按照原序将A中元素填入
				IndexofA++;
				Index++;
			}
			else if(a[IndexofA]<b[IndexofB]) {	//A,B均未被填完,则判断a,b当前所指元素谁更小
				MergeRs[Index] = a[IndexofA];	//如果a小,则把a填入MergeRs
				IndexofA++;						//A数组指向下一个元素
				Index++;						//MergeRs的Index++
			}
			else {
				MergeRs[Index] = b[IndexofB];	//b更小,将B所指的元素填入
				IndexofB++;
				Index++;
			}
		}
		return MergeRs;
	}
	public static int[] MergeSortP(int a[]) {  //MergeSort递归函数
		if(a.length>1) {			//如果数组的长度大于1,则可以分解
			int mid = a.length/2;
			int length = a.length;
			int[] L ;
			L = Arrays.copyOfRange(a, 0, mid);		//将左半部分复制给L
			int[] R ;
			R = Arrays.copyOfRange(a,mid,length);	//将右半部分赋值给R
			L = MergeSortP(L);						//递归调用MergeSortP()对L进行排序
			R = MergeSortP(R);						//递归调用MergeSortP()对R进行排序
			a = Merge(L,R);							//将排好序的L,R通过Merge()函数合并
		}
		return a;									//返回排好序的a
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] TestArray= new int[] {5,5,3,7,9,23,15,47,36,58,244,51,32};
		TestArray = MergeSortP(TestArray);
		for(int a: TestArray) {
			System.out.print(a+"\t");
		}

	}

}
