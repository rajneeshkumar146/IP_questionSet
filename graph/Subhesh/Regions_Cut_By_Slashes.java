package Graph;

public class Regions_Cut_By_Slashes {

	public static void main(String[] args) {
	}

	public int regionsBySlashes(String[] grid) {
		int N = grid.length;
		Node[][] nodes = new Node[N + 1][N + 1];
		nodes[0][0] = new Node();

		for (int i = 0; i < nodes.length; i++) {
			for (int j = 0; j < nodes[i].length; j++) {
				if (nodes[i][j] == null) {
					nodes[i][j] = new Node();
				}
			}
		}

		// setting parent of the border
		fillLine(nodes, 0, nodes[0][0]);
		fillLine(nodes, nodes.length - 1, nodes[0][0]);
		fillColumn(nodes, 0, nodes[0][0]);
		fillColumn(nodes, nodes[0].length - 1, nodes[0][0]);

		int ans = 1;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length(); j++) {
				char symbol = grid[i].charAt(j);
				if (symbol == '\\') {
					if (find(nodes[i][j]) == find(nodes[i + 1][j + 1])) {
						ans++;
					}
					union(nodes[i][j], nodes[i + 1][j + 1]);
				} else if (symbol == '/') {
					if (find(nodes[i][j + 1]) == find(nodes[i + 1][j])) {
						ans++;
					}
					union(nodes[i][j + 1], nodes[i + 1][j]);
				}
			}
		}

		return ans;
	}

	// find set
	private Node find(Node n) {
		Node parent = n.parent;
		if (n.parent != n) {
			parent = find(n.parent);
		}
		n.parent = parent;// path compression
		return parent;
	}

	// union without ranking
	private void union(Node a, Node b) {
		Node pA = find(a);
		Node pB = find(b);
		pA.parent = pB;
	}

	private void fillLine(Node[][] nodes, int line, Node parent) {
		for (int j = 0; j < nodes[line].length; j++) {
			if (nodes[line][j] == null) {
				nodes[line][j] = new Node();
			}
			nodes[line][j].parent = parent;
		}
	}

	private void fillColumn(Node[][] nodes, int column, Node parent) {
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i][column] == null) {
				nodes[i][column] = new Node();
			}
			nodes[i][column].parent = parent;
		}
	}
}

class Node {
	public Node parent;

	public Node() {
		this.parent = this;
	}
}
