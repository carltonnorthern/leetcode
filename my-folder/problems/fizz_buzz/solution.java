class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList();
        for(int i = 1; i <=n; i++){
            boolean div3 = ((i%3) == 0);
            boolean div5 = ((i%5) == 0);
            if(div3 && div5) {
                result.add("FizzBuzz");
            } else if(div3) {
                result.add("Fizz");
            } else if(div5) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        
        return result;
    }
}