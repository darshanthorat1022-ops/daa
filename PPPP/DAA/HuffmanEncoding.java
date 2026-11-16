
import java.util.*;

class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    Node(int freq, Node l, Node r) {
        this.ch = '-';
        this.freq = freq;
        left = l;
        right = r; // current null value sathi
    }
}

public class HuffmanEncoding {

    static void print(Node root, String code) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + code);
            return;
        }

        print(root.left, code + "0");
        print(root.right, code + "1"); // binary code add honyasathi
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        PriorityQueue<Node> pq =
            new PriorityQueue<>((a, b) -> a.freq - b.freq);   //min heap vaprl aahe jyachi freq kmi tyachi priority jast

        for (int i = 0; i < n; i++) {
            System.out.print("Character and frequency: ");
            char ch = sc.next().charAt(0);
            int f = sc.nextInt();   // queue madhi taktoy freq and char la method

            pq.add(new Node(ch, f)); // add ith hot queue madhe and node add hoti
        }

        while (pq.size() > 1) {
            Node l = pq.poll();      //tree cha result mhj queue rikami hot nhi toparynt while loop chalnar
            Node r = pq.poll();

            pq.add(new Node(l.freq + r.freq, l, r));  //nvin node 
        }

        System.out.println("Huffman Codes:");
        print(pq.poll(), "");
    }
}
