package hu.webarticum.treeprinter;

import java.util.ArrayList;
import java.util.List;

public class Util {
    
    static public int[] getContentDimension(String content) {
        int longsetLineLength = 0;
        String[] lines = content.split("\n");
        for (String line: lines) {
            int lineLength = line.length();
            if (lineLength > longsetLineLength) {
                longsetLineLength = lineLength;
            }
        }
        return new int[] {longsetLineLength, lines.length};
    }
    
    static public int getDepth(TreeNode treeNode) {
        List<TreeNode> levelNodes = new ArrayList<TreeNode>();
        levelNodes.add(treeNode);
        int depth = 0;
        while (true) {
            List<TreeNode> newLevelNodes = new ArrayList<TreeNode>();
            for (TreeNode levelNode: levelNodes) {
                for (TreeNode childNode: levelNode.getChildren()) {
                    if (childNode != null) {
                        newLevelNodes.add(childNode);
                    }
                }
            }
            if (newLevelNodes.isEmpty()) {
                break;
            }
            levelNodes = newLevelNodes;
            depth++;
        }
        return depth;
    }

    static public String repeat(char character, int repeats) {
        StringBuilder resultBuilder = new StringBuilder();
        repeat(resultBuilder, character, repeats);
        return resultBuilder.toString();
    }
    
    static public void repeat(StringBuilder stringBuilder, char character, int repeats) {
        for (int i = 0; i < repeats; i ++) {
            stringBuilder.append(character);
        }
    }

}