import java.util.*;
public class rev {

    public static void pushAtBottom(Stack<Integer> s , int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop(); //going up
        pushAtBottom(s,data); //next level
        s.push(top); // push data coming down
    }

    public void revStack(Stack<Integer> s){
        if(s.isEmpty()) return;

        int top = s.pop();
        revStack(s);
        pushAtBottom(s,top);
    }
    public static void main(String[] args) {

    }
}
