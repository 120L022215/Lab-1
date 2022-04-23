import java.io.*;
import java.nio.charset.*;

public class HelloWorld {
	
	public static void main(String[] args) throws IOException {
		System.out.println("Hello World");
		isLegalMagicSquare("E:\\软件构造\\Lab-1\\P1\\5.txt\\");
		}

	public static void PrintArray(int A[][])
	{
		for(int[] a :A)
		{
			for(int b:a)
			System.out.print(b+" ");
			System.out.println();
		}
	}
	
	public static int[][] GetMyarray(String fileName) throws NumberFormatException, IOException
	{
		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
		BufferedReader br = new BufferedReader(isr);

		String line;
		int Myrow_index=0; 
		int Mycolumn_index=0;
		
		/*Read first line and creat a 2-d array*/
		line = br.readLine();
		String[] Myline =line.split("\t");
		final int LEN= Myline.length;
		int[][] Myarray= new int[LEN][LEN];
		 for (String item: Myline)
			   Myarray[Myrow_index][Mycolumn_index++]=Integer.valueOf(item);
			   
		 Myrow_index++;
		Mycolumn_index=0;
			
		while((line = br.readLine()) != null){
		     //process the line
			/*split line into nums by '/t' */
			
			Myline=line.split("\t");
			/*trans string into int*/
			
		
		   for (String item: Myline)
			   Myarray[Myrow_index][Mycolumn_index++]=Integer.valueOf(item);
		 
			Myrow_index+=1;
			Mycolumn_index=0;
		}
		br.close();
		 return Myarray;
	}
	public static boolean Judge(int[][] Myarray )
	{
		PrintArray(Myarray);
		int row=Myarray.length;
		
		int std_sum=0;
		for (int[] item_row: Myarray)
		{
			for(int item:item_row)
				std_sum+=item;
		}
		std_sum/=row;
		System.out.println(std_sum);
		
		
		boolean flag=true;
		/*Judge Row*/
		for (int[] item_row: Myarray)
		{
			int sum=0;
			for(int item:item_row)
			{
					sum+=item;
			}
			if(sum!=std_sum) flag=false;
		}
		/*Judge column */
		for (int j=0;j<row;j++)
		{
			int sum=0;
			for(int i=0;i<row;i++)
			{
					sum+=Myarray[i][j];
			}
			if(sum!=std_sum) flag=false;
		}
		/*judge diagonals*/
		int sum=0;
		for(int i=0;i<row;i++)
			sum+=Myarray[i][i];
		if(sum!=std_sum) flag=false;
		sum=0;
		for(int i=0;i<row;i++)
			sum+=Myarray[i][row-i-1];
		if(sum!=std_sum) flag=false;
		System.out.println(flag);
		
		return flag;
	}
	public static boolean  isLegalMagicSquare(String fileName) throws IOException {
		/*Judge whether call func is successful or not*/
		//System.out.println("call fun1 successly!");
		int[][] Myarray=GetMyarray(fileName);
		return Judge(Myarray);
	}	
}
