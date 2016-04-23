import java.util.*;
class Rule30{

	static int length;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("enter height: ");
		int height = scan.nextInt();

		System.out.print("enter initial state: ");
		String init = scan.next();
		length = init.length();

		char[][] output = rule30(init,height);
		display(output,height);	
	}

	static char[][] rule30 (String a, int height){
		char[][] r30 = new char[height][length + 2];

		for (int i = 0, j = 1; j < length + 1; j++, i++) {
			r30[0][j] = a.charAt(i);
		}

		for (int i = 0; i < height - 1; i++) {
			// System.out.println("i: " + i);
			r30[i][0] = '0';
			r30[i][length+1] = '0';

			for (int j = 0; j < length; j++) {
				// System.out.println("j: " + j);
				if(checkPattern(r30[i][j],r30[i][j+1],r30[i][j+2])){
					r30[i+1][j+1] = '1';
				}
				else{
					r30[i+1][j+1] = '0';
				}
			}
		}

		return r30;
	}

	static boolean checkPattern(char a, char b, char c){

		if(a == '1' && b == '1' && c == '1'){
			return false;}
		else if(a == '1' && b == '1' && c == '0'){
			return false;}
		else if(a == '1' && b == '0' && c == '1'){
			return false;}
		else if(a == '1' && b == '0' && c == '0'){
			return true;}
		else if(a == '0' && b == '1' && c == '1'){
			return true;}
		else if(a == '0' && b == '1' && c == '0'){
			return true;}
		else if(a == '0' && b == '0' && c == '1'){
			return true;}
		else if(a == '0' && b == '0' && c == '0'){
			return false;}	
		else{
			return false;
		}	
	}

	static void display(char[][] a, int height){

		for (int i = 0; i < height; i++) {

			for (int j = 1; j < (length + 1); j++) {
				System.out.print(a[i][j]);
				
			}
			System.out.println();
		}
	}



}