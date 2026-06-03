import java.util.HashMap;

class Trie {

    HashMap<Character, Integer> val;
    HashMap<Character, Trie> child;

    boolean isEnd;

    Trie() {

        val = new HashMap<>();
        child = new HashMap<>();

        isEnd = false;
    }
}

public class MapSum {

    Trie root;

    MapSum() {

        root = new Trie();
    }

    public void insert(String word, int value) {

        Trie current = root;

        for(int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            Trie next = current.child.get(ch);

            if(next == null) {

                Trie newNode = new Trie();

                current.child.put(ch, newNode);

                current.val.put(ch, value);

                current = newNode;
            }
            else {

                current.val.put(ch, value);

                current = next;
            }
        }

        current.isEnd = true;
    }

    public int sum(String prefix) {

        Trie current = root;

        for(int i = 0; i < prefix.length(); i++) {

            char ch = prefix.charAt(i);

            Trie next = current.child.get(ch);

            if(next == null) {
                return 0;
            }

            current = next;
        }

        return dfs(current);
    }

    public int dfs(Trie node) {

        int total = 0;

        for(Character ch : node.child.keySet()) {

            total += node.val.get(ch);

            total += dfs(node.child.get(ch));
        }

        return total;
    }

    public static void main(String[] args) {

        MapSum obj = new MapSum();

        obj.insert("apple", 3);

        System.out.println(
            obj.sum("ap")
        );

        obj.insert("app", 2);

        System.out.println(
            obj.sum("ap")
        );
    }
}