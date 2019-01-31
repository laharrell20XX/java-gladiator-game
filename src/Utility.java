class Utility extends java.util.Random {
     static int randInt(int low, int high) {
//  produces a number between low (inclusive) and high (exclusive)
        return (int) (Math.random() * (high - low)) + low;
    }
    static int randInt(int high) {
//        produces a number between 0 (inclusive) and high (exclusive)
        return (int) (Math.random() * high);
    }
}
