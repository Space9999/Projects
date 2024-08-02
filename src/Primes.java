import java.util.ArrayList;
public class Primes {

	public static void main(String[] args) {
		System.out.println(SOE(10000));
	}
	
	public static ArrayList<Integer> SOE(int n) {
		ArrayList<Integer> queue = new ArrayList<Integer>(), result = new ArrayList<Integer>();
		for (int i = 2; i <= n; i++) {queue.add(i);}
		int p = queue.remove(0), limit = (int)Math.sqrt(n); result.add(p); 
		while (p <= limit) {
			for (int j = queue.size() - 1; j >= 0; j--) {
				if (queue.get(j) % p == 0) {queue.remove(j);}
			}
			p = queue.remove(0); result.add(p);
		}
		for (int k : queue) {result.add(k);}
		return result;
	}

}
