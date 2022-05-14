class Tree {
    int height;

    Tree() {
        System.out.println("Planting a seedling");
        height = 0;
    }

    Tree(int initialHeight) {
        height = initialHeight;
        System.out.println("Creating new tree that is " + height + " feet tall");
    }

    void info() {
        System.out.println("Tree is " + height + " feet tall");
    }

    void info(String s) {
        System.out.println(s + ": Tree is " + height + " feet tall");

    }
}
    public class Overloading{
        public static void main(String[] args){
            for(int i = 0; i<5; i++){
                Tree t = new Tree(i);t.info();
                t.info("overloading method");
            }
            // Overloaded constructor:
            new Tree();
        }
    }
