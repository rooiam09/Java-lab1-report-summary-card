import java.util.StringTokenizer;
import java.io.*;
public class lab1 {
	
	public static void main(String args[])
	{
        String fileName = "D:\\Java Lab\\HW1-data.txt";
        String pre = null;
        String thisLine=null;
        try {
        	int count = 0,max=0,a=0,b=0,c=0,d=0,f=0;
        	double totper=0, pct=0;
        	char grade;
            FileReader fileReader =  new FileReader(fileName);
            BufferedReader reader =  new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("D:\\Java Lab\\HW1-output-16103067.txt");  
            BufferedWriter writer = new BufferedWriter(fileWriter);  
            writer.write("Stdnt Id  Ex  ------- Assignments ---------  Tot  Mi  Fin  CL  Pts  Pct  Gr");
            writer.newLine();
            writer.write("--------  --  -----------------------------  ---  --  ---  --  ---  ---  --");
            writer.newLine();
                   
            int data[]=new int [15];
			while((thisLine=reader.readLine())!=null)
			 {
				count++;						//to count to total no of students
				StringTokenizer token = new StringTokenizer(thisLine);			//allows string to break into tokens in a line
				for(int j=0;j<15;j++)
				{
					String s = token.nextToken();
					data[j]=Integer.parseInt(s);				//convert string to int
				}
				
				int total =0;			//Sum of all assignment marks
				for(int j=2;j<12;j++)
					total=total+data[j];
				
				int Pts=0;				//Points in report card
				for(int j=1;j<15;j++)
			    	Pts=Pts+data[j];
				if(Pts>max) 			//max returns max points scored 
					max=Pts;
				
				pct=((Pts*100)/420);		//pct is percentage
				totper=totper+pct;			//total percentage of class for finding average percentage
			
				
				if(Math.round(pct)>=90)			//Math.round for rounding off to close numeral
				{grade='A';
				a++;
				}
				else if(Math.round(pct)<90 && Math.round(pct)>=78) {
					grade='B';
					b++;
				}
				else if(Math.round(pct)<78 && Math.round(pct)>=62) {
					grade='C';
					c++;
				}
				else if(Math.round(pct)<62 && Math.round(pct)>=46) {
					grade='D';
					d++;
				}
				else {
					grade='F';
					f++;
				}						
				
				check(data,pre,writer);
				
				writer.write(data[1]+"  ");
				for(int i=2;i<12;i++) {
					if(data[i]/10<1)
						writer.write(" "+data[i]+" ");
					else
					writer.write(data[i]+" ");}
				writer.write(" ");
				writer.write(total+"  ");
				writer.write(data[12]+"  ");
				writer.write(" "+data[13]+"  ");
				if(data[14]/10<1)
					writer.write(" "+data[14]+"  ");
				else
					writer.write(data[14]+"  ");
				writer.write(Math.round(Pts)+"  ");
				writer.write(" "+Math.round(pct)+"  ");
				writer.write(" "+grade);
				writer.newLine();				
			 }

			writer.newLine();
			writer.write("-----Summary of Report-----");
			writer.newLine();
			writer.write("Average total point percent of all students: "+totper/count+" %");
			writer.newLine();
			writer.write("Number of A's = "+a);
			writer.newLine();
			writer.write("Number of B's = "+b);
			writer.newLine();
			writer.write("Number of C's = "+c);
			writer.newLine();
			writer.write("Number of D's = "+d);
			writer.newLine();
			writer.write("Number of F's = "+f);
			writer.newLine();
			writer.write("Maximum points = "+max);
		
		    reader.close();
            		writer.close();
            }
        
        catch(IOException ex) {
            ex.printStackTrace();
        }
	}

	static void check(int indata[], String pre,BufferedWriter writer)
    {
		try {
		 if(indata[0]/10000000<1) {	//to check if roll no if starting with 0
				pre="0"+Integer.toString(indata[0]);			//then we add 0 and add it to roll no converting it to string
				writer.write(pre+"  ");
				}
			else
				writer.write(indata[0]+"  ");
		}
		catch(IOException ex) {
            ex.printStackTrace();
        }
    }

}
