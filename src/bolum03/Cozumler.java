package bolum03;

public class Cozumler {

	// 2. Verilen bir karakter dizisindeki parantezlerin esli olup olmadigini cikin
	// yapisini kullanarak belirleyen fonksiyonu yaziniz. Ornegin parantezler sira-
	// siyla (()()()) ise eslidir, ((()( ise esli degildir. Verilen ifadede sadece
	// (,) parantez isaretleri bulunmaktadir.	
	static boolean tekliParantez(String dizi) {
		Stack stack = new Stack();
		int left = 0;
		int right = 0;
		for (char c : dizi.toCharArray()) {
			stack.push(c);
		}
		
		while (stack.top != null) {
			switch ((char) stack.pop()) {
			case '(': left++;
			break;
			case ')': right++;
			break;
			}
		}		
		return left == right;
	}
	
	// 3. Verilen bir karakter dizisindeki parantezlerin esli olup olmadigini cikin
	// yapisini kullanarak belirleyen fonksiyonu yaziniz. Ornegin parantezler sira-
	// siyla ({()[{}]}()) ise eslidir, (}])( ise esli degildir. Verilen ifadede sa-
	// dece (, {, [, ), }, ] parantez isaretleri bulunmaktadir.
	static boolean cokluParantez(String dizi) {
		Stack stack = new Stack();
		for (int i = 0; i < dizi.length(); i++) {
			char ch = dizi.charAt(i);
			
			if (ch == '{' || ch == '[' || ch == '(') {
				stack.push(ch);
			} else if (ch == '}' || ch == ']' || ch == ')') {
				if (!stack.isEmpty()) {
					if ((char) stack.peek() == '{' && ch == '}' || ((char) stack.peek() == '[' && ch == ']') || ((char) stack.peek() == '(' && ch == ')')) {
						stack.pop();
					} else {
						return false;
					}
				}
			} else {
				if (ch == ')' || ch == ']' || ch == '}') {
					return false;
				}
			}				
		}
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
		// https://dzone.com/articles/balanced-parenthesis-check
		// adresinden yararlanildi.
	}
	
	// 4. Sabit dizi ile tanimlanan cikin veri yapisini cikin doldugunda buyutecek
	// (cikinda tanimlanmis dizinin kapasitesini iki katina artiracak fonksiyonu ya-
	// ziniz.
	// bkz: bolum03.ArrayStack.push
	
	// 5. Verilen bir karakter dizisinin palindrom olup olmadigini cikin yapisini
	// kullanarak belirleyen fonksiyonu yaziniz.
	static boolean palindrom(String dizi) {
		Stack stack = new Stack();
		for (int i = 0; i < dizi.length(); i++) {
			stack.push(dizi.charAt(i));
		}
		for (int i = 0; i < dizi.length() / 2; i++) {
			if (stack.pop() != dizi.charAt(i)) {
				return false;
			}
		}		
		return true;
	}
	
	// 6. Sabit dizi ile tanimlanan bir cikinin en ustundeki iki elemani yer degis-
	// tiren fonksiyonu yaziniz.
	// bkz: bolum03.ArrayStack.swap
	
	// 7. Bagli liste ile tanimlanan bir cikinin en ustundeki iki elemani yer degis-
	// tiren fonksiyonu yaziniz.
	static void swap(Stack stack) {
		Node temp = stack.top;
		if (temp != null && temp.next != null) {
			int tempA = stack.pop();
			int tempB = stack.pop();
			stack.push(tempA);
			stack.push(tempB);
		}
	}
	
	// 8. Verilen bir cikinin el altindaki elemani donduren fonksiyonu yaziniz. Yaz-
	// diginiz fonksiyonda sadece cikina ekleme, cikindan silme ve cikinin bos oldu-
	// gunu kontrol etme fonksiyonlarini kullanabilirsiniz.
	static int enAlt(Stack stack) {
		Node temp = stack.top;
		while (!stack.isEmpty()) {
			temp = new Node(stack.pop());
		}
		return temp.data;
	}
	
	// 9. Tek bir sabit dizi kullanarak iki cikini birlikte tanimlamak mumkun olabi-
	// lir. Birinci cikin indisi 0 olan elemandan baslayip yeni elemanlar artan in-
	// dislere yerlestirilecek sekilde buyurken, ikinci cikin indisi N - 1 olan ele-
	// mandan baslayip yeni elemanlar azalan indislere yerlestirilecek sekilde buyu-
	// yebilir. Bu amaci gerceklestirecek cikin veri yapisini tanimlayiniz.
	// bkz: bolum03.MultiStack
}
