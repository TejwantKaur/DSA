import java.util.Stack;

public class validParenthesis {
    public static boolean isValid(String str){
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
//            opening
            if(ch=='('||ch=='{'||ch=='['){
                s.push(ch); //opening sare push kerte
            }
            else {
                if (s.isEmpty())
                    return false; //only closing is there, so not pushed and empty

//            agr koi closing aagea hai hun
                if ((s.peek() == '(' && ch == ')')
                    || (s.peek() == '{' && ch == '}')
                    || (s.peek() == '[' && ch == ']'))
                    s.pop();
                else
                    return false;
            }
        }
        if(s.isEmpty())
            return true;
        else
            return false; //start ch extra opening hege aa
    }
    public static void main(String[] args) {
        String str = "{{}[({})()]}]"; // true
        String str2 = "{}";
        System.out.println(isValid(str));

    }
}
