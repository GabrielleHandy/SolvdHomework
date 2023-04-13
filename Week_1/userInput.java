class userInput {
    public static void main(String args[]){
        System.out.println("Hello! What is your name?");
        String name = System.console().readLine();
        System.out.println("Nice to meet you, " + name + "!");
    }
}