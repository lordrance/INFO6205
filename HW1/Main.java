
public class Main {
    public static void main(String[] args) {
        Bag<Integer> intBag = new Bag<>();

        // Add elements
        intBag.add(1);
        intBag.add(2);
        intBag.add(3);

        // Display bag contents
        System.out.println("Bag contains: " + intBag.toString());

        // Check if bag contains an element
        System.out.println("Bag contains 2: " + intBag.contains(2));

        // Grab a random element
        System.out.println("A random element from the bag: " + intBag.grab());

        // Check if bag is empty
        System.out.println("Is the bag empty? " + intBag.isEmpty());

        // Remove an element
        System.out.println("Remove element 2: " + intBag.remove(2));
        System.out.println("Bag contents after removal: " + intBag.toString());

        // Size of the bag
        System.out.println("Size of the bag: " + intBag.size());

        // Convert to array
        Object[] array = intBag.toArray();
        System.out.print("Elements in the bag as an array: ");
        for (Object element : array) {
           System.out.print(element + " ");
        }
        System.out.println();

        // Clear the bag
        intBag.clear();
        System.out.println("Bag cleared. Is the bag empty? " + intBag.isEmpty());
    }
}
