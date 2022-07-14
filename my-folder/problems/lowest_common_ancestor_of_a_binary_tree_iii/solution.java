/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        List<Node> pList = new ArrayList<Node>();
        List<Node> qList = new ArrayList<Node>();
        
        Node curr = p;
        while(curr != null && curr != curr.parent) {
            pList.add(curr);
            curr = curr.parent;
        }
        
        curr = q;
        while(curr != null && curr != curr.parent) {
            qList.add(curr);
            curr = curr.parent;
        }
        
        
        Node pCurr = pList.get(pList.size() - 1);
        Node qCurr = qList.get(qList.size() - 1);
        int count = 1;
        while(pCurr == qCurr) {
            count++;
            if((pList.size() - count) < 0 || (qList.size() - count) < 0) {
                return pCurr;
            }
            pCurr = pList.get(pList.size() - count);
            qCurr = qList.get(qList.size() - count);
        }
        
        count--;
        return pList.get(pList.size() - count);
    }
}