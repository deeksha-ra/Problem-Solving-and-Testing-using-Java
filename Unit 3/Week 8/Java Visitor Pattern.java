import java.io.*;
import java.util.*;


abstract class Tree {
    private int value;
    private int depth;
    private Tree.Color color;

    enum Color {
        RED, GREEN
    }

    Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    int getValue() {
        return value;
    }

    Color getColor() {
        return color;
    }

    int getDepth() {
        return depth;
    }

    abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {
    private ArrayList<Tree> children = new ArrayList<>();

    TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    void accept(TreeVis visitor) {
        visitor.visitNode(this);
        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {
    TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    abstract int getResult();

    abstract void visitNode(TreeNode node);

    abstract void visitLeaf(TreeLeaf leaf);
}

class SumInLeavesVisitor extends TreeVis {
    private int sum = 0;

    public int getResult() {
        return sum;
    }

    public void visitNode(TreeNode node) {
    }

    public void visitLeaf(TreeLeaf leaf) {
        sum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private static final int MOD = 1000000007;
    private long product = 1;

    public int getResult() {
        return (int) product;
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Tree.Color.RED) {
            product = (product * node.getValue()) % MOD;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Tree.Color.RED) {
            product = (product * leaf.getValue()) % MOD;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int evenDepthSum = 0;
    private int greenLeafSum = 0;

    public int getResult() {
        return Math.abs(evenDepthSum - greenLeafSum);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            evenDepthSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Tree.Color.GREEN) {
            greenLeafSum += leaf.getValue();
        }
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        Tree.Color[] colors = new Tree.Color[n];
        for (int i = 0; i < n; i++) {
            colors[i] = sc.nextInt() == 0
                    ? Tree.Color.RED
                    : Tree.Color.GREEN;
        }

        ArrayList<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;

            graph[u].add(v);
            graph[v].add(u);
        }

        Tree root = buildTree(0, -1, 0, values, colors, graph);

        TreeVis vis1 = new SumInLeavesVisitor();
        TreeVis vis2 = new ProductOfRedNodesVisitor();
        TreeVis vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        System.out.println(vis1.getResult());
        System.out.println(vis2.getResult());
        System.out.println(vis3.getResult());
    }

    static Tree buildTree(int current, int parent, int depth,
                          int[] values, Tree.Color[] colors,
                          ArrayList<Integer>[] graph) {

        if (graph[current].size() == 1 && current != 0) {
            return new TreeLeaf(values[current], colors[current], depth);
        }

        TreeNode node = new TreeNode(values[current], colors[current], depth);

        for (int next : graph[current]) {
            if (next != parent) {
                node.addChild(buildTree(next, current, depth + 1,
                        values, colors, graph));
            }
        }

        return node;
    }
}
Input (stdin)
5
4 7 2 5 12
0 1 0 0 1
1 2
1 3
3 4
3 5
Your Output (stdout)
24
40
15
Expected Output
24
40
15
