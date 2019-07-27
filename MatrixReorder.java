import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class MatrixReorder {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("D:\\gems.txt"));
         int inputs = sc.nextInt();
        for (int n = 0; n < inputs; n++) {
            int rowscount = sc.nextInt();
            int colCount = sc.nextInt();
            sc.nextLine();
            char[][] data= new char[rowscount][colCount];
            for (int row = 0; row < rowscount; row++) {
            char[] coldata=sc.nextLine().toCharArray();
            for(int col=0;col<coldata.length;col++) {
            	
            	if(data[row][col]!='R') {
            	if(coldata[col]=='b') {
            		int pCol=col;
            		int pRow=row;
            		if(pCol+1<colCount) {
            			data[row][pCol+1]='B';
            		}
            		if(pCol-1>0&&data[row][pCol-1]=='x') {
            			data[row][pCol-1]='B';
            		}
            		if(pCol+1<colCount) {
            			data[row][pCol+1]='B';
            		}
            		if(pRow+1<rowscount) {
            			data[pRow+1][pCol]='B';
            		}
            		if(pRow-1>=0&&pRow-1<rowscount) {
            			data[pRow-1][pCol]='B';
            		}
            		data[row][col]=coldata[col];
            	}else if((coldata[col]=='x'&&data[row][col]!='B')||(coldata[col]!='x')) {
            		data[row][col]=coldata[col];
            	}
            	}
            	if(data[row][col]!='B') {
            	if(coldata[col]=='r') {
            		int pCol=col;
            		int pRow=row;
            		if(pCol+1<colCount) {
            			data[row][pCol+1]='R';
            		}
            		if(pCol-1>=0) {
            			data[row][pCol-1]='R';
            		}
            		if(pCol+1<colCount) {
            			data[row][pCol+1]='R';
            		}
            		if(pRow+1<rowscount) {
            			data[pRow+1][pCol]='R';
            			if(pCol+1<colCount) {
                			data[pRow+1][pCol+1]='R';
                		}
            			if(pCol-1>=0) {
                			data[pRow+1][pCol-1]='R';
                		}
            			
            		}
            		if(pRow-1>=0&&pRow-1<rowscount) {
            			data[pRow-1][pCol]='R';
            			if(pCol+1<colCount) {
                			data[pRow-1][pCol+1]='R';
                		}
            			if(pCol-1>=0) {
                			data[pRow-1][pCol-1]='R';
                		}
            		}
            		data[row][col]=coldata[col];
            	}else if((coldata[col]=='x'&&data[row][col]!='R')||(coldata[col]!='x')) {
            		data[row][col]=coldata[col];
            	}
            	}
            	
            	if(data[row][col]=='B'&&coldata[col]=='r') {
            		data[row][col]=coldata[col];
            	}
            	
            	
            	
            }
            }
            
        int count=0;
        for (int row = 0; row < rowscount; row++) {
            for(int col=0;col<colCount;col++) {
            	System.out.print(data[row][col]);
            	if(data[row][col]=='x') {
            		count++;
            	}
            	
            }
            System.out.println("");
            }
            
           System.out.println(count); 
              
        }
        sc.close();

    }
}